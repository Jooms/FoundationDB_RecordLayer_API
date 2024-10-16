package com.jooms.tickettracker.cli.withproxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

import com.jooms.tickettracker.TicketTracker.Ticket;
import com.jooms.tickettracker.client.TicketTrackerClient;
import com.jooms.tickettracker.data.TicketLayer;

public class ProxyCli {
    private static Random rand;

    static String USAGE = "cli [host] [port] [command] <args ...>\n" +
            "commands:\n" +
            "\tcreate-single: <amount>\n" + 
            "\tcreate-multiple: <batchSize> <amountOfBatches>\n" + 
            "\tget-single: <amount>\n" + 
            "\tget-multiple: <times>\n" + 
            "\tdelete-all\n";

    private static void Usage(String[] args) {
        System.out.println(USAGE);

        System.out.println(String.format("Saw %d arguments:", args.length));
        for (String arg : args) {
            System.out.println("\t" + arg);
        }
    }

    private static Ticket randomTicket(int id) {
        String key = String.format("key-%d-%d", id, rand.nextInt(1000));
        String title = String.format("title-%d-%d", id, rand.nextInt(1000));
        String desc = String.format("desc-%d-%d", id, rand.nextInt(1000));

        // Craft Ticket
        return TicketLayer.buildTicket(id, TicketLayer.ticketType.WORK, key, title, desc);
    }

    private static class Durations {
        public Durations() {
        };

        public long generationTime = 0;
        public long executionTime = 0;
    }

    private static Durations createSingle(String[] args, TicketTrackerClient cl) {
        Durations d = new Durations();

        if (args.length < 4) {
            Usage(args);
            System.out.println("Missing an amount!");
            return d;
        }
        int amount = Integer.parseInt(args[3]);
        ArrayList<Ticket> ticketsToCreate = new ArrayList<Ticket>();
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            ticketsToCreate.add(randomTicket(i));
        }
        d.generationTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Generated %d tickets!", amount));
        startTime = System.nanoTime();
        for (Ticket t : ticketsToCreate) {
            cl.createTicket(t);
        }
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Created %d tickets!", amount));
        return d;
    }

    private static Durations createMultiple(String[] args, TicketTrackerClient cl) {
        Durations d = new Durations();

        if (args.length < 5) {
            Usage(args);
            System.out.println("Missing a batchSize and an amount of batches!");
            return d;
        }
        int batchSize = Integer.parseInt(args[3]);
        int amount = Integer.parseInt(args[4]);
        ArrayList<ArrayList<Ticket>> ticketsToCreate = new ArrayList<ArrayList<Ticket>>();
        long startTime = System.nanoTime();
        for (int i = 0; i < batchSize; i++) {
            ArrayList<Ticket> batchTickets = new ArrayList<Ticket>();
            for (int j = 0; j < amount; j++) {
                batchTickets.add(randomTicket(i * batchSize + j));
            }
            ticketsToCreate.add(batchTickets);
        }
        d.generationTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Generated %d tickets %d times!", batchSize, amount));
        startTime = System.nanoTime();
        for (ArrayList<Ticket> ts : ticketsToCreate) {
            cl.createTickets(ts);
        }
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Created %d tickets %d times!", batchSize, amount));
        return d;
    }

    private static Durations getSingle(String[] args, TicketTrackerClient cl) {
        Durations d = new Durations();

        if (args.length < 4) {
            Usage(args);
            System.out.println("Missing an amount!");
            return d;
        }
        int amount = Integer.parseInt(args[3]);
        long startTime = System.nanoTime();
        // Get all
        List<Ticket> lt = cl.getTickets();
        if (lt == null) {
            System.out.println("FAILED TO GET TICKETS!");
            return d;
        }
        ArrayList<Ticket> allTicks = new ArrayList<Ticket>(lt);
        System.out.println(String.format("Found %d tickets!", allTicks.size()));

        // Shuffle ids
        Collections.shuffle(allTicks);
        d.generationTime = (System.nanoTime() - startTime);
        System.out.println("Prepared tickets!");
        startTime = System.nanoTime();
        // Get "amount" tickets
        for (int i = 0; i < amount; i++) {
            // i % allTicks size so if we want more than we have we loop around.
            cl.getTicket(allTicks.get(i % allTicks.size()).getId());
        }
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Read %d tickets!", amount));
        return d;
    }

    private static Durations getAll(String[] args, TicketTrackerClient cl) {
        Durations d = new Durations();

        if (args.length < 4) {
            Usage(args);
            System.out.println("Missing a number of times!");
            return d;
        }
        int numTimes = Integer.parseInt(args[3]);
        long startTime = System.nanoTime();
        for (int i = 0; i < numTimes; i++) {
            cl.getTickets();
        }
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Got all tickets %d time(s)!", numTimes));
        return d;
    }

    private static Durations deleteAll(TicketTrackerClient cl) {
        Durations d = new Durations();

        long startTime = System.nanoTime();
        cl.deleteAll();
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println("Deleted all tickets!");
        return d;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            Usage(args);
            return;
        }

        int port = Integer.parseInt(args[1]);
        String target = args[0] + ":" + port;
        rand = new Random();

        System.out.println(String.format("Will be using the following target: %s", target));

        // Create Client
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        TicketTrackerClient cl = new TicketTrackerClient(channel, false);

        Durations d = new Durations();
        switch (args[2]) {
            case "create-single":
                d = createSingle(args, cl);
                break;
            case "create-multiple":
                d = createMultiple(args, cl);
                break;
            case "get-single":
                d = getSingle(args, cl);
                break;
            case "get-multiple":
                d = getAll(args, cl);
                break;
            case "delete-all":
                d = deleteAll(cl);
                break;
            default:
                Usage(args);
        }

        System.out.println(String.format("Command '%s' runtime:", args[2]));
        System.out.println(String.format("\tGeneration Time (ms): %d", d.generationTime / 1000000));
        System.out.println(String.format("\tExecution Time (ms): %d", d.executionTime / 1000000));

        channel.shutdown();
    }
}
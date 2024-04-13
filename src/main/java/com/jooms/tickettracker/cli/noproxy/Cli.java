package com.jooms.tickettracker.cli.noproxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabaseFactory;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordContext;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordStore;
import com.jooms.tickettracker.TicketTracker.Ticket;
import com.jooms.tickettracker.data.TicketLayer;

public class Cli {
    private static Random rand;

    static String USAGE = "cli [command] <args ...>\n" +
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

    private static Durations createSingle(String[] args, TicketLayer tl) {
        Durations d = new Durations();
        
        Function<FDBRecordContext, FDBRecordStore> rsp = tl.getRecordStoreProvider();

        if (args.length < 2) {
            Usage(args);
            System.out.println("Missing an amount!");
            return d;
        }
        int amount = Integer.parseInt(args[1]);
        ArrayList<Ticket> ticketsToCreate = new ArrayList<Ticket>();
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            ticketsToCreate.add(randomTicket(i));
        }
        d.generationTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Generated %d tickets!", amount));
        startTime = System.nanoTime();
        for (Ticket t : ticketsToCreate) {
            tl.save(rsp, t);
        }
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Created %d tickets!", amount));
        return d;
    }

    private static Durations createMultiple(String[] args, TicketLayer tl) {
        Durations d = new Durations();
        
        Function<FDBRecordContext, FDBRecordStore> rsp = tl.getRecordStoreProvider();

        if (args.length < 3) {
            Usage(args);
            System.out.println("Missing a batchSize and an amount of batches!");
            return d;
        }
        int batchSize = Integer.parseInt(args[1]);
        int amount = Integer.parseInt(args[2]);
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
            tl.saveMultiple(rsp, ts);
        }
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Created %d tickets %d times!", batchSize, amount));
        return d;
    }

    private static Durations getSingle(String[] args, TicketLayer tl) {
        Durations d = new Durations();
        
        Function<FDBRecordContext, FDBRecordStore> rsp = tl.getRecordStoreProvider();

        if (args.length < 2) {
            Usage(args);
            System.out.println("Missing an amount!");
            return d;
        }
        int amount = Integer.parseInt(args[1]);
        long startTime = System.nanoTime();
        // Get all
        List<Ticket> lt = tl.getMultiple(rsp);
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
            tl.get(rsp, allTicks.get(i % allTicks.size()).getId());
        }
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Read %d tickets!", amount));
        return d;
    }

    private static Durations getAll(String[] args, TicketLayer tl) {
        Durations d = new Durations();

        Function<FDBRecordContext, FDBRecordStore> rsp = tl.getRecordStoreProvider();

        if (args.length < 2) {
            Usage(args);
            System.out.println("Missing a number of times!");
            return d;
        }
        int numTimes = Integer.parseInt(args[1]);
        long startTime = System.nanoTime();
        for (int i = 0; i < numTimes; i++) {
            tl.getMultiple(rsp);
        }
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println(String.format("Got all ticket %d time(s)!", numTimes));
        return d;
    }

    private static Durations deleteAll(TicketLayer tl) {
        Durations d = new Durations();

        Function<FDBRecordContext, FDBRecordStore> rsp = tl.getRecordStoreProvider();

        long startTime = System.nanoTime();
        tl.deleteAll(rsp);
        d.executionTime = (System.nanoTime() - startTime);
        System.out.println("Deleted all tickets!");
        return d;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            Usage(args);
            return;
        }

        rand = new Random();

        System.out.println("Will be using the record layer library");

        // Create DB
        FDBDatabase db = FDBDatabaseFactory.instance().getDatabase();

        // Set up DAL
        TicketLayer tl = new TicketLayer(db, "TicketTracker");

        Durations d = new Durations();
        switch (args[0]) {
            case "create-single":
                d = createSingle(args, tl);
                break;
            case "create-multiple":
                d = createMultiple(args, tl);
                break;
            case "get-single":
                d = getSingle(args, tl);
                break;
            case "get-multiple":
                d = getAll(args, tl);
                break;
            case "delete-all":
                d = deleteAll(tl);
                break;
            default:
                Usage(args);
        }

        System.out.println(String.format("Command '%s' runtime:", args[0]));
        System.out.println(String.format("\tGeneration Time (ms): %d", d.generationTime / 1000000));
        System.out.println(String.format("\tExecution Time (ms): %d", d.executionTime / 1000000));
    }
}
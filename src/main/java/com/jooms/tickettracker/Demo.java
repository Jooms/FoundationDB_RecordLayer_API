package com.jooms.tickettracker;

import java.io.IOException;
import java.util.List;

import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabaseFactory;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

import com.jooms.tickettracker.TicketTracker.Ticket;
import com.jooms.tickettracker.client.TicketTrackerClient;
import com.jooms.tickettracker.data.TicketLayer;
import com.jooms.tickettracker.server.TicketTrackerServer;

public class Demo {
    
    public static void main(String[] args) {
        System.out.println("STARTING!!!");

        int port = 8000;
        String target = "localhost:" + port;

        // Create DB
        FDBDatabase db = FDBDatabaseFactory.instance().getDatabase();

        // Set up DAL
        TicketLayer tl = new TicketLayer(db);

        // Create Server with DAL
        TicketTrackerServer serv;
        try {
            serv = new TicketTrackerServer(port, tl);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Start Server
        try {
            serv.start();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Create Client
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
        .build();
        TicketTrackerClient cl = new TicketTrackerClient(channel);

        // Craft Ticket
        // Ticket t = TicketLayer.buildTicket(5, TicketLayer.ticketType.WORK, "fifth", "The fifth one", "Still no description");

        // Create Ticket
        // cl.createTicket(t);

        // Get Ticket
        // Ticket rt = cl.getTicket(t.getId());
        // System.out.println("Got ticket: " + rt);

        // Get Tickets
        List<Ticket> ts = cl.getTickets();
        System.out.println("Got tickets: " + ts);

        channel.shutdown();
        try {
            serv.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ENDING!!!");
    }
}
package com.jooms.tickettracker;

import java.io.IOException;

import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabaseFactory;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;

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
        TicketTracker.Ticket t = TicketLayer.buildTicket(5, TicketLayer.ticketType.WORK, "fifth", "The fifth one", "Still no description");

        // Create Ticket
        cl.createTicket(t);

        // Get Ticket
        TicketTracker.Ticket rt = cl.getTicket(t.getId());
        System.out.println("Got ticket: " + rt);

        // Block Until Shutdown
        // try {
        //     serv.blockUntilShutdown();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        channel.shutdown();

        System.out.println("ENDING!!!");
    }
}
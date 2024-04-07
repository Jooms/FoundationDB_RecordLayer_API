package com.jooms.tickettracker;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabaseFactory;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordContext;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordStore;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;


public class Demo {
    
    public static void main(String[] args) {
        System.out.println("STARTING!!!");

        int port = 8000;
        String target = "localhost:" + port;

        // Create DB
        // FDBDatabase db = FDBDatabaseFactory.instance().getDatabase();

        // Set up DAL
        // TicketLayer tl = new TicketLayer(db);

        // Create Server with DAL
        TicketTrackerServer serv;
        try {
            serv = new TicketTrackerServer(port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }

        // Start Server
        try {
            serv.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }


        // Create Client
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
        .build();
        TicketTrackerClient cl = new TicketTrackerClient(channel);

        // Send Request
        cl.sayHello("Sup cats");
        channel.shutdown();

        // Block Until Shutdown
        // try {
        //     serv.blockUntilShutdown();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        // TicketTracker.Ticket t = TicketLayer.buildTicket(1, TicketLayer.ticketType.WORK, "first", "The first one", "No description");
        // TicketTracker.Ticket t2 = TicketLayer.buildTicket(2, TicketLayer.ticketType.NEW_FUNCTIONALITY, "second", "new functionality", "Add stuff");

        // Function<FDBRecordContext, FDBRecordStore> rsProvider = tl.getRecordStoreProvider();
        // db.run(context -> {
        //     FDBRecordStore recordStore = rsProvider.apply(context);

        //     TicketLayer.save(recordStore, t);
        //     TicketLayer.save(recordStore, t2);

        //     return null;
        // });

        // TicketTracker.Ticket t3 = tl.get(rsProvider, t.getId());
        // System.out.println(t3);


        // db.run(context -> {
        //     FDBRecordStore recordStore = rsProvider.apply(context);

        //     TicketTracker.Ticket t4 = TicketLayer.get(recordStore, t2.getId());
        //     System.out.println(t4);

        //     return null;
        // });


        System.out.println("ENDING!!!");
    }
}
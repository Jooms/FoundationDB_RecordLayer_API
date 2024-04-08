package com.jooms.tickettracker;

import java.util.function.Function;

import com.apple.foundationdb.record.RecordMetaData;
import com.apple.foundationdb.record.RecordMetaDataBuilder;
import com.apple.foundationdb.record.metadata.Key;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordContext;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordStore;
import com.apple.foundationdb.record.provider.foundationdb.FDBStoredRecord;
import com.apple.foundationdb.record.provider.foundationdb.keyspace.KeySpace;
import com.apple.foundationdb.record.provider.foundationdb.keyspace.KeySpaceDirectory;
import com.apple.foundationdb.record.provider.foundationdb.keyspace.KeySpacePath;
import com.apple.foundationdb.tuple.Tuple;
import com.google.protobuf.Message;


public class TicketLayer {
    private KeySpacePath path;
    private FDBDatabase db;
    private RecordMetaData recordMetaData;

    public enum ticketType {
        WORK,
        NEW_FUNCTIONALITY,
        BROKEN_FUNCTIONALITY,
    }

    public TicketLayer(FDBDatabase db) {
        this.db = db;

        KeySpace keySpace = new KeySpace(new KeySpaceDirectory("TicketTracker", KeySpaceDirectory.KeyType.STRING, "TicketTracker"));
        path = keySpace.path("TicketTracker");

        RecordMetaDataBuilder metaDataBuilder = RecordMetaData.newBuilder()
        .setRecords(TicketTracker.getDescriptor());

        metaDataBuilder.getRecordType("Ticket")
        .setPrimaryKey(Key.Expressions.field("id"));

        // metaDataBuilder.addIndex("Ticket", new Index("priceIndex", Key.Expressions.field("price")));

        recordMetaData = metaDataBuilder.build();
    }

    public static TicketTracker.Ticket buildTicket(int id, ticketType type, String key, String title, String desc) {
        TicketTracker.Ticket.Builder t = TicketTracker.Ticket.newBuilder().setId(id);

        switch (type) {
            case WORK:
                t.setType(TicketTracker.TicketType.Work);
                break;
            case NEW_FUNCTIONALITY:
                t.setType(TicketTracker.TicketType.NewFunctionality);
                break;
            case BROKEN_FUNCTIONALITY:
                t.setType(TicketTracker.TicketType.BrokenFunctionality);
                break;
            default:
                break;
        }
        if (!key.isEmpty()) {
            t.setKey(key);
        }
        if (!title.isEmpty()) {
            t.setTitle(title);
        }
        if (!desc.isEmpty()) {
            t.setDescription(desc);
        }

        return  t.build();
    }

    public Function<FDBRecordContext, FDBRecordStore> getRecordStoreProvider() {
        Function<FDBRecordContext, FDBRecordStore> recordStoreProvider = context -> FDBRecordStore.newBuilder()
        .setMetaDataProvider(this.recordMetaData)
        .setContext(context)
        .setKeySpacePath(this.path)
        .createOrOpen();

        return recordStoreProvider;
    }

    // Non-static gets and saves
    public TicketTracker.Ticket get(Function<FDBRecordContext, FDBRecordStore> recordStoreProvider, int id) {
        FDBStoredRecord<Message> msg = db.run(context ->
            recordStoreProvider.apply(context).loadRecord(Tuple.from(id))
        );

        if (msg == null) {
            return null;
        }

        return TicketTracker.Ticket.newBuilder().mergeFrom(msg.getRecord()).build();
    }

    public void save(Function<FDBRecordContext, FDBRecordStore> recordStoreProvider, TicketTracker.Ticket t) {
        db.run(context ->
           recordStoreProvider.apply(context).saveRecord(t)
        );
   }
    
    // Static Gets and Saves
    public static TicketTracker.Ticket get(FDBRecordStore recordStore, int id) {
        FDBStoredRecord<Message> msg = recordStore.loadRecord(Tuple.from(id));

       if (msg == null) {
           return null;
       }

       return TicketTracker.Ticket.newBuilder().mergeFrom(msg.getRecord()).build();
   }

    public static void save(FDBRecordStore recordStore, TicketTracker.Ticket t) {
        recordStore.saveRecord(t);
    }
}
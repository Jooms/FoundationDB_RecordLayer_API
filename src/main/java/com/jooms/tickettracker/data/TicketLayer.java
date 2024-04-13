package com.jooms.tickettracker.data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.apple.foundationdb.record.RecordCursor;
import com.apple.foundationdb.record.RecordCursorIterator;
import com.apple.foundationdb.record.RecordMetaData;
import com.apple.foundationdb.record.RecordMetaDataBuilder;
import com.apple.foundationdb.record.metadata.Key;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBQueriedRecord;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordContext;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordStore;
import com.apple.foundationdb.record.provider.foundationdb.FDBStoredRecord;
import com.apple.foundationdb.record.provider.foundationdb.keyspace.KeySpace;
import com.apple.foundationdb.record.provider.foundationdb.keyspace.KeySpaceDirectory;
import com.apple.foundationdb.record.provider.foundationdb.keyspace.KeySpacePath;
import com.apple.foundationdb.record.query.RecordQuery;
import com.apple.foundationdb.tuple.Tuple;
import com.google.protobuf.Message;

import com.jooms.tickettracker.TicketTracker;
import com.jooms.tickettracker.TicketTracker.Ticket;
import com.jooms.tickettracker.TicketTracker.TicketType;

public class TicketLayer {
    final private KeySpacePath path;
    final private FDBDatabase db;
    final private RecordMetaData recordMetaData;
    final private static String recordType = "Ticket";
    final private static String primaryKey = "id";

    public enum ticketType {
        WORK,
        NEW_FUNCTIONALITY,
        BROKEN_FUNCTIONALITY,
    }

    public TicketLayer(FDBDatabase db, String namespace) {
        this.db = db;

        KeySpace keySpace = new KeySpace(
                new KeySpaceDirectory(namespace, KeySpaceDirectory.KeyType.STRING, namespace));
        path = keySpace.path(namespace);

        RecordMetaDataBuilder metaDataBuilder = RecordMetaData.newBuilder()
                .setRecords(TicketTracker.getDescriptor());

        metaDataBuilder.getRecordType(TicketLayer.recordType)
                .setPrimaryKey(Key.Expressions.field(TicketLayer.primaryKey));

        // metaDataBuilder.addIndex("Ticket", new Index("priceIndex",
        // Key.Expressions.field("price")));

        recordMetaData = metaDataBuilder.build();
    }

    public static Ticket buildTicket(int id, ticketType type, String key, String title, String desc) {
        Ticket.Builder t = Ticket.newBuilder().setId(id);

        switch (type) {
            case WORK:
                t.setType(TicketType.Work);
                break;
            case NEW_FUNCTIONALITY:
                t.setType(TicketType.NewFunctionality);
                break;
            case BROKEN_FUNCTIONALITY:
                t.setType(TicketType.BrokenFunctionality);
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

        return t.build();
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
    public Ticket get(Function<FDBRecordContext, FDBRecordStore> recordStoreProvider, int id) {
        return db.run(context -> {
            return get(recordStoreProvider.apply(context), id);
        });
    }

    public ArrayList<Ticket> getMultiple(Function<FDBRecordContext, FDBRecordStore> recordStoreProvider) {
        return db.run(context -> {
            return getMultiple(recordStoreProvider.apply(context));
        });
    }

    public void save(Function<FDBRecordContext, FDBRecordStore> recordStoreProvider, Ticket t) {
        db.run(context -> save(recordStoreProvider.apply(context), t));
    }

    public void saveMultiple(Function<FDBRecordContext, FDBRecordStore> recordStoreProvider, List<Ticket> ts) {
        db.run(context -> {
            saveMultiple(recordStoreProvider.apply(context), ts);
            return true;
        });
    }

    public void deleteAll(Function<FDBRecordContext, FDBRecordStore> recordStoreProvider) {
        db.run(context -> {
            deleteAll(recordStoreProvider.apply(context));
            return true;
        });
    }

    // Static Gets and Saves
    public static Ticket get(FDBRecordStore recordStore, int id) {
        FDBStoredRecord<Message> msg = recordStore.loadRecord(Tuple.from(id));

        if (msg == null) {
            return null;
        }

        return Ticket.newBuilder().mergeFrom(msg.getRecord()).build();
    }

    private static ArrayList<Ticket> getMultiple(FDBRecordStore recordStore) {
        RecordQuery query = RecordQuery.newBuilder()
                .setRecordType(TicketLayer.recordType)
                .setSort(Key.Expressions.field(TicketLayer.primaryKey))
                .build();

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        try (RecordCursor<FDBQueriedRecord<Message>> cursor = recordStore.executeQuery(query)) {
            RecordCursorIterator<FDBQueriedRecord<Message>> iter = cursor.asIterator();
            while (iter.hasNext()) {
                FDBQueriedRecord<Message> rec = iter.next();
                if (rec != null) {
                    Ticket t = Ticket.newBuilder().mergeFrom(rec.getRecord()).build();
                    tickets.add(t);
                }
            }
        }

        return tickets;
    }

    public static FDBStoredRecord<Message> save(FDBRecordStore recordStore, Ticket t) {
        return recordStore.saveRecord(t);
    }

    public static void saveMultiple(FDBRecordStore recordStore, List<Ticket> ts) {
        for (Ticket t : ts) {
            recordStore.saveRecord(t);
        }
    }

    
    public static void deleteAll(FDBRecordStore recordStore) {
        recordStore.deleteAllRecords();
    }
}
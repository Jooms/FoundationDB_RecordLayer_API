import java.util.function.Function;

import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabaseFactory;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordContext;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordStore;


public class Demo {
    

    public static void main(String[] args) {
        System.out.println("STARTING!!!");
        FDBDatabase db = FDBDatabaseFactory.instance().getDatabase();

        TicketLayer tl = new TicketLayer(db);

        TicketTracker.Ticket t = TicketLayer.buildTicket(1, TicketLayer.ticketType.WORK, "first", "The first one", "No description");
        TicketTracker.Ticket t2 = TicketLayer.buildTicket(2, TicketLayer.ticketType.NEW_FUNCTIONALITY, "second", "new functionality", "Add stuff");

        Function<FDBRecordContext, FDBRecordStore> rsProvider = tl.getRecordStoreProvider();
        db.run(context -> {
            FDBRecordStore recordStore = rsProvider.apply(context);

            TicketLayer.save(recordStore, t);
            TicketLayer.save(recordStore, t2);

            return null;
        });

        TicketTracker.Ticket t3 = tl.get(rsProvider, t.getId());
        System.out.println(t3);


        db.run(context -> {
            FDBRecordStore recordStore = rsProvider.apply(context);

            TicketTracker.Ticket t4 = TicketLayer.get(recordStore, t2.getId());
            System.out.println(t4);

            return null;
        });


        System.out.println("ENDING!!!");
    }
}
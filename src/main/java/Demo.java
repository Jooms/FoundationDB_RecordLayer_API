import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabaseFactory;

public class Demo {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        FDBDatabase db = FDBDatabaseFactory.instance().getDatabase("fdb_config.cluster");
    }
}
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        try (var mongoClient = MongoClients.create()) {
            mongoClient.listDatabases().forEach((Consumer<Document>) System.out::println);
            // show dbs
            // Document{{name=test, sizeOnDisk=1.385336832E9, empty=false}}
            mongoClient.listDatabaseNames()
                    .forEach((Consumer<String>) System.out::println);
            // test
        }
    }
}

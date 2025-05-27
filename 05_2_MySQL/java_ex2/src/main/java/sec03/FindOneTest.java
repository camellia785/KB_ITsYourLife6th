package sec03;

import app.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        String id = "666a6296f4fe57189cd03eea";

        //Bson: Binary Json
        Bson query = eq("_id", new ObjectId(id));

        // 조건에 해당하는 document찾기
        // .first() : 찾은 document들 중 첫번째 document만 반환
        Document doc = collection.find(query).first();

        System.out.println("==> findByIdResult : " + doc);

        Database.close();
    }
}
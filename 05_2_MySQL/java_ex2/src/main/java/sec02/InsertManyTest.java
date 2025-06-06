package sec02;
import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
public class InsertManyTest {
    public static void main(String[] args) {

        // MongoCollection<Document> -> 특정 컬랙션에 접근하기 위한 객체 ex) rdb의 테이블 개념
        // Document -> MongoDB에 저장할 하나의 데이터를 구성하는객체, append()를 사용해 필드와 값추가
        // -> append("필드", "값")을 사용해 필드와 값을 추가
        MongoCollection<Document> collection = Database.getCollection("todo");

        List<Document> insertList = new ArrayList<>();
        Document document1 = new Document();
        Document document2 = new Document();

        document1.append("title", "Dune2 영화보기");
        document1.append("desc", "이번 주말 IMAX로 Dune2 영화보기");
        document1.append("done", false);
        document2.append("title", "Java MongoDB 연동");
        document2.append("desc", "Java로 MongoDB 연동 프로그래밍 연습하기");
        document2.append("done", false);

        insertList.add(document1);
        insertList.add(document2);

        // insertMany: list 형태의 Document를 쌓아 DB에 저장
        // InsertManyResult: 삽입결과 졍보를 담고 있음(삽입되니 도큐먼트의 ID)
        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());
        Database.close();
    }
}
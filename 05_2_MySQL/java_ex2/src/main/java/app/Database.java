package app;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

// DB관련 작업시 공통 절차는 모듈화를 통해 분리시켜 놓는 것이 편하다.
// 수정, 삭제 용이
public class Database {
    // 몽고디비 서버에 연결을 담당하는 객체
    static MongoClient client;

    // 몽고디비의 특정 DB에 접근하기위한 객체
    static MongoDatabase database;

    // static 정적 초기화블록
    // -> 클래스가 로드될때 한 번 실행됨
    static {

        // Java 클래스(pojo)를 몽고디비의 bson으로 자동변환해주는 codec을 제공하는 객체
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder()
                .automatic(true) // 자동 매핑 활성화
                .build();

        // mongoDB 클라이언트에서 사용할 Codec(직렬화/역질렬화 규칙) 모음
        // getDefaultCodecRegistry() 기본 Codec 설정
        // fromProviers: 사용자 정의 Codec 등록
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        // Connection을 맺기위한 URL 작성
        ConnectionString connectionString = new ConnectionString("mongodb://127.0.0.1:27017");
        client = MongoClients.create(connectionString);
//        database = client.getDatabase("todo_db");
        database = client.getDatabase("todo_db").withCodecRegistry(pojoCodecRegistry);
    }

    public static void close() {
        client.close();
    }


    public static MongoDatabase getDatabase() {
        return database;
    }

    public static MongoCollection<Document> getCollection(String colName) {
        MongoCollection<Document> collection = database.getCollection(colName);
        return collection;
    }

    public static <T> MongoCollection<T> getCollection(String colName, Class<T> clazz) {
        MongoCollection<T> collection = database.getCollection(colName, clazz);
        return collection;
    }

}
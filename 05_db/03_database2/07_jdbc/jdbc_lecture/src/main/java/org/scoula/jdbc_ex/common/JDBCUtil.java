package org.scoula.jdbc_ex.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // 싱글톤 패턴
    static Connection conn = null;

    public static Connection getConnection() {

        // 이미 conn 객체가 있다면 존재하는 객체 반환
        if (conn != null) return conn;

        // Properties 파일 읽어오기위한 객체 준비
        Properties prop = new Properties();
        try {
            // prop.load : Key-value 형태로 스트림으로 읽어곤 데이터 저장
            // getResourceAsStream : 파일내용을 InputStream으로 가져옴
            prop.load(jdbc.common.JDBCUtil.class.getResourceAsStream("/application.properties"));
            System.out.println("props" + prop);

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                throw new RuntimeException("DB 연결 종료 중 오류", e);
            }
        }
    }
}

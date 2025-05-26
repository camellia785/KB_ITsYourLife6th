package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionTest {

    @Test
    @DisplayName("connection 테스트")
    public void testConnection() throws SQLException, ClassNotFoundException {
        // testConnection 코드 작성!!
        // JDBC 연결 시도
        Connection conn = JDBCUtil.getConnection();
        assertNotNull(conn, "DB연결 실패, Connection = null");

    }

    @Test
    @DisplayName("JDBCUtil 클래스 기능 테스트")
    void testConnection2() throws SQLException{
        try(Connection conn = JDBCUtil.getConnection()){
            System.out.println("DB연결 성공");
        }
        // 테스트 코드

    }
}


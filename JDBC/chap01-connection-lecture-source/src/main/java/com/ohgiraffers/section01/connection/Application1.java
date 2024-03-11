package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  <h2>수업목표</h2>
 *  <br>해당 DBMS와 계정에 맞는 Connection 객체를 생성할 수 있다.(feat. DBMS Driver 추가)
 */
public class Application1 {
    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menudb", "swcamp", "swcamp");

            System.out.println("con = " + con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(con != null && !con.isClosed())
                    con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
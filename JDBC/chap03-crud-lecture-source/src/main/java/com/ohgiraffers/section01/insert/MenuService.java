package com.ohgiraffers.section01.insert;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

/* 설명: Service 계층 Connection 객체 생성 및 소멸(close) 및 비지니스 로직, 트랜잭션(commit, rollback) 처리 */
public class MenuService {
    public void registMenu(Menu registMenu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.registMenu(con, registMenu);

        if (result > 0) {
//            con.commit();         설명: -> try/catch로 지저분해 지니 JDBCTemplate에 static 메소드로 만들어 쓰자.
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

    }
}

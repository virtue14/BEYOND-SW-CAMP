package com.ohgiraffers.section02.update;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {
    public void modifyMenu(Menu modifyMenu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.modifyMenu(con, modifyMenu);

        if (result > 0) {
            commit(con);
            System.out.println("커밋~~~");
        } else {
            rollback(con);
            System.out.println("롤백~~~");
        }

        close(con);


    }
}

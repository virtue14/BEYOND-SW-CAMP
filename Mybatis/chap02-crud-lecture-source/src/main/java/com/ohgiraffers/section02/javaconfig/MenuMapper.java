package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {

    @Results(id = "menuResultMap", value = {
            @Result(id = true, property = "menuCode", column = "MENU_CODE"),
            @Result(property = "menuName", column = "MENU_NAME"),
            @Result(property = "menuPrice", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
    })

    @Select("""
                    SELECT
                    MENU_CODE
                    , MENU_NAME
                    , MENU_PRICE
                    , CATEGORY_CODE
                    , ORDERABLE_STATUS
                    FROM tbl_menu
            """)
    List<MenuDTO> selectAllMenus();

    @Select("""
                    SELECT
                    MENU_CODE
                    , MENU_NAME
                    , MENU_PRICE
                    , CATEGORY_CODE
                    , ORDERABLE_STATUS
                    FROM tbl_menu
                    WHERE MENU_CODE = #{menuCode}
            """)
    @ResultMap("menuResultMap")
    MenuDTO selectMenu(int menuCode);

    @Insert("""
                    INSERT
                    INTO tbl_menu
                    (
                    MENU_NAME
                    , MENU_PRICE
                    , CATEGORY_CODE
                    , ORDERABLE_STATUS
                    )
                    VALUES
                    (
                      #{menuName}
                    , #{menuPrice}
                    , #{categoryCode}
                    , 'Y'
                    )
            """)
    int insertMenu(MenuDTO menu);
    @Update("""
                    UPDATE
                           tbl_menu
                       SET MENU_NAME = #{menuName}
                         , MENU_PRICE = #{menuPrice}
                     WHERE MENU_CODE = #{menuCode}
            """)
    int updateMenu(MenuDTO menu);

    @Delete("""
                    DELETE
                      FROM tbl_menu
                     WHERE MENU_CODE = #{menuCode}
            """)
    int deleteMenu(int menuCode);
}

-- autocommit 비활성화
SET autocommit = 0;

START TRANSACTION;

INSERT
INTO tbl_menu
VALUES (NULL, '바나나해장국', 8500, 4, 'Y');

UPDATE tbl_menu
SET menu_name = '수정된 메뉴1'
WHERE menu_code = 5;

UPDATE tbl_menu
SET menu_name = '수정된 메뉴2'
WHERE menu_code = 6;

SELECT * FROM tbl_menu;

ROLLBACK;
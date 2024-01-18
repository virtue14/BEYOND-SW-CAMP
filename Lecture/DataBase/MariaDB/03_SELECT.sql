-- SELECT * FROM tbl_menu;
-- SELECT menu_code, menu_name, menu_price FROM tbl_menu;
SELECT
		 menu_code
		, menu_name
		, menu_price
	FROM tbl_menu;

DESC tbl_category;

SELECT
		 category_code
		, category_name
		, ref_category_code
	FROM tbl_category;

SELECT
       menu_name
		, category_name
	FROM tbl_menu a
	JOIN tbl_category b ON (a.category_code = b.category_code); 
	
	
SELECT 7+3;
SELECT 10 * 2;
SELECT 7+3 AS '합', 10 * 2 AS '곱';
SELECT 7+3 AS '합', 10 * 2 AS 곱입니다;
-- 특수 기호가 들어간 별칭은 싱글 쿼테이션(')을 사용해야한다.
SELECT 7+3 AS 합, 10 * 2 AS '곱 입니다.';

SELECT CONCAT('유',' ','관순');

SELECT NOW();
SELECT SYSDATE();
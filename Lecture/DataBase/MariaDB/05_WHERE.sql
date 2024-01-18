-- orderable_status = 'N'인 행들 조회하기
-- 주문 불가능한 메뉴 조회
SELECT
		 menu_name
		, menu_price
		, menu_code
		, orderable_status
	FROM tbl_menu
	WHERE orderable_status = 'N'
ORDER BY menu_name ASC;

-- DESC를 통한 컬럼명 빠르게 확인
DESC tbl_menu;

-- '기타' 카테고리에 해당하지 않는 메뉴를 조회하시오.
	-- 1. '기타' 카테고리의 번호 파악하기
SELECT * FROM tbl_category;
SELECT
		 *
	FROM tbl_category
	WHERE category_name = '기타';

	-- 2. '해당 번호를 가지지 않는 메뉴 조회	
SELECT
		 *
	FROM tbl_menu
-- 	WHERE category_code != 10
	WHERE category_code <> 10
ORDER BY menu_name ASC;

-- 10,000원 이상의 메뉴 조회
SELECT * FROM tbl_menu WHERE menu_price >= 10000 ORDER BY menu_price ASC;

-- 10,000원 미만의 메뉴 조회
SELECT * FROM tbl_menu WHERE menu_price < 10000 ORDER BY menu_price ASC;

-- 10,000원 이상 12,000원 이하 메뉴 조회
SELECT * FROM tbl_menu WHERE menu_price >= 10000 && menu_price <= 12000 ORDER BY menu_price ASC;
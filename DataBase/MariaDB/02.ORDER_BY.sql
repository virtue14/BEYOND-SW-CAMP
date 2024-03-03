-- ASC = ascending : 오름차순
-- DESC = decending : 내림차순

-- 오름차순
SELECT
		 menu_code
		, menu_name
		, menu_price
	FROM tbl_menu
-- 	ORDER BY menu_price ASC;
	ORDER BY menu_price;

-- 내림차순
SELECT
		 menu_code
	   , menu_name
		, menu_price
	FROM tbl_menu
ORDER BY menu_price DESC;

-- 컬럼의 순번을 활용한 정렬(실제 테이블의 순서가 아닌 조회할 때의 컬럼 순서 기준)
SELECT
		 menu_price	-- 1번 째
		, menu_name	-- 2번 째
	FROM tbl_menu
ORDER BY 1 ASC;
		
-- 별칭을 활용한 정렬
SELECT
		 menu_price AS '가격'
		 , menu_name AS '음식'
	FROM tbl_menu
ORDER BY 가격 DESC;	-- 별칭으로 정렬할 때는 별칭명에 single quatation(')을 붙이면 안된다.

-- 컬럼의 복수개로 정렬
SELECT
		 menu_price AS 가격
		, menu_name AS 메뉴이름
	FROM tbl_menu
ORDER BY 1 DESC, 2 ASC;	-- '가격'으로 내림차순 후 같은 가격일 시, '메뉴 이름'을 오름차순으로 조회

/* FIELD */
SELECT FIELD('a', 'b', 'z', 'a'); -- 2번 째 이후 인자 중에 1번째 인자의 값이 위치하는 값이 나옴(=3)

-- TABLE에서 조회 시 FIELD 활용
SELECT
		 FIELD(orderable_status, 'N', 'Y')
		, orderable_status
		, menu_name
		, menu_code
	FROM tbl_menu;

-- FIELD를 활용한 ORDER BY
SELECT
		 menu_name
		, orderable_status
	FROM tbl_menu
ORDER BY FIELD(orderable_status, 'N', 'Y') DESC;

/* NULL */
-- NULL 값에 대한 정렬
	-- 1. 오름차순 시 : NULL 값이 먼저 나옴
SELECT
		 *
	FROM tbl_category
ORDER BY ref_category_code ASC;

	-- 2. 내림차순 시 : NULL 값이 나중에 나옴
SELECT
		 *
	FROM tbl_category
ORDER BY ref_category_code DESC;

	-- 3. 오름차순에서 NULL이 나중에 나오도록 바꿈
SELECT
		 *
	FROM tbl_category
ORDER BY -ref_category_code DESC;

	-- 4. 내림차순에서 NULL이 처음에 오도록 바꿈
SELECT
		 *
	FROM tbl_category
ORDER BY -ref_category_code ASC;
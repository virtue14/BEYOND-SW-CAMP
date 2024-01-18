### INDEX
SELECT * FROM tbl_menu;

-- INDEX 생성
CREATE TABLE phone
(
    phone_code  INT PRIMARY KEY,
    phone_name  VARCHAR(100),
    phone_price DECIMAL(10, 2)
);

INSERT
INTO phone (phone_code, phone_name, phone_price)
VALUES (1, 'galaxyS23', 1200000),
       (2, 'iPhone14pro', 1433000),
       (3, 'galaxyZfold3', 1730000);

SELECT * FROM phone;

-- 단순조회
SELECT * FROM phone WHERE phone_name = 'galaxyS23';

-- 인덱스가 없는 컬럼을 WHERE절의 조건으로 활용한 조회 진행 시 EXPLAIN으로 쿼리 실행 계획 확인
EXPLAIN SELECT * FROM phone WHERE phone_name = 'galaxyS23';

-- WHERE절에 활용한 컴럼에 INDEX를 추가해보자.
CREATE INDEX idx_name ON phone (phone_name);
SHOW INDEX FROM phone;

-- INDEX 추가 후 다시 해당 컬럼을 조건으로 해서 조회
EXPLAIN SELECT * FROM phone WHERE phone_name = 'iPhone14Pro';

-- INDEX는 주가적으로 다시 달아주어야 된다.
OPTIMIZE TABLE phone;

-- INDEX 삭제 후 확인
DROP INDEX idx_name ON phone;
SHOW INDEX FROM phone;
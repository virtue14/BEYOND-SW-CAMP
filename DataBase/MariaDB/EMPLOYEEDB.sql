# 계정 생성 후 데이터베이스 활용
CREATE USER 'practice'@'%' IDENTIFIED BY 'practice';

SHOW DATABASES;

USE mysql;

SELECT *
FROM USER;


CREATE DATABASE employeedb;

SHOW DATABASES;

SHOW GRANTS FOR 'practice'@'%';

GRANT ALL PRIVILEGES ON employeedb.* TO 'practice'@'%';

SHOW GRANTS FOR 'practice'@'%';


-- 'practice' 계정 접속 후 employeedb를 통한 과제 풀기
USE employeedb;





# DDL(Data Definition Language)
-- Dropping existing tables if they exist
DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS DEPARTMENT;
DROP TABLE IF EXISTS JOB;
DROP TABLE IF EXISTS LOCATION;
DROP TABLE IF EXISTS NATIONAL;
DROP TABLE IF EXISTS SAL_GRADE;

-- DDL for Table DEPARTMENT
CREATE TABLE DEPARTMENT
(
    DEPT_ID     CHAR(2),
    DEPT_TITLE  VARCHAR(35),
    LOCATION_ID CHAR(2) NOT NULL,
    PRIMARY KEY (DEPT_ID)
);

-- DDL for Table EMPLOYEE
CREATE TABLE EMPLOYEE
(
    EMP_ID     VARCHAR(3),
    EMP_NAME   VARCHAR(20),
    EMP_NO     CHAR(14) NOT NULL,
    EMAIL      VARCHAR(25),
    PHONE      VARCHAR(12),
    DEPT_CODE  CHAR(2),
    JOB_CODE   CHAR(2)  NOT NULL,
    SAL_LEVEL  CHAR(2)  NOT NULL,
    SALARY     DECIMAL(10, 2),
    BONUS      DECIMAL(10, 2),
    MANAGER_ID VARCHAR(3),
    HIRE_DATE  DATE,
    ENT_DATE   DATE,
    ENT_YN     CHAR(1) DEFAULT 'N',
    PRIMARY KEY (EMP_ID)
);

-- DDL for Table JOB
CREATE TABLE JOB
(
    JOB_CODE CHAR(2),
    JOB_NAME VARCHAR(35),
    PRIMARY KEY (JOB_CODE)
);

-- DDL for Table LOCATION
CREATE TABLE LOCATION
(
    LOCAL_CODE    CHAR(2),
    NATIONAL_CODE CHAR(2) NOT NULL,
    LOCAL_NAME    VARCHAR(40),
    PRIMARY KEY (LOCAL_CODE)
);

-- DDL for Table NATIONAL
CREATE TABLE NATIONAL
(
    NATIONAL_CODE CHAR(2),
    NATIONAL_NAME VARCHAR(35),
    PRIMARY KEY (NATIONAL_CODE)
);

-- DDL for Table SAL_GRADE
CREATE TABLE SAL_GRADE
(
    SAL_LEVEL CHAR(2),
    MIN_SAL   DECIMAL(10, 2),
    MAX_SAL   DECIMAL(10, 2),
    PRIMARY KEY (SAL_LEVEL)
);





# DML(Data Manipulation Language)
-- Insertions for DEPARTMENT
INSERT INTO DEPARTMENT (DEPT_ID, DEPT_TITLE, LOCATION_ID)
VALUES ('D1', '인사관리부', 'L1'),
       ('D2', '회계관리부', 'L1'),
       ('D3', '마케팅부', 'L1'),
       ('D4', '국내영업부', 'L1'),
       ('D5', '해외영업1부', 'L2'),
       ('D6', '해외영업2부', 'L3'),
       ('D7', '해외영업3부', 'L4'),
       ('D8', '기술지원부', 'L5'),
       ('D9', '총무부', 'L1');

-- Insertions for EMPLOYEE
-- (Note: Replace 'RR/MM/DD' with '%y/%m/%d' in STR_TO_DATE for MariaDB)
INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID,
                      HIRE_DATE, ENT_DATE, ENT_YN)
VALUES ('200', '선동일', '621235-1985634', 'sun_di@greedy.com', '01099546325', 'D9', 'J1', 'S1', 8000000, 0.3, NULL,
        CAST('1990/02/06' AS DATE), NULL, 'N'),
       ('201', '송종기', '631156-1548654', 'song_jk@greedy.com', '01045686656', 'D9', 'J2', 'S1', 6000000, NULL, '200',
        CAST('2001/09/01' AS DATE), NULL, 'N'),
       ('202', '노옹철', '861015-1356452', 'no_oc@greedy.com', '01066656263', 'D9', 'J2', 'S4', 3700000, NULL, '201',
        CAST('2001/01/01' AS DATE), NULL, 'N'),
       ('203', '송은희', '631010-2653546', 'song_eh@greedy.com', '01077607879', 'D6', 'J4', 'S5', 2800000, NULL, '204',
        CAST('1996/05/03' AS DATE), NULL, 'N'),
       ('204', '유재식', '660508-1342154', 'yoo_js@greedy.com', '01099999129', 'D6', 'J3', 'S4', 3400000, 0.2, '200',
        CAST('2000/12/29' AS DATE), NULL, 'N'),
       ('205', '정중하', '770102-1357951', 'jung_jh@greedy.com', '01036654875', 'D6', 'J3', 'S4', 3900000, NULL, '204',
        CAST('1999/09/09' AS DATE), NULL, 'N'),
       ('206', '박나라', '630709-2054321', 'pack_nr@greedy.com', '01096935222', 'D5', 'J7', 'S6', 1800000, NULL, '207',
        CAST('2008/04/02' AS DATE), NULL, 'N'),
       ('207', '하이유', '690402-2040612', 'ha_iy@greedy.com', '01036654488', 'D5', 'J5', 'S5', 2200000, 0.1, '200',
        CAST('1994/07/07' AS DATE), NULL, 'N'),
       ('208', '김해술', '870927-1313564', 'kim_hs@greedy.com', '01078634444', 'D5', 'J5', 'S5', 2500000, NULL, '207',
        CAST('2004/04/30' AS DATE), NULL, 'N'),
       ('209', '심봉선', '750206-1325546', 'sim_bs@greedy.com', '0113654485', 'D5', 'J3', 'S4', 3500000, 0.15, '207',
        CAST('2011/11/11' AS DATE), NULL, 'N'),
       ('210', '윤은해', '650505-2356985', 'youn_eh@greedy.com', '0179964233', 'D5', 'J7', 'S5', 2000000, NULL, '207',
        CAST('2001/02/03' AS DATE), NULL, 'N'),
       ('211', '전형돈', '830807-1121321', 'jun_hd@greedy.com', '01044432222', 'D8', 'J6', 'S5', 2000000, NULL, '200',
        CAST('2012/12/12' AS DATE), NULL, 'N'),
       ('212', '장쯔위', '780923-2234542', 'jang_zw@greedy.com', '01066682224', 'D8', 'J6', 'S5', 2550000, 0.25, '211',
        CAST('2015/06/17' AS DATE), NULL, 'N'),
       ('213', '하동운', '621111-1785463', 'ha_dh@greedy.com', '01158456632', NULL, 'J6', 'S5', 2320000, 0.1, NULL,
        CAST('1999/12/31' AS DATE), NULL, 'N'),
       ('214', '방명수', '856795-1313513', 'bang_ms@greedy.com', '01074127545', 'D1', 'J7', 'S6', 1380000, NULL, '200',
        CAST('2010/04/04' AS DATE), NULL, 'N'),
       ('215', '대북혼', '881130-1050911', 'dae_bh@greedy.com', '01088808584', 'D5', 'J5', 'S4', 3760000, NULL, NULL,
        CAST('2017/06/19' AS DATE), NULL, 'N'),
       ('216', '차태연', '770808-1364897', 'cha_ty@greedy.com', '01064643212', 'D1', 'J6', 'S5', 2780000, 0.2, '214',
        CAST('2013/03/01' AS DATE), NULL, 'N'),
       ('217', '전지연', '770808-2665412', 'jun_jy@greedy.com', '01033624442', 'D1', 'J6', 'S4', 3660000, 0.3, '214',
        CAST('2007/03/20' AS DATE), NULL, 'N'),
       ('218', '이오리', '870427-2232123', 'lee_or@greedy.com', '01022306545', NULL, 'J7', 'S5', 2890000, NULL, NULL,
        CAST('2016/11/28' AS DATE), NULL, 'N'),
       ('219', '임시환', '660712-1212123', 'im_sh@greedy.com', NULL, 'D2', 'J4', 'S6', 1550000, NULL, NULL,
        CAST('1999/09/09' AS DATE), NULL, 'N'),
       ('220', '이중석', '770823-1113111', 'lee_js@greedy.com', NULL, 'D2', 'J4', 'S5', 2490000, NULL, NULL,
        CAST('2014/09/18' AS DATE), NULL, 'N'),
       ('221', '유하진', '800808-1123341', 'yoo_hj@greedy.com', NULL, 'D2', 'J4', 'S5', 2480000, NULL, NULL,
        CAST('1994/01/20' AS DATE), NULL, 'N'),
       ('222', '이태림', '760918-2854697', 'lee_tr@greedy.com', '01033000002', 'D8', 'J6', 'S5', 2436240, 0.35, '100',
        CAST('1994/01/20' AS DATE), CAST('2017/9/17' AS DATE), 'Y');

-- Insertions for JOB
INSERT INTO JOB (JOB_CODE, JOB_NAME)
VALUES ('J1', '대표'),
       ('J2', '부사장'),
       ('J3', '부장'),
       ('J4', '차장'),
       ('J5', '과장'),
       ('J6', '대리'),
       ('J7', '사원');

-- Insertions for LOCATION
INSERT INTO LOCATION (LOCAL_CODE, NATIONAL_CODE, LOCAL_NAME)
VALUES ('L1', 'KO', 'ASIA1'),
       ('L2', 'JP', 'ASIA2'),
       ('L3', 'CH', 'ASIA3'),
       ('L4', 'US', 'AMERICA'),
       ('L5', 'RU', 'EU');

-- Insertions for NATIONAL
INSERT INTO NATIONAL (NATIONAL_CODE, NATIONAL_NAME)
VALUES ('KO', '한국'),
       ('JP', '일본'),
       ('CH', '중국'),
       ('US', '미국'),
       ('RU', '러시아');

-- Insertions for SAL_GRADE
INSERT INTO SAL_GRADE (SAL_LEVEL, MIN_SAL, MAX_SAL)
VALUES ('S1', 6000000, 10000000),
       ('S2', 5000000, 5999999),
       ('S3', 4000000, 4999999),
       ('S4', 3000000, 3999999),
       ('S5', 2000000, 2999999),
       ('S6', 1000000, 1999999);

-- Committing the changes
COMMIT;
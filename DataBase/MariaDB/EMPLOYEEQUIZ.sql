-- <JOIN 미사용 연습문제> --
# 1. 모든 사원 모든 컬럼 조회
SELECT *
FROM employee;



# 2. 사원들의 사번(사원번호), 이름 조회
SELECT emp_id
     , emp_name
FROM employee;



# 3. 201번 사번의 사번 및 이름 조회
SELECT emp_id
     , emp_name
FROM employee
WHERE emp_id = '201';



# 4-1. employee 테이블에서 부서 코드가 'D9'인 사원 조회
SELECT *
FROM employee
WHERE dept_code = 'D9';

# 4-2. employee 테이블에서 직급 코드가 'J1'인 사원 조회
SELECT *
FROM employee
WHERE job_code = 'J1';



# 5. employee 테이블에서 급여가 300만원 이상(>=)인 사원의 사번, 이름, 부서코드, 급여를 조회하시오.
SELECT emp_id
     , emp_name
     , dept_code
     , salary
FROM employee
WHERE salary >= 3000000;



# 6. 부서코드가 'D6'이고 급여를 300만원보다 많이 받는 직원의 이름, 부서코드, 급여 조회
SELECT emp_name
     , dept_code
     , salary
FROM employee
WHERE dept_code = 'D6'
  AND salary > 3000000;



# 7. 보너스를 받지 않는 사원에 대한 사번, 직원명, 급여, 보너스를 조회
SELECT *
FROM employee;

SELECT emp_id
     , emp_name
     , salary
     , bonus
FROM employee
WHERE bonus IS NULL;



# 8. 'D9' 부서에서 근무하지 않는 사원의 사번, 이름, 부서코드를 조회
SELECT emp_id
     , emp_name
     , dept_code
FROM employee
WHERE dept_code <> 'D9';



# 9. employee 테이블에서 퇴사 여부가 N인 직원들 조회하고 사번, 이름, 입사일을 별칭을 사용해 조회해 보기(퇴사 여부 컬럼은 ENT_YN이고 N은 퇴사 안한 사람, Y는 퇴사 한 사람)
SELECT emp_id    AS '사번'
     , emp_name  AS '이름'
     , hire_date AS '입사일'
FROM employee
WHERE ent_yn = 'N';



# 10. employee 테이블에서 급여 350만원 이상 550만원 이하를 받는 직원의 사번, 이름, 급여, 부서코드, 직급코드를 별칭을 사용해 조회해 보기
SELECT emp_id    AS '사번'
     , emp_name  AS '이름'
     , salary    AS '급여'
     , dept_code AS '부서코드'
     , job_code  AS '직급코드'
FROM employee
--  WHERE salary >= 3500000
--    AND salary <= 5500000;
WHERE salary BETWEEN 3500000 AND 5500000;



# 11. employee 테이블에서 '성이 김씨'인 직원의 사번, 이름, 입사일 조회
SELECT emp_id
     , emp_name
     , hire_date
FROM employee
WHERE emp_name LIKE '김%';



# 12. employee 테이블에서 '성이 김씨'가 아닌 직원의 사번, 이름, 입사일 조회
SELECT emp_id
     , emp_name
     , hire_date
FROM employee
WHERE NOT emp_name LIKE '김%';



# 13. EMPLOYEE 테이블에서 '하'문자가 이름에 포함 된 직원의 이름, 주민번호, 부서코드 조회
SELECT EMP_NAME
     , EMP_NO
     , DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';



# 14. 'J2'직급이면서 급여가 200만원 이상인 직원이거나 'J7'직급인 직원의 이름, 급여, 직급코드 조회
SELECT EMP_NAME
     , SALARY
     , JOB_CODE
FROM EMPLOYEE
WHERE JOB_CODE = 'J2'
    AND SALARY >= 2000000
   OR JOB_CODE = 'J7';



# 15. 'J2'직급이거나 'J7'직급인 직원들 중에 급여가 200만원 이상인 직원의 이름, 급여, 직급코드 조회
SELECT EMP_NAME
     , SALARY
     , JOB_CODE
FROM EMPLOYEE
WHERE (JOB_CODE = 'J2'
    OR JOB_CODE = 'J7')
  AND SALARY >= 2000000;



# 16. IN 연산자로 업그레이드
SELECT EMP_NAME
     , SALARY
     , JOB_CODE
FROM EMPLOYEE
WHERE JOB_CODE IN ('J2', 'J7')
  AND SALARY >= 2000000;





-- <JOIN 사용 연습문제> --
# 1. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.(1명)
SELECT A.EMP_ID
     , A.EMP_NAME
     , B.DEPT_TITLE
FROM EMPLOYEE A
         LEFT JOIN DEPARTMENT B ON (A.DEPT_CODE = B.DEPT_ID)
WHERE A.EMP_NAME LIKE '%형%';



# 2. 해외영업팀에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.(9명)
SELECT *
FROM EMPLOYEE;
SELECT *
FROM DEPARTMENT;

-- 해외영업팀 부서 코드 조회
SELECT A.DEPT_ID
FROM DEPARTMENT A
WHERE A.DEPT_TITLE LIKE '%해외영업%'; -- D5, D6, D7

SELECT A.EMP_NAME   "사원명"
     , C.JOB_NAME   "직급명"
     , A.DEPT_CODE  "부서코드"
     , B.DEPT_TITLE "부서명"
FROM EMPLOYEE A
         JOIN DEPARTMENT B ON (A.DEPT_CODE = B.DEPT_ID)
         JOIN JOB C ON (A.JOB_CODE = C.JOB_CODE)
WHERE A.DEPT_CODE IN ('D5', 'D6', 'D7');



# 3. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.(8명)(INNER JOIN 결과)
SELECT A.EMP_NAME
     , A.BONUS
     , B.DEPT_TITLE
     , C.LOCAL_NAME
FROM EMPLOYEE A
         JOIN DEPARTMENT B ON (A.DEPT_CODE = B.DEPT_ID)
         JOIN LOCATION C ON (B.LOCATION_ID = C.LOCAL_CODE)
WHERE A.BONUS IS NOT NULL;

SELECT *
FROM LOCATION;
SELECT *
FROM DEPARTMENT;



# 4. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.(3명)
SELECT A.EMP_NAME   "사원명"
     , C.JOB_NAME   "직급명"
     , B.DEPT_TITLE "부서명"
     , D.LOCAL_NAME "근무지역명"
FROM EMPLOYEE A
         JOIN DEPARTMENT B ON (A.DEPT_CODE = B.DEPT_ID)
         JOIN JOB C ON (A.JOB_CODE = C.JOB_CODE)
         JOIN LOCATION D ON (B.LOCATION_ID = D.LOCAL_CODE)
WHERE B.DEPT_ID = 'D2';



# 5. 급여 테이블의 등급별 최소급여(MIN_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오. 연봉에 보너스포인트를 적용하시오.(20명)
SELECT A.EMP_NAME                               "사원명"
     , B.JOB_NAME                               "직급명"
     , A.SALARY                                 "급여"
--      , A.SALARY * ( 1 + NVL(A.BONUS, 0)) * 12 "연봉"
     , A.SALARY * (1 + IFNULL(A.BONUS, 0)) * 12 "연봉"
FROM EMPLOYEE A
         JOIN JOB B ON (A.JOB_CODE = B.JOB_CODE)
         JOIN SAL_GRADE C ON (A.SAL_LEVEL = C.SAL_LEVEL)
WHERE A.SALARY > C.MIN_SAL;

-- 상관 서브쿼리를 활용해서 풀어보기
SELECT A.EMP_NAME                               AS 사원명,
       B.JOB_NAME                               AS 직급명,
       A.SALARY                                 AS 급여,
       A.SALARY * (1 + IFNULL(A.BONUS, 0)) * 12 AS 연봉
FROM EMPLOYEE A
         JOIN JOB B ON A.JOB_CODE = B.JOB_CODE
WHERE A.SALARY > (SELECT C.MIN_SAL
                  FROM SAL_GRADE C
                  WHERE A.SAL_LEVEL = C.SAL_LEVEL);


SELECT *
FROM SAL_GRADE;
SELECT *
FROM EMPLOYEE;



# 6. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.(15명)
SELECT A.EMP_NAME      "사원명"
     , B.DEPT_TITLE    "부서명"
     , C.LOCAL_NAME    "지역명"
     , D.NATIONAL_NAME "국가명"
FROM EMPLOYEE A
         JOIN DEPARTMENT B ON (A.DEPT_CODE = B.DEPT_ID)
         JOIN LOCATION C ON (B.LOCATION_ID = C.LOCAL_CODE)
         JOIN NATIONAL D ON (C.NATIONAL_CODE = D.NATIONAL_CODE)
WHERE C.NATIONAL_CODE IN ('KO', 'JP');

SELECT *
FROM DEPARTMENT;
SELECT *
FROM LOCATION;
SELECT *
FROM NATIONAL;



# 7. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름을 조회하시오.
-- self join 사용(60명)
SELECT A.EMP_NAME
     , A.DEPT_CODE
     , B.EMP_NAME
FROM EMPLOYEE A
         JOIN EMPLOYEE B ON (A.DEPT_CODE = B.DEPT_CODE) -- 동료 있는 사람만 조회하기 위해 INNER JOIN
WHERE A.EMP_ID != B.EMP_ID -- 나 자신을 제외한 동료만 조회(동명이인을 고려해 사번으로 비교)
-- 한 사람씩 확인하기 편하게 정렬
ORDER BY 1;



# 8. 보너스포인트가 없는 직원들 중에서 직급코드가 J4와 J7인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 IN 사용할 것(8명)
SELECT A.EMP_NAME
     , B.JOB_NAME
     , A.SALARY
FROM EMPLOYEE A
         JOIN JOB B ON (A.JOB_CODE = B.JOB_CODE)
WHERE A.JOB_CODE IN ('J4', 'J7')
  AND BONUS IS NULL;



# 9. 직급이 대리이면서 아시아 지역(ASIA1, ASIA2, ASIA3 모두 해당)에 근무하는 직원 조회
-- 사번(EMPLOYEE.EMP_ID), 이름(EMPLOYEE.EMP_NAME), 직급명(JOB.JOB_NAME), 부서명(DEPARTMENT.DEPT_TITLE), 근무지역명(LOCATION.LOCAL_NAME), 급여(EMPLOYEE.SALARY)를 조회하시오
-- (해당 컬럼을 찾고, 해당 컬럼을 지닌 테이블들을 찾고, 테이블들을 어떤 순서로 조인해야 하는지 고민하고 SQL문을 작성할 것)
SELECT A.EMP_ID
     , A.EMP_NAME
     , B.JOB_NAME
     , C.DEPT_TITLE
     , D.LOCAL_NAME
     , A.SALARY
FROM EMPLOYEE A
         JOIN JOB B ON (A.JOB_CODE = B.JOB_CODE)
         JOIN DEPARTMENT C ON (A.DEPT_CODE = C.DEPT_ID)
         JOIN LOCATION D ON (C.LOCATION_ID = D.LOCAL_CODE)
WHERE B.JOB_NAME = '대리'
--   AND D.LOCAL_NAME IN ('ASIA1', 'ASIA2', 'ASIA3');
  AND D.LOCAL_NAME LIKE '%ASIA%';
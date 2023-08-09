-- 작업 데이터베이스 변경
USE employees;

SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM DEPT_EMP;
SELECT * FROM TITLES;
SELECT * FROM SALARIES;
SELECT * FROM DEPT_MANAGER;

-- 1. 1990년도에 입사한 직원 조회
SELECT * 
FROM EMPLOYEES E
WHERE E.HIRE_DATE BETWEEN '1990-01-01' AND '1990-12-31'
ORDER BY E.HIRE_DATE DESC;

-- 2. 이름에 K가 포함된 직원 조회
SELECT E.EMP_NO, CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME) NAME, E.HIRE_DATE
FROM EMPLOYEES E
-- WHERE E.FIRST_NAME LIKE '%K%' OR E.FIRST_NAME LIKE '%k%' OR ...
-- WHERE LOWER(E.FIRST_NAME) LIKE '%k%' OR LOWER(E.LAST_NAME) LIKE '%k%'
WHERE LOWER(CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME)) LIKE '%k%';

-- 3. 성별 직원수 조회
-- 4. 사원 정보 조회 (employees 테이블의 모든 정보, 현재 부서이름, 현재 직급)
-- 5. 현재 개발부서(Development)에 근무하는 직원 정보 조회
-- 6. 현재 급여가 50000 ~ 60000인 직원 조회
-- 7. 부서별 직원의 평균 급여 조회
-- 8. 직급별 직원의 평균 급여
-- 9. 성별 평균 급여 조회
-- 10. 부서 이동 횟수가 2 이상인 직원 조회
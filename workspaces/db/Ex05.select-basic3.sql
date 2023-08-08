-- 작업 데이터베이스 변경
USE madang;

-- 고객 테이블과 주문 테이블을 조건 없이 연결해서 조회
SELECT *
FROM customer, orders;

-- 고객과 고객의 주문 데이터를 모두 조회
-- ( 고객의 이름을 포함해서 고객의 모든 주문 데이터 조회 )
SELECT customer.name, orders.*
FROM customer, orders
WHERE customer.custid = orders.custid; -- 양쪽 테이블에서 custid가 일치하는 행끼리 결합

SELECT c.name, o.*
FROM customer c, orders o -- 별칭 부여
WHERE c.custid = o.custid; -- 양쪽 테이블에서 custid가 일치하는 행끼리 결합

SELECT c.name, o.*
FROM customer c
INNER JOIN orders o
ON c.custid = o.custid; -- ON : join에 대한 where


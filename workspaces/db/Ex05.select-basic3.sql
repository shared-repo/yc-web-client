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

-- 고객의 이름과 고객 주문의 판매가격 조회
-- SELECT custid, name, saleprice -- 양쪽 테이블에 모두 존재하는 컬럼 사용 주의
SELECT c.custid, c.name, o.saleprice
FROM customer c, orders o
WHERE c.custid = o.custid
ORDER BY c.custid;

-- 고객별 주문 총액을 고객별로 정렬해서 조회
SELECT c.custid 고객번호, c.name 고객이름, SUM(o.saleprice) 주문총액
FROM customer c, orders o
WHERE c.custid = o.custid
GROUP BY c.custid, c.name
ORDER BY c.custid;

SELECT c.custid 고객번호, c.name 고객이름, SUM(o.saleprice) 주문총액
FROM customer c
INNER JOIN orders o
ON c.custid = o.custid
GROUP BY c.custid, c.name
ORDER BY c.custid;

-- 모든 주문에 대해 고객번호, 고객이름, 도서이름, 주문일자, 주문가격 조회
SELECT c.custid, c.name, b.bookname, o.saleprice, o.orderdate
FROM customer c, orders o, book b
WHERE c.custid = o.custid AND o.bookid = b.bookid;

SELECT c.custid, c.name, b.bookname, o.saleprice, o.orderdate
FROM customer c
INNER JOIN orders o
ON c.custid = o.custid
INNER JOIN book b
ON o.bookid = b.bookid;

-- 가격이 20000원인 도서를 구매한 고객의 이름, 도서명, 주문 정보 조회
SELECT c.custid, c.name, b.bookname, o.saleprice, o.orderdate
FROM customer c, orders o, book b
WHERE c.custid = o.custid AND o.bookid = b.bookid AND b.price = 20000;

SELECT c.custid, c.name, b.bookname, o.saleprice, o.orderdate
FROM customer c
INNER JOIN orders o
ON c.custid = o.custid
INNER JOIN book b
ON o.bookid = b.bookid
WHERE b.price = 20000;

-- 모든 고객의 고객별 주문 실적 조회 (고객아이디, 고객이름, 주문 건수, 주문 총액)
-- 문제 상황 확인
SELECT c.custid, c.name, COUNT(o.saleprice) 주문수량, SUM(o.saleprice) 주문총액
FROM customer c, orders o
WHERE c.custid = o.custid
GROUP BY c.custid, c.name;

SELECT 
	c.custid, c.name, 
    COUNT(o.saleprice) 주문수량, 
    COALESCE(SUM(o.saleprice), 0) 주문총액 -- COALESCE : NULL 값을 다른 값으로 대체
FROM customer c
LEFT OUTER JOIN orders o -- customer는 모두 조회, orders는 양쪽 모두 있는 경우만 조회
ON c.custid = o.custid
GROUP BY c.custid, c.name;



















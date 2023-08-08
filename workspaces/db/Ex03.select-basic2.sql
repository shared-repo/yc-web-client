-- 작업 데이터베이서 변경
USE madang;

DESC orders; -- orders 테이블의 정보 조회

-- 고객이 주문한 도서의 총 판매액 조회
SELECT SUM(saleprice)
FROM orders;

-- 고객이 주문한 도서의 총 판매액 조회 (컬럼명 변경)
SELECT SUM(saleprice) AS 총판매액 -- AS 생략 가능
FROM orders;

-- 김연아 고객의 총 도서 구매액 조회
SELECT custid
FROM customer
WHERE name = '김연아'; -- 김연아 고객의 custid 조회

SELECT SUM(saleprice) AS 총구매액
FROM orders
WHERE custid = 2;

-- 도서의 총판매액, 평균판매액, 최고판매액, 최저판매액 조회
SELECT 
	SUM(saleprice) AS 총판매액,
    AVG(saleprice) AS 평균판매액,
    MAX(saleprice) AS 최고판매액,
    MIN(saleprice) AS 최저판매액,
    COUNT(saleprice) AS 총판매건수
FROM
	orders;
    
-- 고객별 총구매액과 구매건수 조회
SELECT 
	custid 고객아이디, -- group by에 표현된 컬럼만 select에 포함 가능
    SUM(saleprice) 총구매액, 
    COUNT(saleprice) 구매건수
FROM orders
GROUP BY custid; 

-- 가격이 8000원 이상인 도서 구매한 고객에 대하여 고객별 주문 총 수량 조회
-- ( 단 2권 이상 구매한 고객에 한해서 조회 )
SELECT custid, COUNT(saleprice) 총구매수량
FROM orders
-- WHERE saleprice >= 8000 AND COUNT(saleprice) >= 2
WHERE saleprice >= 8000
GROUP BY custid
HAVING COUNT(saleprice) >= 2;




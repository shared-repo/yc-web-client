-- 작업 데이터베이스 변경
USE madang;

-- 가장 비싼 도서의 이름 조회 1
SELECT MAX(price)
FROM book;

SELECT *
FROM book
WHERE price = 35000;

-- 가장 비싼 도서의 이름 조회 2
SELECT *
FROM book
WHERE price = ( SELECT MAX(price) FROM book );

-- 도서 구매 실적이 있는 고객 조회
SELECT *
FROM customer
WHERE custid IN ( SELECT DISTINCT custid FROM orders );

SELECT DISTINCT c.*
FROM customer c, orders o
WHERE c.custid = o.custid;

-- 대한미디어에서 출판한 도서를 구매한 고객 조회

SELECT c.*
FROM customer c
WHERE c.custid IN ( SELECT o.custid 
					FROM orders o
                    WHERE o.bookid IN ( SELECT b.bookid
									    FROM book b
                                        WHERE b.publisher = '대한미디어') );
                                        
SELECT c.*
FROM customer c, orders o, book b
WHERE c.custid = o.custid AND o.bookid = b.bookid AND b.publisher = '대한미디어';

-- 출판사별로 출판사의 평균 도서 가격보다 비싼 도서 조회
SELECT *
FROM book b1
-- WHERE b.price > 현재 조회중인 도서의 출판사가 출간한 도서의 평균가격
WHERE b1.price > ( SELECT AVG(b2.price)
				   FROM book b2
                   WHERE b1.publisher = b2.publisher );
                   
-- 대한민국 거주 고객과 주문 실적이 있는 고객 조회
SELECT *
FROM customer
WHERE address LIKE '%대한민국%'
UNION
SELECT c.*
FROM customer c, orders o
WHERE c.custid = o.custid;

-- 대한민국 거주 고객 중 주문실적이 없는 고객 조회
SELECT *
FROM customer
WHERE address LIKE '%대한민국%' AND custid NOT IN ( SELECT c.custid
												  FROM customer c, orders o
												  WHERE c.custid = o.custid );
                                                  
-- 대한민국 거주 고객 중 주문실적이 있는 고객 조회
SELECT *
FROM customer
WHERE address LIKE '%대한민국%' AND custid IN ( SELECT c.custid
											  FROM customer c, orders o
											  WHERE c.custid = o.custid );

-- 주문 실적이 있는 고객 조회
SELECT *
FROM customer c
-- WHERE c.custid IN ( SELECT o.custid FROM orders o );
WHERE EXISTS ( SELECT * FROM orders o WHERE c.custid = o.custid );










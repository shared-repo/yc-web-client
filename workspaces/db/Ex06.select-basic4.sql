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

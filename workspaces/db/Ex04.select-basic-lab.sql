-- 작업 데이터베이스 변경
USE madang;

-- 도서번호가 1인 도서의 이름 조회
SELECT *
FROM book
WHERE bookid = 1;

-- 가격이 20,000원 이상인 도서의 이름
SELECT *
FROM book
WHERE price >= 20000;

-- 박지성 고객의 총 구매액( 박지성 고객의 고객번호는 1번으로 놓고 작성 )
SELECT SUM(saleprice) "박지성 고객의 총구매액"
FROM orders
WHERE custid = 1;

-- 박지성 고객의 구매 도서 수량( 박지성 고객의 고객번호는 1번으로 놓고 작성 )
SELECT COUNT(*) "박지성 고객의 구매 도서 수량"
FROM orders
WHERE custid = 1;

-- 마당서점 도서의 총 개수
SELECT COUNT(*) "총 도서 개수"
FROM book;

-- 마당서점에 도서를 출고하는 출판사의 총 수 (중복 제거 필요)
SELECT publisher
FROM book; -- 중복 출판사 확인

SELECT COUNT(DISTINCT publisher) "총 출판사 수"
FROM book;


-- 작업 데이터베이스 변경
USE madang; 

-- 김연아 고객의 전화번호 검색
SELECT phone
FROM customer
WHERE name = '김연아';

-- 모든 도서의 이름, 가격 조회
SELECT bookname, price
FROM book;

-- 모든 도서의 가격, 이름 조회 (변형 : 조회 컬럼 순서 변경)
SELECT price, bookname
FROM book;

-- 모든 도서의 도서번호, 도서이름, 출판사, 가격 조회
SELECT bookid, bookname, publisher, price
FROM book;

-- 모든 도서의 도서번호, 도서이름, 출판사, 가격 조회 (위와 동일한 조회)
SELECT *
FROM book;

-- 도서 테이블에 있는 모든 출판사 조회
SELECT publisher
FROM book;

-- 도서 테이블에 있는 모든 출판사 조회 (중복제거)
SELECT DISTINCT publisher
FROM book;

-- 가격이 20000원 미만인 도서 조회
SELECT *
FROM book
WHERE price < 20000;

-- 가격이 10000원 이상 20000원 이하인 도서
SELECT *
FROM book
WHERE (price >= 10000) AND (price <= 20000);

-- 가격이 10000원 이상 20000원 이하인 도서 (위와 같은 조회)
SELECT *
FROM book
WHERE price BETWEEN 10000 AND 20000;

-- 출판사가 굿스포츠 또는 대한미디어인 도서 조회
SELECT *
FROM book
WHERE publisher = '굿스포츠' OR publisher = '대한미디어';

-- 출판사가 굿스포츠 또는 대한미디어인 도서 조회 (위와 같은 조회)
SELECT *
FROM book
WHERE publisher IN('굿스포츠', '대한미디어');

-- 출판사가 굿스포츠 및 대한미디어가 아닌 도서 조회
SELECT *
FROM book
WHERE publisher <> '굿스포츠' AND publisher != '대한미디어';

-- 출판사가 굿스포츠 및 대한미디어가 아닌 도서 조회 (위와 같은 조회)
SELECT *
FROM book
WHERE publisher NOT IN ('굿스포츠', '대한미디어');

-- '축구의 역사'를 출간한 출판사 조회
SELECT publisher
FROM book
WHERE bookname = '축구의 역사';

-- 도서 이름에 '축구'가 포함된 도서의 출판사 조회
SELECT bookname, publisher
FROM book
WHERE bookname LIKE '%축구%'; -- % : 0개 이상의 문자

-- 도서 이름의 두 번째 문자가 '구'인 도서 조회
SELECT *
FROM book
WHERE bookname LIKE '_구%';
-- 작업 데이터베이스 변경
USE MADANG;

-- NEWBOOK 테이블에 한솔의학서적에서 출간한 가격 90000원의 
-- 새로운 도서 '스포츠 의학' 삽입
-- 자동증가 컬럼(BOOKID)은 지정하지 않고 1부터 시작하는 정수값으로 자동 할당
INSERT INTO NEWBOOK (BOOKNAME, PUBLISHER, PRICE, PUBDATE)
VALUES ('스포츠 의학', '한솔의학서적', 90000, '2023-08-10');

SELECT * FROM NEWBOOK;

-- DEFAULT가 지정된 컬럼(PUBDATE)은 생략할 경우 기본값으로 삽입
INSERT INTO NEWBOOK (BOOKNAME, PUBLISHER, PRICE)
VALUES ('스포츠 의학 2', '한솔의학서적', 80000);

SELECT * FROM NEWBOOK;

-- NULL이 허용된 컬럼은 생략 가능
INSERT INTO NEWBOOK (BOOKNAME, PUBLISHER)
VALUES ('스포츠 의학 3', '한솔의학서적');

SELECT * FROM NEWBOOK;

-- IMPORTED_BOOK 테이블의 데이터를 NEWBOOK 테이블에 삽입
INSERT INTO NEWBOOK (BOOKNAME, PUBLISHER, PRICE)
SELECT BOOKNAME, PUBLISHER, PRICE
FROM IMPORTED_BOOK;

SELECT * FROM NEWBOOK;

-- CUSTOMER 테이블의 고객번호 5인 고객의 주소를 대한민국 부산으로 변경
UPDATE CUSTOMER
SET 
	ADDRESS = '대한민국 인천',
    PHONE = '010-9088-3478'
WHERE CUSTID = 5;

SELECT * FROM CUSTOMER;
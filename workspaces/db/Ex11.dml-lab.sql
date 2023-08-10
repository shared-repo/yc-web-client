-- 작업 데이터베이스 변경
USE madang;

-- (1) 새로운 도서 (‘스포츠 세계’, ‘대한미디어’, 10000원)이 마당서점에 입고되었다. 
--      삽입이 안 될 경우 필요한 데이터가 더 있는지 찾아보자.
INSERT INTO NEWBOOK (BOOKNAME, PUBLISHER, PRICE)
VALUES ('스포츠 세계', '대한미디어', 10000);

SELECT * FROM NEWBOOK;

-- (2) ‘삼성당’에서 출판한 도서를 삭제해야 한다.
START TRANSACTION;

DELETE FROM BOOK
WHERE PUBLISHER = '삼성당';

SELECT * FROM BOOK;

ROLLBACK;

SELECT * FROM BOOK;

-- (3) ‘이상미디어’에서 출판한 도서를 삭제해야 한다. 삭제가 안 될 경우 원인을 생각해보자.
START TRANSACTION;

DELETE FROM BOOK
WHERE PUBLISHER = '이상미디어'; -- 자식 데이터가 있는 부모 데이터는 삭제 불가

SELECT * FROM BOOK;

ROLLBACK;

SELECT * FROM BOOK;

-- (4) 출판사 ‘대한미디어’가 ‘대한출판사’로 이름을 바꾸었다.
START TRANSACTION;

UPDATE BOOK
SET PUBLISHER = '대한출판사'
WHERE PUBLISHER = '대한미디어'; 

SELECT * FROM BOOK;

ROLLBACK;

SELECT * FROM BOOK;
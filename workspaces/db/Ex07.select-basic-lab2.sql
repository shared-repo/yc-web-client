-- 작업 데이터베이스 변경
USE madang;

-- (5) 박지성 고객이 구매한 도서의 출판사 수
SELECT COUNT(DISTINCT B.PUBLISHER)
FROM BOOK B, CUSTOMER C, ORDERS O
WHERE C.NAME = '박지성' 
	  AND 
      B.BOOKID = O.BOOKID AND C.CUSTID = O.CUSTID;
      
SELECT COUNT(DISTINCT B.PUBLISHER)
FROM BOOK B
INNER JOIN ORDERS O
ON B.BOOKID = O.BOOKID 
INNER JOIN CUSTOMER C
ON C.CUSTID = O.CUSTID
WHERE C.NAME = '박지성';

-- (6) 박지성 고객이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
SELECT B.BOOKNAME, B.PRICE, (B.PRICE - O.SALEPRICE) 할인액
FROM BOOK B, CUSTOMER C, ORDERS O
WHERE C.NAME = '박지성' 
	  AND 
      B.BOOKID = O.BOOKID AND C.CUSTID = O.CUSTID;

SELECT B.BOOKNAME, B.PRICE, (B.PRICE - O.SALEPRICE) 할인액
FROM BOOK B
INNER JOIN ORDERS O
ON B.BOOKID = O.BOOKID 
INNER JOIN CUSTOMER C
ON C.CUSTID = O.CUSTID
WHERE C.NAME = '박지성';

-- (7) 박지성 고객이 구매하지 않은 도서의 이름
SELECT B.*
FROM BOOK B
WHERE B.BOOKID NOT IN ( SELECT O.BOOKID 
						FROM ORDERS O
                        WHERE O.CUSTID IN ( SELECT C.CUSTID
											FROM CUSTOMER C
                                            WHERE C.NAME = '박지성' ) );

-- (8) 주문하지 않은 고객의 이름(부속질의 사용)
SELECT C.*
FROM CUSTOMER C
WHERE C.CUSTID NOT IN ( SELECT O.CUSTID FROM ORDERS O );

-- (9) 주문 금액의 총액과 주문의 평균 금액
SELECT SUM(SALEPRICE) 주문총액, AVG(SALEPRICE) 평균주문액
FROM ORDERS;

-- (10) 고객의 이름과 고객별 구매액
SELECT C.CUSTID, C.NAME, SUM(O.SALEPRICE) 구매액
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.CUSTID, C.NAME;

-- (11) 고객의 이름과 고객이 구매한 도서 목록
-- (12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
-- (13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
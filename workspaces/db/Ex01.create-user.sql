-- 1. 사용자 계정 만들기
CREATE USER devuserone@localhost IDENTIFIED BY 'devuserone';
CREATE USER devuserone@"%" IDENTIFIED BY 'devuserone';

-- 2. 권한 부여
GRANT ALL PRIVILEGES ON employees.* TO devuserone@localhost;
GRANT ALL PRIVILEGES ON employees.* TO devuserone@"%";

-- 3. 계정 생성 확인
USE mysql; -- mysql : 관리 데이터베이스

SHOW TABLES; -- 테이블 목록 보기 명령
DESC user; -- 테이블 정보 보기 명령
SELECT user, host FROM user;
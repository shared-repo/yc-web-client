-- 반드시 관리자 계정 (root) 으로 실행
-- 계정 만들기
CREATE USER devuserone@localhost IDENTIFIED BY "devuserone";
CREATE USER devuserone@"%" IDENTIFIED BY "devuserone";

-- 권한부여
GRANT ALL PRIVILEGES ON employees.* TO devuserone@localhost;
GRANT ALL PRIVILEGES ON employees.* TO devuserone@"%";

-- 계정 수정 (비밀번호 변경)
ALTER USER devuserone@localhost IDENTIFIED BY "devuserone";
ALTER USER devuserone@"%" IDENTIFIED BY "devuserone";

-- 계정 삭제
DROP USER devuserone@localhost;
DROP USER devuserone@"%";
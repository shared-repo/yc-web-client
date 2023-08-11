-- ROOT 계정으로 실행

-- 데이터베이스 만들기
CREATE DATABASE demoweb;

-- 권한 부여
GRANT ALL PRIVILEGES ON demoweb.* TO devuserone@localhost;
GRANT ALL PRIVILEGES ON demoweb.* TO devuserone@"%";

FLUSH PRIVILEGES; -- 권한 수정 내용을 적용

-- 여기서부터 devuserone 계정으로 실행

-- 작업 데이터베이스 변경
USE demoweb;

-- 테이블 만들기 : member
-- 컬럼 : memberId(문자열, 20, pk), passwd(문자열, 100, not null)
--       email(문자열, 100, not null), usertype(문자열, 기본값:user), 
--       deleted(boolean, 기본값:false), regdate(날짜, 기본값:now())
CREATE TABLE member
(
	memberId varchar(20),
    passwd varchar(100) not null,
    email varchar(100) not null,
    usertype varchar(20) default('user') check(usertype in ('user', 'admin')),
    deleted boolean default(false),
    regdate date default(now()),
    constraint pk_member primary key (memberId)
);
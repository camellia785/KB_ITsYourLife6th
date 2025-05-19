use tabledb;

drop table if exists userTBL;

create table userTBL
(
    -- 컬럼 타입 제약조건
    userID    char(8) not null primary key,
    name      varchar(10),
    birthyear int     not null default -1,
    addr      char(2) not null default '서울',
    mobile1   char(3),
    mobile2   char(8),
    height    smallint         default 170,
    mDate     date

);

-- 기본값이 들어가는지 확인할 수 있는 데이터 추가
INSERT INTO userTBL (userID, name)
VALUES ('user0001', '홍길동');

-- 결과적으로 생기는 값:
-- userID = 'user0001'
-- name = '홍길동'
-- birthYear = -1
-- addr = '서울'
-- height = 170
-- 나머지는 NULL


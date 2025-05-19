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

-- 1. mobile 컬럼 삭제
alter table userTBL
drop column mobile1;

-- 2. name 컬럼명을 uName으로 변경
alter table userTBL
-- change column (기존이름) (새이름) (자료형)
change column name uName varchar(10) not null;

-- 3. 기본키 제거
alter table userTBL
drop primary key;

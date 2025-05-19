use tabledb;

drop table if exists buyTBL;
drop table if exists userTBL;

create table userTBL
(
    -- 컬럼 타입 제약조건
    userID    char(8)     not null primary key,
    name      varchar(10) not null,
    birthyear int         not null,
    email     char(30) unique -- 중복불가 30자리
)
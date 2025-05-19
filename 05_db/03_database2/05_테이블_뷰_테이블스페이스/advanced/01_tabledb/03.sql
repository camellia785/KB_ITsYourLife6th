use tabledb;

drop table if exists userTBL;

create table userTBL
(
    -- 컬럼 타입 제약조건
    userID    char(8) not null primary key,
    name      varchar(10),
    birthyear int,
    mobile    char(3) not null,

    check ( birthyear >= 19000 & birthyear <= 2023 )

);
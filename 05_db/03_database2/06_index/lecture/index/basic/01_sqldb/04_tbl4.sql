use sqldb;

drop table if exists tbl4;
create table tbl4
(
    a int unique not null ,
    b int unique , -- b유니크키> unique 인덱스 생성(중복불가, Null 허용)
    c int unique ,
    d int
);

-- tbl4이 가지는 인덱스 조회
show index from tbl4;


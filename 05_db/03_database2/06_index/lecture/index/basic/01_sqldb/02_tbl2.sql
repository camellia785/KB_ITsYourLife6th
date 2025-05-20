use sqldb;

drop table if exists tbl2;
create table tbl2
(
    a int primary key, -- a 기본키 > 자동으로 클러스터형(pk) 인덱스 생성 (중복불가, null불가)
    b int unique , -- b 유니크 > unique 인덱스 생성( 중복불가, null 허용)
    c int unique , -- b 유니크 > unique 인덱스 생성( 중복불가, null 허용)
    d int
);

-- tbl2이 가지는 인덱스 조회
show index from tbl2;


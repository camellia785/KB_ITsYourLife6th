use sqldb;

drop table if exists tbl3;
create table tbl3
(
    -- 클러스트형 인덱스
    -- mysql의 innoDB의 경우 테이블에 pk가 없을경우
    -- not null + unique 제약조건이 있는 첫번째 컬럼을 클러스트형 인덱스로 삼음
    -- not null + unique 제약조건의 컬럼이 없을경우 내부적으로 숨겨진 시스템행 id를 사용한다.
    a int unique not null ,
    b int unique , -- b유니크키> unique 인덱스 생성(중복불가, Null 허용)
    c int unique ,
    d int
);

-- tbl2이 가지는 인덱스 조회
show index from tbl3;


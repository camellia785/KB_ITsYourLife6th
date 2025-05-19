-- 존재하면 삭제
DROP database if exists tabledb;

-- 생성
create database tabledb;

use tabledb;

create table userTBL
(
    -- 컬럼 타입 제약조건
    userID    char(8)     not null primary key,
    name      varchar(10) not null,
    birthyear int         not null
);

-- buyTBL foreign key 없이 먼저 생성
drop table if exists buyTBL;
create table buyTBL
(
    num       int auto_increment not null primary key,
    userID    char(8)            not null,
    prodName  char(6)            not null

    -- foreign key (현재테이블컬럼명)
    -- references [테이블명](참조할컬럼)
#     foreign key (userID) references userTBL (userID)
);


-- 이후에 ALTER TABLE로 외래키 추가
ALTER TABLE buyTBL
ADD CONSTRAINT fk_user
FOREIGN KEY (userID) REFERENCES userTBL(userID);

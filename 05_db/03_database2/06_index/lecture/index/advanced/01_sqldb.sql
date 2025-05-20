use sqldb;

-- 1-1. usertbl 내용확인
select * from usertbl;

-- 1-2. udertbl 인덱스 목록 확인
show index from usertbl;

-- 1-3. usertbl의 데이터의 크기, 인덱스의 크기 확인
show table status like 'usertbl'; -- Index_length = 0

-- 2. addr 컬럼에 인덱스 만들기
create index idx_usertbl_addr on usertbl(addr);

-- 생성한 인덱스를 식제 적용하려면, analyze table 문으로 먼저 테이블 분석/처리 필요
analyze table usertbl;

-- 인덱스 목록확인
show index from usertbl;

-- 3. 생성한 인덱스 적용되었는지, 인덱스 크기 확인
show table status like 'usertbl'; -- Index_length = 16384

/*
○ birthYear 컬럼에 대해 idx_usertbl_birthYear 이름의 인덱스를 만드세요.
     에러가 난다면 그 이유를 설명하세요.
○ name 컬럼에 대해 idx_usertbl_name 이름의 인덱스를 만드세요
○ 생성된 인덱스의 목록을 확인하세요
*/

-- 4-1. birthYear에 idx_usertbl_birthYear인덱스 만들기
-- 중복값이 있어 인덱스 생성 에러 발생
create unique index idx_usertbl_birthYear on usertbl(birthYear);

-- 4-2. name에 idx_usertbl_name만들기
create unique index idx_usertbl_name on usertbl(name);

analyze table usertbl;
show index from usertbl;

/*
○ name 컬럼에 대한 보조 인덱스를 삭제하세요.
○ name과 birthYear 컬럼 조합으로 idx_usertbl_name_birthYear 이름의 인덱스를 생성하세요.
○ 인덱스의 목록을 확인하세요
*/

-- 5-1.name 컬럼에 대한 보조 인덱스 삭제
drop index idx_usertbl_name on usertbl;

-- 5-2.name과 birthYear 컬럼 조합 -> 인덱스 생성
create unique index idx_usertbl_name_birthYear on usertbl(name, birthYear);

show index from usertbl; -- 인덱스 목록 확인

# -- 기존 인덱스 삭제 (존재 여부를 확인하고 필요 시 삭제)
# DROP INDEX idx_usertbl_addr ON usertbl;
# DROP INDEX idx_usertbl_birthYear ON usertbl;
# DROP INDEX idx_usertbl_name ON usertbl;

-- 인덱스 삭제
DROP INDEX idx_usertbl_addr ON usertbl;
DROP INDEX idx_usertbl_name_birthYear ON usertbl;
show index from usertbl;
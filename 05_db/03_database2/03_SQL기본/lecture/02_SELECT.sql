-- SELECT
-- 특정 테이블에서 원하는 데이터를 조회할 수 있다.

select -- 조회해줘
    * -- 모든컬럼을
from -- buytbl에서
    buytbl;

select
    userID,
    groupName
from buytbl;

select (5+5);

select now(); -- 현재 시간 출력

-- 컬럼에 별칭사용
select concat('bear', '안녕','kb') as 인사;

-- usertbl의 name, mobile1, mobile2 를 조회

select
    name,
    mobile1,
    mobile2
from usertbl;

-- mobile1, mobile2는 붙어서 전화번호라는 컬럼으로 출력되어야 함

select
    name,
    concat(mobile1, mobile2) as 전화번호
from usertbl;
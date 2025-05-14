# 배포된 sqldb.sql 파일을 이용하여 sqldb 데이터베이스를 구축하세요.
#1. usertbl 테이블에서 이름이'김경호'인 행을 출력하세요.

select
    *
from usertbl
where name = '김경호';


#2. usertbl 테이블에서 생년이 1970 이상이고 키가 182이상인 데이터를 출력하세요.

select
    *
from usertbl
where birthYear>=1970 and height>= 182;

#3. usertbl 테이블에서 키가 180~183 범위인 데이터를 출력하세요.
select
    *
from usertbl
where height>= 180 or height <= 183



# 4. usertbl 테이블에서 주소가'경남' 또는'전남' 또는'경북'인 데이터를 출력하세요.
select
    *
from usertbl
where height>= 180 or height <= 183;

#5. usertbl 테이블에서 이름이'김'으로 시작하는 데이터를 출력하세요.

select
    *
from usertbl
where name LIKE '김%';

# 6. usertbl에서 김경호 보다 큰 사람들의 이름과 키를 출력하세요.
select name, height
from usertbl
where height > (
    select height
    from usertbl
    where name = "김경호"
);

# 7. usertbl을 mdata의 오름 차순으로 정렬하여 출력하세요.

select mDate
from usertbl
order by mDate asc;

# 8.usertbl을 mdata의 내림 차순으로 정렬하여 출력하세요.

select
    *
from usertbl
order by mDate desc;


# 9. usertbl을 height의 내림차순으로 정렬하고,
# 동률인 경우 name의 내림차순으로 정렬하여 출력하세요.

select
    *
from usertbl
order by
    height desc,
    name desc;

# 10. usertbl의 주소지를 중복없이 오름 차순으로 출력하세요.
select distinct addr
from usertbl
order by
    addr asc;


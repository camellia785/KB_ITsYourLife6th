use sqldb;

-- 총 구매개수
select userID      as 사용자아이디,
       sum(amount) as 총구매개수
from buytbl
group by userID
order by userID;

-- 총 구매액
select userID              as 사용자아이디,
       sum(amount * price) as 총구매액
from buytbl
group by userID
order by userID;


-- 평균 구매 개수 (buytbl)
select avg(amount) as 평균_구매_개수
from buytbl;


-- 사용자별 평균 구매 개수
select userID      as 사용자아이디,
       avg(amount) as 평균_구매_개수
from buytbl
group by userID
Order by userID;

-- 키가 가장 큰사람, 작은사람 출력
select name, height
from usertbl
where height = (select max(height) from usertbl)
   or height = (select min(height) from usertbl);

-- 휴대폰이 있는 사용자수 (usertbl)
select count(*) as 휴대폰이있는사용자
from usertbl;


-- 사용자별 총 구매액
select userID as 사용자, sum(price*amount) as '총구매액'
from buytbl
group by userID;

-- 총 구매액이 1000이상인 사용자만 출력 -> 조건이 having으로 들어가는
select userID as 사용자, sum(price*amount) as '총구매액'
from buytbl
group by userID
Having sum(price * amount) > 1000;
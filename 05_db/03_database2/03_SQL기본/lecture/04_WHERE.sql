-- WHERE
-- 특정 조건에 맞는 레코드(데이터)만을 선택하는데 사용됨

-- = 같음 연산자를 사용한 where 절

select
    *
from
    employees
where
    gender = 'M' -- 성별이 M인 애들만
limit 5;


select
    first_name,
    last_name
from
    employees
where
    gender = 'F'
#     gender <> 'M' -- 별이 M아닌 애들만

-- AND 연산자: 둘다 참이여야 참
-- OR 연산자 : 둘중 하나만 참도 참
-- AND가 OR보다 우선순위가 높다
-- 1: true / 0: false

select 1 or 0 and 0;
select (1 or 0) and 0;

select
    emp_no,
    first_name,
    last_name,
    gender
from
    employees
where
    gender <> 'M' AND
    emp_no < 10050;

-- BETWEEN
select
    *
from
    employees
where
    emp_no >= 10050 AND
    emp_no <= 10060;

/*
Between 연산자
- 경계값을 포함한 사이값을 포함
*/

select
    *
from
    employees
where
#     emp_no BETWEEN 10050 AND 10600;
    emp_no NOT BETWEEN 10050 AND 10600 -- 부정표현 (경계값 및 사이값 포함안하고,
limit 5;

/*
LIKE
- 특정 패턴과 일치하는 행을 검색

패턴
- %: 0개 이상의 문자를 나타냄
*/

select
    first_name LIKE


/*
IN 연산자
- 특정 열의 값이 지정된 목록중 하나와 일치하는지 확인하는데 사용*/

select
    *
from
    employees
where emp_no in (1,2,4)


-- 1. 현재 재직 중(to_date = '9999-01-01')인 직원의 이름과 직책을 출력하는 것.

USE employees;

select e.emp_no, e.first_name, e.last_name, t.title
from employees e
join titles t on e.emp_no = t.emp_no -- join on 명확히
where t.to_date = '9999-01-01'
order by e.emp_no;


-- 2. 현재 재직중인 직원 정보 출력
-- join 두번 사용해야함!!!

select e.emp_no, e.birth_date , e.first_name, e.last_name, e.gender, e.hire_date, t.title, s.salary
from employees e
join titles t on e.emp_no = t.emp_no
join salaries s on e.emp_no = s.emp_no
where t.to_date = '9999-01-01'
order by e.emp_no;


-- 3. 현재 재직중인 직원의 정보 출력
select e.emp_no, e.first_name, e.last_name, d.dept_name
from employees e
join dept_emp de on e.emp_no = de.emp_no
join departments d on d.dept_no = de.dept_no
order by e.emp_no;



-- 4. 부서별 재직중인 직원의 수 출력
-- dept_emp 활용
-- dept_name 쓰려면 department 활용
-- groupby: 집계함수(count, sum, avg)를 사용할때
-- 어떤 기준으로 묶을 지 지정하는 구문!! 우리는 count 썼으니까 필요
-- groupby는 select절에 잇는 집계함수가 아닌 컬럼들을 모두 포함해야함

select de.dept_no, d.dept_name, count(*)
from employees e
join dept_emp de on e.emp_no = de.emp_no
join departments d on de.dept_no = d.dept_no
where de.to_date = '9999-01-01'
group by de.dept_no, d.dept_name
order by de.dept_no asc;



-- 5.  emp_no, first_name, last_name, department 현재 재직중인 직원 정보 출력
select e.emp_no, e.first_name, e.last_name, d.dept_name, de.from_date, de.to_date
from employees e
join dept_emp de on e.emp_no = de.emp_no
join departments d on d.dept_no = de.dept_no
where e.emp_no = 10209;
use employees;
drop view if exists v_employees;

create view v_employees as
    select e.emp_no,
           e.birth_date,
           e.first_name,
           e.last_name,
           e.hire_date,
           t.title,
           t.from_date as t_from,
           t.to_date as t_to,
           s.salary,
           s.from_date as s_from,
           s.to_date as s_to

from employees e
    join titles t
        on e.emp_no = t.emp_no
    join salaries s
        on s.emp_no = e.emp_no;

select * from v_employees;

-- 2. EMPLOYEES_INFO 뷰에서 재직자의 현재 정보만 출력

select * from v_employees
where s_to = '9999-01-01'
and t_to= '9999-01-01';

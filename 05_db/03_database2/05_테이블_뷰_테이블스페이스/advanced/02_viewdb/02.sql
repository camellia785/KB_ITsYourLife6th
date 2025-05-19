use employees;
drop view if exists emp_dept_info;

create view emp_dept_info as
    select e.emp_no,
           de.dept_no,
           d.dept_name,
           de.from_date,
           de.to_date

from employees e
    join dept_emp de
        on e.emp_no = de.emp_no
    join departments d
        on d.dept_no = de.dept_no;

select * from emp_dept_info;

-- 2. EMPLOYEES_INFO 뷰에서 재직자의 현재 정보만 출력

select * from emp_dept_info
where to_date = '9999-01-01'

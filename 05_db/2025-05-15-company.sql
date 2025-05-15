
-- 데이터베이스 생성
CREATE DATABASE company;
USE company;

-- departments 테이블 생성
CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL,
    location_id INT
);

-- employees 테이블 생성
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    department_id INT,
    job_id VARCHAR(20),
    salary DECIMAL(10, 2),
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

-- departments 테이블에 데이터 삽입
INSERT INTO departments (department_id, department_name, location_id) VALUES
(1, 'Sales', 1700),
(2, 'Engineering', 1800),
(3, 'HR', 1700),
(4, 'Finance', 1900);

-- employees 테이블에 데이터 삽입
INSERT INTO employees (employee_id, first_name, last_name, department_id, job_id, salary) VALUES
(101, 'John', 'Doe', 1, 'Salesman', 60000),
(102, 'Jane', 'Smith', 2, 'Engineer', 80000),
(103, 'Sam', 'Brown', 1, 'Salesman', 62000),
(104, 'Sue', 'Wilson', 3, 'HR Specialist', 55000),
(105, 'Jim', 'Taylor', 2, 'Engineer', 78000),
(106, 'Amy', 'Adams', 4, 'Accountant', 70000);


-- UNION 사용 예시 – 중복 제거
SELECT job_id FROM employees WHERE department_id = 1
UNION
SELECT job_id FROM employees WHERE department_id = 2;


-- UNION ALL 사용 예시 – 중복 포함
SELECT job_id FROM employees WHERE department_id = 1
UNION ALL
SELECT job_id FROM employees WHERE department_id = 2;


-- ------- 조인테스트
use joindb;

SELECT
	C.ID AS CID,
	P.ID AS PID,
    C.NAME AS CNAME,
    P.NAME AS PNAME
FROM PRODUCT P
INNER JOIN COMPANY C
ON P.COMPANY = C.ID;

-- 셀프 조인
-- self join
CREATE TABLE emptbl(emp CHAR(3), manager CHAR(3), empTel VARCHAR(8));

INSERT INTO empTbl (emp, manager, empTel) VALUES
('나사장', NULL, '0000'),
('김재무', '나사장', '2222'),
('김부장', '김재무', '2222-1'),
('이부장', '김재무', '2222-2'),
('우대리', '이부장', '2222-2-1'),
('지사원', '이부장', '2222-2-2'),
('이영업', '나사장', '1111'),
('한과장', '이영업', '1111-1'),
('최정보', '나사장', '5355'),
('윤차장', '최정보', '3355-1'),
('이주임', '윤자장', '5335-1-1');

select * from empTbl;

-- 우대리 상관의 연락처 검색

SELECT 
	A.emp AS '부하직원', 
    B.emp AS '직속상관', 
    B.empTel AS '직속상관연락처'
FROM empTbl A
INNER JOIN empTbl B
ON A.manager = B.emp
WHERE A.emp = '우대리';

CREATE TABLE `COMPANY` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `ADDR` varchar(200) DEFAULT NULL,
  `TEL` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


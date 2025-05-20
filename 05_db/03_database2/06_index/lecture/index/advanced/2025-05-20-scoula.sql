-- 1. 기존 사용자 삭제 (에러 안 나게 하려면 IF EXISTS 사용)
DROP USER IF EXISTS 'scoula'@'%';

-- 2. 기존 데이터베이스 삭제 (주의: 내부 데이터 전부 삭제됨!)
DROP DATABASE IF EXISTS scoula_db;

create database scoula_db;

create  user  'scoula'@'%'  identified  by  '1234';

grant  all  privileges  on  scoula_db.*   to  'scoula'@'%';

flush privileges;

SELECT user, host FROM mysql.user;


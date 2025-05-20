-- 1. 기존 사용자 삭제 (에러 안 나게 하려면 IF EXISTS 사용)
DROP USER IF EXISTS 'scoula'@'%';

-- 2. 기존 데이터베이스 삭제 (주의: 내부 데이터 전부 삭제됨!)
DROP DATABASE IF EXISTS scoula_db;

-- 3. 데이터베이스 생성
create database scoula_db;

-- 4. 사용자 재생성
create  user  'scoula'@'%'  identified  by  '1234';

-- 5. 권한 부여(해당 DB에 대한 모든 권한)
grant  all  privileges  on  scoula_db.*   to  'scoula'@'%';

-- 권한 변경 사항 적용
flush privileges;

-- 사용자 확인
SELECT user, host FROM mysql.user;


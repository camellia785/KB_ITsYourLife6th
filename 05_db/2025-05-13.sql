-- 설명(comment, 주석), 한칸 반드시 띄우기

-- 현재 스키마(db)는 shopdb로 설정되어 있음.

show tables; -- 테이블 목록 보여주세요

desc membertbl; -- 테이블 설정 자세하게 보여줘! DESCRIBE(설명하다.)

select * from membertbl; -- membertbl테이블로부터 모든 필드(항목, item, 속성, 컬럼)을 선택해서 보여줘(검색)

-- dml 중 하나 crud 중에서 read에 속하는 select문 실행
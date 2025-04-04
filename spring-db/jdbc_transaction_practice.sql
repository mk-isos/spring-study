-- [member 테이블 생성 및 초기화]
drop table if exists member;

create table member (
    member_id varchar(10),
    money integer not null default 0,
    primary key (member_id)
);

-- [자동 커밋 모드]
set autocommit true;

insert into member(member_id, money) values ('data1',10000);
insert into member(member_id, money) values ('data2',10000);

-- [수동 커밋 모드]
set autocommit false;

insert into member(member_id, money) values ('data3',10000);
insert into member(member_id, money) values ('data4',10000);

commit;

-- [데이터 초기화]
set autocommit true;

delete from member;

insert into member(member_id, money) values ('oldId',10000);

-- [트랜잭션 시작 - 수동 커밋 모드]
set autocommit false;

insert into member(member_id, money) values ('newId1',10000);
insert into member(member_id, money) values ('newId2',10000);

-- 커밋
commit;

-- 롤백 예시
rollback;

-- [계좌이체 예제 - 정상 커밋]
set autocommit true;

delete from member;

insert into member(member_id, money) values ('memberA',10000);
insert into member(member_id, money) values ('memberB',10000);

set autocommit false;

update member set money = 10000 - 2000 where member_id = 'memberA';
update member set money = 10000 + 2000 where member_id = 'memberB';

commit;

-- [계좌이체 예제 - 중간 오류 후 커밋 (잘못된 예)]
set autocommit true;

delete from member;

insert into member(member_id, money) values ('memberA',10000);
insert into member(member_id, money) values ('memberB',10000);

set autocommit false;

update member set money = 10000 - 2000 where member_id = 'memberA';
update member set money = 10000 + 2000 where member_iddd = 'memberB'; -- 오류 발생

-- 강제 커밋 (잘못된 상황)
commit;

-- [계좌이체 예제 - 중간 오류 후 롤백]
set autocommit true;

delete from member;

insert into member(member_id, money) values ('memberA',10000);
insert into member(member_id, money) values ('memberB',10000);

set autocommit false;

update member set money = 10000 - 2000 where member_id = 'memberA';
update member set money = 10000 + 2000 where member_iddd = 'memberB'; -- 오류 발생

rollback;

-- [락 실습 - 변경 충돌 방지]
set autocommit true;

delete from member;
insert into member(member_id, money) values ('memberA',10000);

-- 세션1
set autocommit false;
update member set money=500 where member_id = 'memberA';

-- 세션2
SET LOCK_TIMEOUT 60000;
set autocommit false;
update member set money=1000 where member_id = 'memberA';

-- 세션1 커밋 후 세션2 커밋
commit;

-- [락 실습 - 조회 시점 락]
set autocommit true;

delete from member;
insert into member(member_id, money) values ('memberA',10000);

-- 세션1
set autocommit false;
select * from member where member_id='memberA' for update;

-- 세션2
set autocommit false;
update member set money=500 where member_id = 'memberA';

-- 세션1 커밋
commit;

-- 세션2 커밋
commit;

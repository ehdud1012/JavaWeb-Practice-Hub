-- 프사
-- 	파일을 DB에 어케 저장하징?
--		=> 안하는게 맞음
-- 			파일 : 매우 큼
--			텍스트/숫자 : 30byte

-- 파일을 DB에 저장하면 
--		DB -> 웹서버 전송 시간 매우 김
--	-> 파일은 웹서버에 있는게 맞음
--	=> DB서버에는 파일 명만 저장
--			현재는 실습이어서 100으로 하지만 실제로는 매우매우 김
create table pooh_member(
	pm_id varchar2(10 char) primary key, 
	pm_pw varchar2(12 char) not null,
	pm_birthday date not null,
	pm_photo varchar2(100 char) not null
); 

insert into pooh_member values('test1','1', to_date('20240901', 'YYYYMMDD'), '12345');

-- SQL injection
--		A -sql-> DB : 그 sql뒤에 뭔가 넣는 행위

-- 1) 모든 멤버 정보 다 가져와서 -> M 에서 반복/조건문 써서 비교
select * from pooh_member;
-- 2) id / pw맞는 멤버 정보만 가져와서 M에서 OK 		* SQL injection 취약
select * from pooh_member where pm_id = 'test' and pm_pw = '1';
-- 3) id맞는 멤버 정보만 가져와서 M에서 pw			** 이걸로
select * from pooh_member where pm_id = 'test';
select pm_photo from pooh_member where pm_id = 'test';

delete from pooh_member where pm_id = 'test';

update pooh_member
set pm_pw = '111', pm_photo ='111'
where pm_id = '102';

create table pooh_notice(
	pn_no number(3) primary key, 
	pn_title varchar2(50 char) not null,
	pn_txt varchar2(500 char) not null,
	pn_date date not null,
	pn_writer varchar2(10 char) not null,
	constraint pooh_notice_writer
		foreign key(pn_writer) references pooh_member(pm_id)
		on delete cascade
); 
create table pooh_notice_comment(
	pc_no number(4) primary key,
	pc_txt varchar2(100 char) not null,
	pc_date date not null,
	pc_writer varchar2(10 char) not null,
	pc_pn_no number(3) not null,
	constraint pc_pn
		foreign key(pc_pn_no) references pooh_notice(pn_no)
		on delete cascade,
	constraint pc_w
		foreign key(pc_writer) references pooh_member(pm_id)
		on delete cascade
);

select * from pooh_notice_comment where pc_pn_no = ?;

create sequence sep_25_comment_seq;

create sequence sep_23_notice_seq;

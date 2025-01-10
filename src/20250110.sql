use test3;

drop table lecture_register;
drop table lecture;
drop table lecture_user;

select * from lecture_user;
select * from lecture;
select * from lecture_register;

-- 1. 테이블 등록
-- 유저
create table lecture_user(
user_idx int auto_increment primary key, -- 유저 번호
user_id varchar(20), -- 유저 아이디
user_pw varchar(20)); -- 유저 패스워드
-- 전체강의
create table lecture(
lecture_idx int auto_increment primary key, -- 강의 번호
lecture_subject varchar(20), -- 과목 이름
lecture_credit varchar(20), -- 학점
lecture_user_num int, -- 현재 수강인원
lecture_max_num int, -- 최대 수강인원
lecture_day varchar(20), -- 강의요일
lecture_time varchar(20)); -- 강의시간
-- 등록 강의
create table lecture_register(
register_idx int auto_increment , -- 등록 번호
register_user_idx int, -- 유저 번호
register_lecture_idx int, -- 강의 번호
primary key(register_idx),
foreign key(register_user_idx) references lecture_user(user_idx),
foreign key(register_lecture_idx) references lecture(lecture_idx)
);

-- 2. 삽입
-- 유저 삽입
insert into lecture_user (user_id,user_pw) values('student','student');
-- 강의 삽입
insert into lecture (lecture_subject,lecture_credit,lecture_user_num,lecture_max_num,lecture_day,lecture_time)
values 
('컴퓨터이론','3',14,20,'금요일','1-3'),
('UI/UX','2',11,20,'금요일','5-6'),
('자료구조','3',18,20,'월요일','1-3'),
('JAVA 프로그래밍','3',20,20,'화요일','1-3'),
('머신러닝','3',19,20,'화요일','5-7');

-- 3. 맵핑
-- login
select user_id,user_pw from lecture_user where user_id='student' and user_pw='student'; -- user_id=#{user_id} and user_pw=#{user_pw}

-- lecture
-- ex) 강의 목록 신청 버튼 맵핑 (1번 유저가 1번 강의 신청 클릭)
insert into lecture_register (register_user_idx,register_lecture_idx) values (1,2); -- #{register_user_idx},#{register_lecture_idx} (int,int)
insert into lecture_register (register_user_idx) values (1);
update lecture set lecture_user_num=lecture_user_num+1 where lecture_idx=1;
select l.* from lecture l left join lecture_register r on l.lecture_idx=r.register_lecture_idx where r.register_lecture_idx is null;
select l.* from lecture l left join lecture_register r on l.lecture_idx=r.register_lecture_idx where r.register_lecture_idx is not null;

-- ex) 내 강의 목록 취소 맵핑 (과목 번호 기준)
delete from lecture_register where register_lecture_idx=1; -- #{register_lecture_idx} (int)
update lecture set lecture_user_num=lecture_user_num-1 where lecture_idx=1;
select l.* from lecture l left join lecture_register r on l.lecture_idx=r.register_lecture_idx where r.register_lecture_idx is null;
select l.* from lecture l left join lecture_register r on l.lecture_idx=r.register_lecture_idx where r.register_lecture_idx is not null;

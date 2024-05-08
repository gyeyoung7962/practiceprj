create database practiceprj;

use practiceprj;

create table Member
(

    id        int primary key auto_increment,
    email     varchar(200) not null,
    password  varchar(200) not null,
    nick_name varchar(100) not null UNIQUE,
    regDate   datetime default now()
);

desc Member;

select *
from Member;

create table board
(
    id      int primary key auto_increment,
    title   varchar(200)  not null,
    content varchar(3000) not null,
    writer  varchar(100)  not null,
    regDate datetime      not null default now()
);

desc board;
drop table board;


desc Member;

create table Authority
(

    id        int auto_increment primary key,
    member_id int         not null references Member (id),
    name      varchar(10) not null
);

desc Authority;

select *
from Member
where nick_name = 'admin';

insert into Authority(member_id, name)
values (6, 'admin');

select *
from Authority;



select *
from Authority
where member_id = 6;
set names utf8;
drop database if exists mixinan;
create database mixinan character set utf8;
use mixinan;
create table mi_user(
	mi_user_id int primary key auto_increment,
	mi_user_name varchar(100) not null,
	mi_user_password varchar(100) not null,
	mi_user_gender varchar(5) default '1',
	mi_user_nickname varchar(30),
	mi_user_create_time varchar(20)
);

create table mi_blog(
	mi_blog_id int primary key auto_increment,
	mi_user_id int,
	FOREIGN KEY(mi_user_id) REFERENCES mi_user(mi_user_id),
	mi_blog_text varchar(2600),
	mi_blog_like_times int default 0,
	mi_blog_create_time varchar(20),
	mi_blog_last_modify_time varchar(20) default null
);



create table mi_pic(
	mi_pic_id int primary key auto_increment,
	mi_pic_url varchar(1000),
	mi_pic_name varchar(1200),
	mi_pic_desc varchar(8000),
	mi_pic_create_time varchar(20)
);


insert into mi_pic values
	(null,
	"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1229560877,3481869625&fm=27&gp=0.jpg",
	"枫叶",
	"枫叶成熟的季节",
	now());

select * from mi_pic;



insert into mi_user values(null,'mixinan','123456','1','万码千钧',now());

insert into mi_blog(mi_user_id,mi_blog_text,mi_blog_create_time) values
(1,'周一!',now()),
(1,'周二!',now()),
(1,'周三!',now()),
(1,'hello world!',now());

select * from mi_user;

select * from mi_blog;


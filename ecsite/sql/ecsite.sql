set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
	id int not null primary key auto_increment,
	admin_flg varchar(1),
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	insert_date datetime,
	updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
	id int not null primary key auto_increment,
	item_name varchar(30),
	item_price int,
	item_stock int,
	insert_date datetime,
	update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	update_date datetime
);

INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("えんぴつ",80,50);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("けしごむ",100,35);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("ノート",120,60);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("メモ帳",60,90);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("えんぴつ3本",200,70);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("ノート15冊",1600,80);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("ペンケース",1500,0);
INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("はさみ",300,0);
INSERT INTO login_user_transaction(admin_flg,login_id,login_pass,user_name) VALUES("1","mori","mmm","森");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("taro","123","太郎");

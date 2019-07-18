create database e_shop character set utf8;

use e_shop;

create table user(
id int primary key auto_increment,
username varchar(255),
password varchar(255),
mobile varchar(255)
);

create table good(
id int primary key auto_increment,
image varchar(255),
message varchar(255),
price double,
shop_name varchar(255)
);

create table good_cart(
good_id int,
number int
);


create database australiaBuy;
use australiaBuy;


drop table if exists week_order_detail;
create table week_order_detail(
week_no int(2) not null,
year int(4) not null,
item_id int(8) not null,
item_name varchar(100) not null,
brand_id int(8) not null,
brand_name varchar(20) not null,
quantity int(2) not null,
create_date date not null,
primary key(week_no,year,item_id),
CONSTRAINT  week_order_detail_item_foreign_key foreign key(item_id)
references item(id) on delete cascade on update cascade,
CONSTRAINT  week_order_detail_brand_foreign_key foreign key(brand_id)
references brand(id) on delete cascade on update cascade
);

select * from week_order_detail;

drop table if exists customer;
create table  customer(
id varchar(18) not null  primary key,
name varchar(20) not null);

drop table if exists shipping;
create table shipping(
shipping_no varchar(20) not null primary key,
shipping_date date not null,
shipping_address varchar(100) not null,
shipping_phoneNumber varchar(11) not null,
shipping_company long not null,
customer varchar(18) not null,
shipping_cost double(8,2) not null,
agent varchar(20),
CONSTRAINT  shipping_foreign_key foreign key(customer)
references customer(id) on delete cascade on update cascade
);



drop table if exists shipping_detail;
create table shipping_detail(
id int(8) not null auto_increment primary key,
shipping_no varchar(20) not null,
item_id int(8) not null,
sold_price double(8,2),
quantity int(3) not null,
CONSTRAINT  shipping_id_foreign_key foreign key(item_id)
references item(id) on delete cascade on update cascade,
CONSTRAINT shipping_no_foreign_key foreign key(shipping_no)
references shipping(shipping_no) on delete cascade on update cascade
);

drop table if exists shipping_company;
create table shipping_company(
id int(8) NOT NULL auto_increment,
name varchar(20) not null,
url varchar(100) not null,
 PRIMARY KEY (id)
);


drop table if exists item;
create table item(
id int(8) not null auto_increment primary key,
brand_id int(8) not null,
name varchar(100) not null,
unique (brand_id,name),
CONSTRAINT  item_brand_foreign_key foreign key(brand_id)
references brand(id) on delete cascade on update cascade
);

alter table item add constraint unique(brand_id,name);

select * from item;

drop table if exists brand;
create table brand(
id int(8) not null auto_increment primary key,
name varchar(20) not null
);


insert into brand (name) values('swisse');
select * from brand;

insert into customer (id,name) values('41272119887778542X','杨洋');

insert into shipping (shipping_no,shipping_date,shipping_address,shipping_phoneNumber,shipping_company,customer) 
values('5555555555','2016/04/18',"testing address",'11111','2','410105198711030131');




insert into item (brand_id,name) values(1,"蔓越莓");
insert into item (brand_id,name) values(1,"护肝片");
insert into item (brand_id,name) values(1,"月见草");
insert into item (brand_id,name) values(2,"月见草");
insert into item (brand_id,name) values(7,"蔓越莓蜂蜜");
insert into item (brand_id,name) values(7,"柠檬蜂蜜");
insert into item (brand_id,name) values(7,"儿童柠檬蜂蜜");
select * from item;



select * from customer order by name, id;
select * from shipping;
select * from shipping_detail;
select * from brand;
select * from item;
select * from week_order_detail;
select * from brand where name between 'a' and 'b';
delete from week_order_detail;

insert into week_order_detail (week_no,year,item_id,quantity,create_date)
values (17,2016,1,2,DATE_FORMAT(NOW(),'%Y-%m-%d'));

insert into week_order_detail (week_no,year,item_id,quantity,create_date)
values (17,2016,4,2,DATE_FORMAT(NOW(),'%Y-%m-%d'));


insert into shipping_detail (shipping_no,item_id,sold_price,quantity) values('1234',1, 120,3);
insert into shipping_detail (shipping_no,item_id,sold_price,quantity) values('1234',2, 150,2);
insert into shipping_detail (shipping_no,item_id,sold_price,quantity) values('1234',4, 150,5);

insert into shipping_detail (shipping_no,item_id,sold_price,quantity) values('5555555555',1, 120,5);
insert into shipping_detail (shipping_no,item_id,sold_price,quantity) values('5555555555',2, 150,5);
insert into shipping_detail (shipping_no,item_id,sold_price,quantity) values('5555555555',3, 150,5);
insert into shipping_detail (shipping_no,item_id,sold_price,quantity) values('5555555555',4, 150,5);



select * from shipping_detail;

insert into brand (name) values("swisse");
insert into brand (name) values("blackmores");
insert into brand (name) values("bio-island");
insert into brand (name) values("aptamil");
insert into brand (name) values("a2");
insert into brand (name) values("aptamil profutura");
insert into brand (name) values("streamland");

insert into shipping_company (name,url) values("中邮","www.cnpex.com.au");
insert into shipping_company (name,url) values("澳邮","www.auexpress.com.au");
insert into shipping_company (name,url) values("中环","www.zhexpress.com.au");
insert into shipping_company (name,url) values("PCA","www.pcaexpress.com.au");
insert into shipping_company (name,url) values("澳德","www.auodexpress.com");

select * from shipping_company;

select c.name as customer_name, s.shipping_no, sum(sd.sold_price*sd.quantity) as cost from customer c 
join shipping s on c.id = s.customer
left join shipping_detail sd on sd.shipping_no = s.shipping_no
group by s.shipping_no order by cost desc;



select c.name as customer_name, i.name as item_name,sd.quantity,sd.sold_price, sc.name as shipping_company
from customer c join shipping s on c.id = s.customer 
left join shipping_detail sd on sd.shipping_no = s.shipping_no 
left join item i on sd.item_id = i.id
left join shipping_company sc on s.shipping_company = sc.id
where s.shipping_no = '5555555555'
and s.shipping_date between '2016/03/28' and '2016/04/18';






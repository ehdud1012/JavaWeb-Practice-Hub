-- DBA 작업

CREATE TABLE sep11_product(
	p_no number(3) primary key,
	p_name varchar2(10 char) not null,
	p_price number(6) not null
);

create sequence sep_11_product_seq;

insert into sep11_product values(sep_11_product_seq.nextval, '감자깡', 2000);
insert into sep11_product values(sep_11_product_seq.nextval, '마이쮸', 500);
insert into sep11_product values(sep_11_product_seq.nextval, '양파깡', 1700);

select * from sep11_product;

delete from sep11_product
where p_name = '과일세트';

select p_name, p_price from sep11_product order by p_name;
select * from (select rownum as rn, p_name, p_price from (select * from sep11_product) where rn >= 5 and rn <= 33);

select * from (select rownum as rn, p_name, p_price 
from (select * from sep11_product)) where rn >= 3 and rn <= 5;
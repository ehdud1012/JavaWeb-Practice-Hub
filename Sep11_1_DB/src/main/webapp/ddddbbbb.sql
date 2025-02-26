-- DBA 작업

CREATE TABLE sep11_product(
	p_no number(3) primary key,
	p_name varchar2(10 char) not null,
	p_price number(6) not null
);

create sequence sep_11_product_seq;

insert into sep11_product values(sep_11_product_seq.nextval, '테스트', 0);

select * from sep11_product;
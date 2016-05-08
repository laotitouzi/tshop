
drop table if EXISTS   category;
create table category (
	category_id varchar(80) not null,
	category_name varchar(80) null,
	description varchar(255) null,
	constraint pk_category primary key (category_id)
);
drop table if EXISTS   product;
create table product (
    product_id varchar(80) not null ,
    category_id varchar(80) not null ,
    product_name varchar(80) not null ,
    price decimal(10,2)  not null ,
    description varchar(2) not null ,
    discount decimal(10,2)  not null ,
    constraint pk_product PRIMARY  key (product_id)
);
create index index_product_name on product (product_name);

drop table if EXISTS   user;
create table user (
  user_id varchar(80) not null ,
  username varchar(80) not null ,
  password varchar(80) not null ,
  nickname varchar(80) not null ,
  status varchar(2) not null ,
  country varchar(80) not null ,
  state varchar(80) not null ,
  city varchar(80) not null ,
  zip varchar(80) not null ,
  address varchar(80) not null ,
  phone varchar(80) not null ,
  email varchar(80) not null ,
  constraint pk_account primary key (user_id)
);

create table orders (
      order_id  varchar(80) not null ,
      username  varchar(80) not null ,
      create_date  date not null ,
      ship_address  varchar(80) not null ,
      ship_country  varchar(80) not null ,
      ship_state  varchar(80) not null ,
      ship_city  varchar(80) not null ,
      ship_zip  varchar(80) not null ,
      user_phone  varchar(80) not null ,
      total_price  decimal(10,2)  not null ,
      pay_type  varchar(2) not null ,
      total_benefit  decimal(10,2)   ,
      status   varchar(2) not null ,
      constraint pk_orders primary key (order_id)
);

create table orderstatus (
      order_id int not null,
      linenum int not null,
      timestamp date not null,
      status varchar(2) not null,
      constraint pk_orderstatus primary key (orderid, linenum)
);

create table lineitem (
      order_id varchar(80) not null,
      linenum int not null,
      item_id varchar(10) not null,
      quantity int not null,
      unit_price decimal(10,2) not null,
      constraint pk_lineitem primary key (order_id, linenum)
);

drop table if EXISTS  item;
create table item (
    itemid varchar(10) not null,
    productid varchar(10) not null,
    listprice decimal(10,2) null,
    unitcost decimal(10,2) null,
    supplier int null,
    status varchar(2) null,
    attr1 varchar(80) null,
    attr2 varchar(80) null,
    attr3 varchar(80) null,
    attr4 varchar(80) null,
    attr5 varchar(80) null,
    constraint pk_item primary key (itemid),
        constraint fk_item_1 foreign key (productid)
        references product (productid),
        constraint fk_item_2 foreign key (supplier)
        references supplier (suppid)
);

create index itemProd on item (productid);

CREATE TABLE sequence
(
    productName               varchar(30)  not null,
    nextid             int          not null,
    constraint pk_sequence primary key (productName)
);

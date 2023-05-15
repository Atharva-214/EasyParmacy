create database AAA_pharmacy;
use AAA_pharmacy;

create table medicines(
	med_id int auto_increment,
    med_name varchar(20) NOT NULL,
    mfg_date date NOT NULL,
    exp_date date NOT NULL,
    price int NOT NULL,
    stock int NOT NULL,
    prescription_reqd boolean default 0,
    refrigeration_reqd boolean default 0,
    primary key (med_id),
    check(stock >= 0),
    check(price >= 0)
    );
    
create table suppliers(
	supplier_id int auto_increment,
    supplier_name varchar(20) NOT NULL,
    supplier_contact_1 int NOT NULL unique,
    supplier_contact_2 int,
    office_address varchar(30) NOT NULL,
    pincode int NOT NULL,
    primary key (supplier_id)
    );
    
create table customers(
	customer_id int auto_increment,
    age int,
    gender char,
    customer_name varchar(20) NOT NULL,
    address varchar(30) NOT NULL,
    pincode int NOT NULL,
    phone_num int,
    primary key (customer_id)
	);

create table orders(
	order_id int auto_increment,
    customer_id int,
    med_id int,
    qty int,
    order_time date,
    primary key(order_id),
    foreign key(customer_id) references customers(customer_id),
    foreign key(med_id) references medicines(med_id)
    );

desc medicines;
desc suppliers;
desc orders;
desc customers;
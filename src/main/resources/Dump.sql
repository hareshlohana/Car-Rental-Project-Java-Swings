create table customer(
	id int auto_increment primary key,
	c_name varchar(100),
	c_number varchar(15),
	cnic varchar(50),
	address varchar(255),
	ref_number varchar(15)
);


create table vehicle_owner(
	id int auto_increment primary key,
	owner_name varchar(100),
	owner_number varchar(15),
	cnic varchar(50),
	address varchar(255),
	commission float
);

create table vehicle(
	id int auto_increment primary key,
	v_name varchar(100),
	model varchar(15),
	brand varchar(50),
	color varchar(50),
	owner_id int,
    foreign key (owner_id) references vehicle_owner(id)
);

create table booking(
	id int auto_increment primary key,
    cid int,
    vid int,
    booking_date date,
    price double,
    booking_status varchar(100),
    foreign key (cid) references customer(id),
    foreign key (vid) references vehicle(id)
);

select * from customer;
select * from vehicle_owner;
select * from vehicle;
select * from booking;


insert into customer(c_name,c_number,cnic,address,ref_number) values
('Jamil','03357834562','44451-5748479-2','Gulshan','03346789102'),
('Aamir','03357834345','44451-5748456-7','Landhi','03346782345'),
('Yaseen','03363456072','44451-5748479-1','Nazimabad','03346789893'),
('Tousif','03357834562','44451-5744569-2','DHA','0334678234');


insert into vehicle_owner(owner_name,owner_number,cnic,address,commission) values
('Basim','03015617860','41043-5745589-1','Shah Faisal',1000.00),
('Zaeem','03345678255','40353-6735479-3','Landhi',1200.00),
('Wahab','03357834562','44451-5748469-2','Saddar','1300'),
('Khalid','03357890062','44451-5748489-0','Garden','1200');

insert into vehicle(V_name,model,brand,color,owner_id) values
('Corolla','2022','Toyota','Silver',1),
('Civic','2023','Honda','Black',4),
('Elentra','2024','Hundai','White',2),
('Alto','2018','Suzuki','Golden',3);

insert into booking(cid,vid,booking_date,price,booking_status) values
(1,2,'2024-01-22',2500,'Booked'),
(2,1,'2024-01-07',3000,'Booked'),
(4,3,'2024-05-22',2800,'Available'),
(3,4,'2024-01-20',2300,'Available');
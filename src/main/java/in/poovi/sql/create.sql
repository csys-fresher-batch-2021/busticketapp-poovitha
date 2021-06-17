create table busroute(
	id serial primary key,
     routeno  integer not null,
	source varchar(40),
	destination varchar(40)
);

create table busdetails(
id serial primary key,
agency varchar(40),
b_no integer not null,
bustype varchar(40),
amount real
);

create table userregister(
	username varchar(40) not null,
	age int not null,
	email varchar(40) unique,
	mobileno bigint not null,
	userid int unique ,
	password varchar(40)
);

create table booking(
	bookingno int primary key,
	source varchar(40),
	destination varchar(40),
	agency varchar(40),
	busnumber int not null,
	bustype varchar(40),
	amount real,
	nooftickets int not null,
	totalamount real,
	status varchar(40)
);

create table seatavailable(
	busnumber int primary key,
	availableseat int ,
	totalseat int
);

create table adminregister(
   adminname varchar(40),
	adminid int unique,
	password varchar(40)
	);
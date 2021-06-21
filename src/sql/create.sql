create table busdetails( 
b_no int not null, 
agency varchar(50) not null, 
source varchar(50), 
destination varchar(50), 
bustype varchar(50) not null, 
amount real,	
constraint b_no_pk primary key (b_no), 
constraint source_destination_ck check(source<>destination));

create table busroute(
	id serial primary key,
     routeno  integer not null,
	source varchar(40),
	destination varchar(40)
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
	
create table passengerlist (
pid integer not null,
pname varchar(50) not null,
page integer not null,
pgender varchar(20) not null,
pmobileno bigint unique not null,
constraint pid_pk primary key(pid),
constraint page_ck check(page>=1),
constraint pgender_ck check(pgender in('Male','Female')));

create or replace view view_busdetails as
select bl.b_no,bl.agency,bl.source,bl.destination,bl.bustype,bl.amount,bs.totalseat, bs.totalseat as availableseat
from busdetails bl,seatavailable bs where bl.b_no = bs.busnumber;

	
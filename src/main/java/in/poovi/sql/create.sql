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
    routeno  integer not null,
	source varchar(40),
	destination varchar(40),
	constraint routeno_pk primary key(routeno)
);

create table userregister(
	username varchar(40) not null,
	age int not null,
	email varchar(40) unique,
	mobileno bigint not null,
	userid int unique ,
	password varchar(40),
	constraint userid_ck check(userid>=100)
);

create table booking(
bookingno integer not null,
pid integer not null,
source varchar(40) not null,
destination varchar(40) not null,
agency varchar(40) not null,
busnumber integer not null,
bustype varchar(40) not null,
amount real,
nooftickets integer not null,
totalamount real,
status varchar(20),
constraint bookingno_pk primary key(bookingno),
constraint nooftickets_ck check(nooftickets>0),
constraint status_ck check(status in('booked')),
constraint pid_pk3 foreign key(pid) references passengerlist(pid),
constraint busnumber_pk2 foreign key(busnumber) references busdetails(b_no)
);

create table seatavailable(
	busnumber int unique not null,
	availableseat int not null,
	totalseat int not null,
	constraint foreign_key_busnumber foreign key(busnumber) references busdetails(b_no),
    constraint check_noofseat check(availableseat>=0)
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

	
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
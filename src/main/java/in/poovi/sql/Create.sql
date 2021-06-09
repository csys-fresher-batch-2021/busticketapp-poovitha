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
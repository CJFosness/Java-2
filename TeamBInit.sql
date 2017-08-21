drop user if exists 'teamB'@'localhost';

create user 'teamB'@'localhost' identified by 'teamB';

grant select, insert, update, delete, create, create view, drop, execute, references on *.* to 'teamB'@'localhost';
create database BugReportTeamB;

use BugReportTeamB;

create table Bugs 
(
id integer,

status varchar(10),

priority varchar(10),

application varchar(25),

assignee varchar(25),

summary varchar(50),

detailedDesc varchar(100),

fixDesc varchar(100),

primary key(id)
);

insert into Bugs values 

(100, 

"PENDING", 

"LOW", 

"App1", 

"Tom Jones", 

"This is a test of the bug system",

"This is the detailed description of the bug in the bug system",

"");

select * from Bugs;
insert into Bugs values 

(101, 

"APPROVED", 

"HIGH", 

"App2", 

"Tom Jones", 

"This is a test of the bug system 2",

"This is the detailed description of the bug in the bug system 2",

"");

select * from Bugs;
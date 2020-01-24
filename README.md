# Hospital Management System
 
1. Install Netbeans 8.0.x, JDK 1.x and MySQL 5.x along with MySQL connector java and SQLJDBC.
2. Create a database named login using the command: create database login;
3. Switch to that databse using the command: use login;
4. Create the following tables:
	a. create table doctor(did varchar(10) not null primary key,name varchar(20),phoneno varchar(10),department varchar(20);
	b. create table patient(pid varchar(10) not null primary key,name varchar(20),dob varchar(15),doa varchar(15),did varchar(10),
	   constraint foreign key(did) references doctor(did)on delete set null on update cascade);
	c. create table entry(Sno int not null primary key,username varchar(20),password varchar(20));
	d. create table room(roomno varchar(10) not null,pid varchar(10) not null,charge varchar(10),constraint foreign key (pid,roomno));
	e. create table bill(billno varchar(10)not null,pid varchar(10),Doccharge varchar(10) set default "500",roomcharge varchar(10),total varchar(10),
	   constraint foreign key(pid) references patient(pid) on update cascade on delete cascade);
	f. create table medrec(pid varchar(10),date varchar(10),cause varchar(15),drug1 varchar(15),drug2 varchar(15),drug3 varchar(15),
	   did varchar(15),constraint foreign key(pid) references patient(pid) on update cascade on delete cascade,constraint forign key(did)
	   references doctor(did) on update cascade on delete cascade);
	g. create table status(roomno varchar(10) primary key not null, noofbeds int);
5. Create a trigger to generate the total charge which is the sum of doctor and room charges using the command:
   create trigger billgen after insert on room for each row update bill set total=Doccharge+roomcharge;
6. Change the delimiter using the command: delimiter $$ ;
7. Create a procedure called bed_deduction using the command:
   create procedure bed_deduction()
   BEGIN
   update status set noofbeds = noofbeds-1 where roomno in ( select roomno from room);
   END
   $$
8. Change the delimiter using the command: delimiter ; $$
9. Create a trigger to reduce the number of available beds in a room when a patient is alloted that room:
   create trigger t1 after insert on room for each row call bed_deduction();
10. Do change the pasword of the root user in each page code according to what you have inserted in ENTRY table.
11. Now you can insert data into entry, status.
12. Have fun with the database.

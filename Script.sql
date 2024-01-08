create table if not exists Users (
	id integer primary key autoincrement,
	name varchar(20) not null,
	phone varchar(20) default null
);

INSERT INTO Users (name, phone) values
	('Petya', '125453'),
	('Vasya', '654321'),
	('Katya', null);
	
UPDATE Users 
	set name = 'Ne Petya', phone = '+79991112233'
	WHERE id = 4;
	
DELETE FROM Users WHERE id < 3;

SELECT * FROM Users;

SELECT name,phone from Users;

SELECT id,name,phone from Users WHERE name like '%Petya%';

SELECT id,name,phone 
	from Users 
	WHERE 
		name NOT LIKE '%Petya%'
		AND
		phone IS NOT NULL;




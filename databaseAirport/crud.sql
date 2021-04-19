#insert 

INSERT INTO Countries (name)
VALUES 	('Korea'),
		('Austria-Hungary'),
		('Argentina'),
        ('Castilla-León'),
        ('Czechoslovakia'),
        ('Frankia'),
        ('Eire'),
        ('Brazilean Empire'),
        ('Thirteen Colonies'),
        ('China'),
        ('Chile');
INSERT INTO States	(name, Countries_id)
VALUES 	('Ciudad Autónoma de Buenos Aires', (SELECT id from Countries WHERE name='Argentina')),
		('General Perón', (SELECT id from Countries WHERE name='Argentina')),
		('Corrientes', (SELECT id from Countries WHERE name='Argentina')),
        ('Región Metropolitana de Santiago', (SELECT id from Countries WHERE name='Chile'));
INSERT INTO Cities (name, States_id)
VALUES 	('Corrientes', (SELECT id from States WHERE name='Corrientes')),
		('Ciudad Autónoma de Buenos Aires', (SELECT id from States WHERE name='Ciudad Autónoma de Buenos Aires')),
        ('Santiago de Chile', (SELECT id from Countries WHERE name='Región Metropolitana de Santiago'));
INSERT INTO Airports (name, Cities_id)
VALUES	('Dr. Piragine Niveyro', (SELECT id from Cities WHERE name='Corrientes')),
		('Ministro Pistarini', (SELECT id from Cities WHERE name='Ciudad Autónoma de Buenos Aires'));
INSERT INTO Airlines (name)
VALUES 	('Flybondi');
INSERT INTO Airplanes_models (model, size)
VALUES	('Boeing 737', 'BIG');
INSERT INTO Airplanes (Airplanes_models_id, Airlines_id)
VALUES 	((SELECT id from Airplanes_models WHERE model='Boeing 737'),(SELECT id from Airlines WHERE name='Flybondi'));
INSERT INTO Routes (Airports_id_from, Airports_id_to)
VALUES	((SELECT id from Airports WHERE name='Dr. Piragine Niveyro'),(SELECT id from Airports WHERE name='Ministro Pistarini')),
		((SELECT id from Airports WHERE name='Ministro Pistarini'),(SELECT id from Airports WHERE name='Dr. Piragine Niveyro'));
INSERT INTO Flights (status, departure_date, arrival_date, Routes_id, Airplanes_id)
VALUES	('ON TIME', '2021-04-18 12:00:00', '2021-04-18 16:00:00', 1, 1),
		('ON TIME', '2021-04-20 12:00:00', '2021-04-20 16:00:00', 2, 1);
INSERT INTO Passangers (fname, lname, passport, age, gender)
VALUES 	('Andrea', 'Carcuro', '221491', 21, 'Male'),
		('Ludovica', 'Incollu', '241412', 21, 'Female');
INSERT INTO Orders (Flights_id, Passangers_id, price)
VALUES 	(1, 1, 250),
		(2,2, 250);
        
#updates
        
UPDATE Countries
SET name='France'
WHERE name='Frankia';
UPDATE Countries
SET name='United States of America'
WHERE name='Thirteen Colonies';
UPDATE Countries
SET name='Spain'
WHERE name='Castilla-León';
UPDATE Countries
SET name='Republic of Brazil'
WHERE name='Brazilean Empire';
UPDATE Countries
SET name='Ireland'
WHERE name='Eire';
UPDATE Countries
SET name='Taiwan'
WHERE name='China';
UPDATE Countries
SET name='Japan'
WHERE name='Korea';
UPDATE Countries
SET name='Austria'
WHERE name='Austria-Hungary';
UPDATE Countries
SET name='Czech Republic'
WHERE name ='Czechoslovakia';
UPDATE States
SET name='Chaco'
WHERE name ='General Perón';

#deletes

DELETE FROM Countries WHERE name='France';
DELETE FROM Countries WHERE name='Ireland';
DELETE FROM Countries WHERE name='Austria';
DELETE FROM Countries WHERE name='Spain';
DELETE FROM Countries WHERE name='Czech Republic';
DELETE FROM Countries WHERE name='Republic of Brazil';
DELETE FROM Countries WHERE name='United States of America';
DELETE FROM Countries WHERE name='Japan';
DELETE FROM Countries WHERE name='Taiwan';
DELETE FROM States WHERE name='Chaco';

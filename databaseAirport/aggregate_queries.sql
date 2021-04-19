#Queries without group by
SELECT COUNT(id) as 'Number of Passangers'
FROM Passangers;

SELECT AVG(price) as 'Average Price'
FROM Orders;

SELECT COUNT(id) as 'Number of Countries'
FROM Countries;

SELECT COUNT(id) as 'Number of Sales'
FROM Orders;

SELECT SUM(price) 'Total Income'
FROM Orders;

#Queries with group by

SELECT p.gender as 'Gender', COUNT(p.gender) as 'Nº of Passangers'
FROM Passangers as p
GROUP BY p.gender;

SELECT c.name as 'Country', COUNT(ct.id) as 'Cities' 
FROM Countries as c
LEFT JOIN States as s ON c.id = s.countries_id
LEFT JOIN Cities as ct ON s.id = ct.states_id
GROUP BY c.name HAVING COUNT(ct.id) > 0;

SELECT c.name as 'Flight To', MIN(o.price) as 'Minimum Price'
FROM Orders as o
LEFT JOIN Flights as f ON o.Flights_id=f.id
LEFT JOIN Routes as r ON f.Routes_id=r.id
LEFT JOIN Airports as a ON r.Airports_id_to=a.id
LEFT JOIN Cities as c ON a.Cities_id=c.id
GROUP BY c.name HAVING SUM(o.price) < 500;

SELECT c.name as 'Flight To', AVG(o.price) as 'Average Price'
FROM Orders as o
LEFT JOIN Flights as f ON o.Flights_id=f.id
LEFT JOIN Routes as r ON f.Routes_id=r.id
LEFT JOIN Airports as a ON r.Airports_id_to=a.id
LEFT JOIN Cities as c ON a.Cities_id=c.id
GROUP BY c.name;

SELECT al.name as 'Airlines', COUNT(ap.id) as 'Nº of Airplanes' 
FROM Airlines as al 
LEFT JOIN Airplanes as ap ON ap.Airlines_id = al.id
GROUP BY al.name HAVING al.name != 'Aerolineas Argentinas';


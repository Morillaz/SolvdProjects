#join

SELECT o.id as 'Order Nº', p.fname as 'First name', p.lname as 'Last name', o.price as 'Price', f.id as 'Flight Nº', apf.name as 'From', cityf.name as 'City', sf.name as 'State', countryf.name as 'Country', apt.name  as 'To', cityt.name as 'City', st.name as 'State', countryt.name as 'Country', m.model as 'On', al.name 'Of'
FROM Orders as o 
LEFT JOIN Passangers as p ON o.Passangers_id=p.id
LEFT JOIN Flights as f ON o.Flights_id=f.id
LEFT JOIN Airplanes as ar ON f.Airplanes_id=ar.id
LEFT JOIN Airplanes_models as m ON ar.Airplanes_models_id=m.id
LEFT JOIN Airlines as al ON ar.Airlines_id=al.id
LEFT JOIN Routes as r ON f.Routes_id=r.id
LEFT JOIN Airports as apf ON r.Airports_id_from=apf.id
LEFT JOIN Cities as cityf ON apf.Cities_id=cityf.id
LEFT JOIN States as sf ON cityf.States_id=sf.id
LEFT JOIN Countries as countryf ON sf.Countries_id=countryf.id
LEFT JOIN Airports as apt ON r.Airports_id_to=apt.id
LEFT JOIN Cities as cityt ON apt.Cities_id=cityt.id
LEFT JOIN States as st ON cityt.States_id=st.id
LEFT JOIN Countries as countryt ON st.Countries_id=countryt.id;


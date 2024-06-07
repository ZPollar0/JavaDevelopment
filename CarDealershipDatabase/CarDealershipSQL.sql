CREATE DATABASE CarDealership;

CREATE TABLE Dealerships (
dealershipID INT NOT NULL AUTO_INCREMENT,
name varchar(50),
address varchar(75),
phone varchar(12),
PRIMARY KEY(dealershipID)
);

/*Vehicle table is for creating each individual 
car and assigning them a place to be*/

CREATE TABLE Vehicles (
VIN INT NOT NULL,
SOLD BOOL,
make varchar(50) NOT NULL,
model varchar(50) NOT NULL,
price DOUBLE NOT NULL,
PRIMARY KEY(VIN)
);

ALTER TABLE Vehicles
ADD ID INT NOT NULL;

/* Inventory is used to keep track of which 
dealerships have which cars by their ID and
 the car's VIN number */
 
CREATE TABLE inventory (
dealershipID INT,
VIN INT,
FOREIGN KEY(VIN) REFERENCES Vehicles(VIN),
FOREIGN KEY(dealershipI) REFERENCES Dealerships(dealershipID)
);

/* The Sales Contract table is used to 
keep track of clientele and their purchases. */

CREATE TABLE SalesContracts (
ID INT NOT NULL AUTO_INCREMENT,
VIN INT NOT NULL,
FirstName varchar(30) NOT NULL,
LastName varchar(35) NOT NULL,
DateSigned DATE,
PRIMARY KEY(ID),
FOREIGN KEY(VIN) REFERENCES Vehicles(VIN)
);

/* Leasing Contract table is about managing and billing
 clientele for their vehicles and keeping 
 track of the car itself.*/

CREATE TABLE LeaseContracts (
ID INt NOT NULL AUTO_INCREMENT,
VIN INT NOT NULL,
FirstName varchar(30) NOT NULL,
LastName varchar(35) NOT NULL,
Phone INT NOT NULL,
MonthlyBilling INT NOT NULL,
DateSigned DATE,
PRIMARY KEY(ID),
FOREIGN  KEY(VIN) REFERENCES Vehicles(VIN)
);

-- Everything below is Sample Data used to populate the database

INSERT INTO Dealerships (name,Address,phone,CarType) Values ('Truckeist Trucks','188 Truck Avenue', '444-812-9820','Trucks'); 
INSERT INTO Dealerships (name,Address,phone,CarType) Values ('We SELL Cars','29 XBOX Lane ', '800-865-9408','Cars'); 						
INSERT INTO Dealerships (name,Address,phone,CarType) Values ('Berckman Auto','2 Baylay Circle', '102-230-7815','One Person Cars'); 
INSERT INTO Dealerships (name,Address,phone,CarType) Values ('Pokemon Propels','1 Bulbasaur Ave', '808-712-9999','HoverCraft');                        
INSERT INTO dealerships (name, address, phone) VALUES
('ABC Motors', '123 Main St', '555-1234'),
('XYZ Autos', '456 Oak St', '555-5678');

INSERT INTO Vehicles (VIN,SOLD,Mileage) Values ('1HGCM82633A123456',TRUE, '6783'); 
INSERT INTO Vehicles (VIN,SOLD,Mileage) Values ('5XYZW3LBXGG123789',FALSE, '7215'); 
INSERT INTO Vehicles (VIN,SOLD,Mileage) Values ('JTDKB20U677654321',FALSE, '8492'); 
INSERT INTO Vehicles (VIN,SOLD,Mileage) Values ('WAUZZZ8T0CA765432',TRUE, '7841'); 
INSERT INTO Vehicles (vin, model, year, price, sold) VALUES
('5XYZH4AG0CG001234', 'Hyundai Santa Fe', 2023, 28000.00, TRUE),
('2C3CDXBG5KH123456', 'Dodge Charger', 2022, 30000.00, FALSE),
('JM1GL1UM5H1234567', 'Mazda 6', 2023, 27000.00, FALSE),
('1G1FH1R75H1234567', 'Chevrolet Camaro', 2022, 35000.00, FALSE),
('1C4RJFCM2EC123456', 'Jeep Grand Cherokee', 2023, 40000.00, TRUE),
('WAUENAF44HN123456', 'Audi A6', 2022, 45000.00, FALSE),
('5YJ3E1EB5KF123456', 'Tesla Model 3', 2023, 55000.00, FALSE),
('1FTFW1E52K1234567', 'Ford F-150', 2022, 35000.00, TRUE),
('JTDKARFU2G1234567', 'Toyota Prius', 2023, 30000.00, FALSE),
('1N4BL4EV8KC123456', 'Nissan Altima', 2022, 28000.00, TRUE),
('KM8J3CA26LU123456', 'Hyundai Tucson', 2023, 32000.00, FALSE),
('3C6JR7EG5HG123456', 'Ram 1500', 2022, 38000.00, FALSE),
('2HGFC2F55LH123456', 'Honda Civic', 2023, 23000.00, FALSE),
('5FNRL6H76KB123456', 'Honda Odyssey', 2022, 35000.00, TRUE);

INSERT INTO Sales_Contract  (SoldBY) Values ('Christian Crities'); 
INSERT INTO Sales_Contract  (SoldBY) Values ('Rickey Glover'); 
INSERT INTO Sales_Contract  (SoldBY) Values ('Randy Lopez'); 
INSERT INTO Sales_Contract  (SoldBY) Values ('Caleb Howard'); 
 INSERT INTO sales_contract (vin, sale_date) VALUES
('1HGCM82633A123456', '2023-01-15'),
('5XYZH4AG0CG001234', '2022-10-20');











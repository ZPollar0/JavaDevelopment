-- Question number 3.
SELECT ProductID,ProductName,UnitPrice 
FROM northwind.products
ORDER BY UnitPrice ASC;

-- Question number 4
SELECT ProductName, UnitPrice 
FROM northwind.products
WHERE UnitPrice <= 7.50;

-- Question number 5
SELECT productName, UnitsInStock
FROM northwind.products
WHERE UnitsInStock >= 100 
ORDER BY UnitPrice Desc;

-- Question number 6
SELECT DISTINCT productName, UnitsInStock
FROM northwind.products
WHERE UnitsInStock >= 100 
ORDER BY UnitPrice Desc;

-- Question number 7
SELECT UnitsOnOrder
FROM products
ORDER BY ProductName, UnitsOnOrder DESC;




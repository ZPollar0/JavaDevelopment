-- Question Number 1
SELECT ProductID, ProductName, UnitPrice
FROM products;

-- Question Number 2
SELECT ProductID, ProductName, UnitPrice
FROM products
ORDER BY UnitPrice;

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
WHERE UnitsInStock >= 100;

-- Question number 6
SELECT DISTINCT productName, UnitsInStock
FROM northwind.products
WHERE UnitsInStock >= 100 
ORDER BY UnitPrice Desc, ProductName;

-- Question number 7
SELECT UnitsInStock, ProductName
FROM products
WHERE UnitsInStock <= 1
ORDER BY ProductName;

/* Question Number 8 
The table holds the types of items Northwind sells */

-- Question Number 9
SELECT * FROM categories;

-- Question Number 10
SELECT CategoryID, productName
FROM products
WHERE CategoryID = 8;

-- Question Number 11
SELECT firstName, lastName
FROM employees;

-- Question Number 12
SELECT firstName, lastName, title
FROM  employees
WHERE title LIKE "%Manager%";

-- Question Number 13
SELECT firstName, lastName, title
FROM employees;

-- Question Number 14
SELECT firstName, lastName, title, salary
FROM employees
WHERE salary BETWEEN 2000 AND 2500;

-- Question Number 15
SELECT * FROM suppliers;

-- Question Number 16
SELECT supplierID, productName
FROM products
WHERE SupplierID = 4;






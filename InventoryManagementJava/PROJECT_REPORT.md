# Inventory Management System Using Java and MySQL

## 1. Objective
Develop a desktop application that stores product and stock information in a MySQL database. The project demonstrates Java database connectivity and CRUD operations.

## 2. Technologies Used
- Java 17
- Swing GUI
- JDBC
- MySQL Server
- MySQL Connector/J
- Maven

## 3. Database Design
Database: `inventory_db`

Table: `products`

| Field | Type | Description |
|---|---|---|
| product_id | INT, primary key, auto increment | Unique product ID |
| product_name | VARCHAR(120) | Product name |
| category | VARCHAR(80) | Product category |
| quantity | INT | Current stock count |
| price | DECIMAL(10,2) | Unit price |
| supplier | VARCHAR(120) | Supplier (optional) |
| created_at | TIMESTAMP | Record creation time |

## 4. Features
- Insert new products.
- View products stored in MySQL.
- Search by name, category, or supplier.
- Update a selected product.
- Delete a selected product with confirmation.
- Validate required fields, non-negative quantity, and price.
- Display product count and total stock value.

## 5. Java–MySQL Connectivity
The app uses JDBC with MySQL Connector/J. The `Database` class opens connections through `DriverManager`. CRUD queries use `PreparedStatement`, and product records are retrieved with `ResultSet`. Records are persisted in MySQL and remain after the app is closed.

## 6. Testing Checklist
Fill in actual results after running the project.

| Test | Action | Expected result |
|---|---|---|
| Insert | Add a product | New row appears in app and MySQL |
| Select | Refresh | Existing rows display |
| Search | Search a category or name | Matching products display |
| Update | Select, edit, update | Database record changes |
| Delete | Select and confirm delete | Database row is removed |
| Validation | Enter invalid quantity/price | Warning appears |

## 7. Conclusion
This project demonstrates a Java Swing desktop interface connected to MySQL through JDBC and implements INSERT, SELECT, UPDATE, and DELETE operations.

## 8. Screenshots to include
- Application interface with products.
- MySQL Workbench showing `inventory_db.products`.
- Inserted product in both the app and MySQL.
- Updated product.
- Deleted product verification.

Do not claim tests passed until you have run them on your computer and captured genuine screenshots.

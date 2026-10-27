# Inventory Management System — Java + MySQL

A desktop inventory app using Java Swing and JDBC with MySQL. Supports add, view, search, update, and delete product records, input validation, and total stock-value calculation.

## Requirements
- JDK 17 or newer
- MySQL Server 8.x (or compatible)
- Maven 3.8+
- MySQL user with permission to create/use the database and table

## Setup
1. Start MySQL Server.
2. Open `src/main/java/com/inventory/Database.java`.
3. Set `USER` and `PASSWORD` to your local MySQL credentials. Replace `YOUR_MYSQL_PASSWORD`.
4. Optional: run `database.sql` in MySQL Workbench. The app also creates `inventory_db` and `products` if the configured user has permission.
5. Open a terminal in the project folder and run:

   ```bash
   mvn clean package
   mvn exec:java -Dexec.mainClass="com.inventory.InventoryManagementApp"
   ```

   If your Maven setup does not have the exec plugin cached, use the command below to run it with Maven's exec plugin downloaded:

   ```bash
   mvn org.codehaus.mojo:exec-maven-plugin:3.5.0:java -Dexec.mainClass="com.inventory.InventoryManagementApp"
   ```

## Features
- Add a product using the form.
- Click a table row to populate the form.
- Update the selected product.
- Delete a selected product after confirmation.
- Search by product name, category, or supplier.
- Refresh records from MySQL.
- View product count and estimated stock value (quantity × unit price).
- Uses JDBC and parameterized `PreparedStatement` queries.

## Database verification
Run in MySQL Workbench:

```sql
USE inventory_db;
SELECT * FROM products;
SELECT COUNT(*) AS product_count FROM products;
SELECT SUM(quantity * price) AS total_stock_value FROM products;
```

## Common issues
- **Access denied:** check `USER`/`PASSWORD`.
- **Communications link failure:** start MySQL and check port 3306.
- **CREATE command denied:** execute `database.sql` as an authorized database administrator or grant the app user permission.
- **Maven not found:** install Maven and make sure `mvn -version` works.
- Do not include your actual database password in screenshots or your submission.

## Suggested project submission
Include `main` Java source, `database.sql`, this README, and a 2–4 page report with actual screenshots of:
1. App interface.
2. `inventory_db` and `products` table in MySQL Workbench.
3. Product inserted via app and visible in MySQL.
4. Updated record.
5. Deleted record no longer present.

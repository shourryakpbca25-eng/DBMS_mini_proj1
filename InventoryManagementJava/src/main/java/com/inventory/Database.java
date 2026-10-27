package com.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class Database {
    // Update username/password for your local MySQL installation.
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void initialize() throws SQLException {
        try (Connection connection = DriverManager.getConnection(SERVER_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS inventory_db");
        }

        String sql = """
            CREATE TABLE IF NOT EXISTS products (
                product_id INT AUTO_INCREMENT PRIMARY KEY,
                product_name VARCHAR(120) NOT NULL,
                category VARCHAR(80) NOT NULL,
                quantity INT NOT NULL DEFAULT 0,
                price DECIMAL(10,2) NOT NULL,
                supplier VARCHAR(120),
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                CONSTRAINT chk_quantity_nonnegative CHECK (quantity >= 0),
                CONSTRAINT chk_price_nonnegative CHECK (price >= 0)
            )
            """;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }
}

package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static Connection connection;

    private DatabaseConfig(){}; // Singleton

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/mercadinho";
                String user = "root";
                String password = "password";

                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao conectar com o banco de dados", e);
            }
        }
        return connection;
    }
}

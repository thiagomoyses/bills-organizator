package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC implements Database{
    private static final String URL = "jdbc:sqlite:data/bill_db";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    @Override
    public void init() throws SQLException {
        initPayer();
        initBill();
    }

    private void initPayer() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS payer ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "name TEXT NOT NULL);";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    private void initBill() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS bill ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "title TEXT NOT NULL,"
                        + "description TEXT NOT NULL,"
                        + "amount REAL NOT NULL);";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

}

package main.java.com.hospital.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import main.java.com.hospital.model.Exceptions.DatabaseConnectionException;



public class Database {

    private static Connection conn = null;

    // Connect to the database
    public static void connectDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src\\main\\resources\\database.sqlite";
            conn = DriverManager.getConnection(url);

            // Para los colores
            String green = "\u001B[32m";
            String reset = "\u001B[0m";

            System.out.println(green + " --------------------------- " + reset);
            System.out.println(green + "** BASE DE DATOS CONECTADA **" + reset);
            System.out.println(green + " --------------------------- " + reset);

        } catch (SQLException | ClassNotFoundException e) {
            throw new Exceptions.DatabaseConnectionException("Intento de conectarse a la base de datos falló: " + e.getMessage());
        }
    }

    // Close the database connection
    public static void closeDatabase() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("** BASE DE DATOS DESCONECTADA **");
            }
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Intento de cerrar la base de datos fallido: " + e.getMessage());
        }
    }

    // Create a new record
    public static void createRecord(String table, String columns, String values) {
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("** REGISTRO CREADO **");
        } catch (SQLException e) {
            throw new DatabaseConnectionException("ERROR AL CREAR EL REGISTRO: " + e.getMessage());
        }
    }

    // Read records
    public static void readRecords(String table) {
        String sql = "SELECT * FROM " + table;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" +
                        rs.getString(2) + "\t" +
                        rs.getString(3));
            }
        } catch (SQLException e) {
            throw new DatabaseConnectionException("ERROR AL LEER EL REGISTRO: " + e.getMessage());
        }
    }

    // Update a record
    public static void updateRecord(String table, String set, String condition) {
        String sql = "UPDATE " + table + " SET " + set + " WHERE " + condition;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("** REGISTRO ACTUALIZADO **");
        } catch (SQLException e) {
            throw new DatabaseConnectionException("ERROR AL ACTUALIZAR EL REGISTRO: " + e.getMessage());
        }
    }

    // Delete a record
    public static void deleteRecord(String table, String condition) {
        String sql = "DELETE FROM " + table + " WHERE " + condition;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("** REGISTRO ELIMINADO **");
        } catch (SQLException e) {
            throw new DatabaseConnectionException("ERROR AL ELIMINAR EL REGISTRO: " + e.getMessage());
        }
    }
}

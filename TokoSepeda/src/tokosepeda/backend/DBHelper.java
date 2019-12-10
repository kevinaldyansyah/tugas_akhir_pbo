/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepeda.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alwy
 */
public class DBHelper {
    private static Connection connection;

    public static void openConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/toko_sepeda";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error Koneksi!");
            }
        }
    }
    
    public static Connection getConnection(){
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/toko_sepeda";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error Koneksi!");
            }
        }
        return connection;
    }

    public static int insertQueryGetId(String query) {
        openConnection();
        int num = 0;
        int result = -1;

        try {
            Statement stmt = connection.createStatement();
            num = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                result = rs.getInt(1);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }

        return result;
    }

    public static boolean executeQuery(String query) {
        openConnection();
        boolean result = false;

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);

            result = true;

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ResultSet selectQuery(String query) {
        openConnection();
        ResultSet rs = null;

        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}

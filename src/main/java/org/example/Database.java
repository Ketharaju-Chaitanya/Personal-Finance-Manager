////package org.example;
////
////
////
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.SQLException;
////
////public class Database {
////    private static final String URL = "jdbc:sqlite:C:/Users/sreec/OneDrive/Desktop/Finance Management Project/Finance_Management/personal_finance_manager.db";
////
////    public static Connection connect() throws SQLException {
////        return DriverManager.getConnection(URL);
////    }
////
////    public static void initialize() {
////        try (Connection conn = connect()) {
////            if (conn != null) {
////                String expenseTable = "CREATE TABLE IF NOT EXISTS expenses (" +
////                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
////                        "date TEXT NOT NULL," +
////                        "category TEXT NOT NULL," +
////                        "description TEXT," +
////                        "amount REAL NOT NULL);";
////
////                String budgetTable = "CREATE TABLE IF NOT EXISTS budgets (" +
////                        "category TEXT PRIMARY KEY," +
////                        "limit REAL NOT NULL);";
////
////                conn.createStatement().execute(expenseTable);
////                conn.createStatement().execute(budgetTable);
////            }
////        } catch (SQLException e) {
////            System.out.println(e.getMessage());
////        }
////    }
////}
//package org.example;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Database {
//
//    private static final String DATABASE_URL = "jdbc:sqlite:C:/Users/sreec/OneDrive/Desktop/Finance Management Project/Finance_Management/personal_finance_manager.db";
//
//    public static void initialize() {
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             Statement stmt = conn.createStatement()) {
//
//            // Create expenses table
//            String createExpensesTable = "CREATE TABLE IF NOT EXISTS expenses (" +
//                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    "date TEXT NOT NULL, " +
//                    "category TEXT NOT NULL, " +
//                    "description TEXT, " +
//                    "amount REAL NOT NULL" +
//                    ");";
//            stmt.execute(createExpensesTable);
//
//            // Create budgets table
//            String createBudgetsTable = "CREATE TABLE IF NOT EXISTS budgets (" +
//                    "category TEXT PRIMARY KEY, " +
//                    "budget_limit REAL" +
//                    ");";
//            stmt.execute(createBudgetsTable);
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private static final String DATABASE_URL = "jdbc:sqlite:C:/Users/sreec/OneDrive/Desktop/Finance Management Project/Finance_Management/personal_finance_manager.db";

    public static void initialize() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement createExpensesTable = conn.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS expenses (" +
                             "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                             "date TEXT NOT NULL," +
                             "category TEXT NOT NULL," +
                             "description TEXT NOT NULL," +
                             "amount REAL NOT NULL" +
                             ");");
             PreparedStatement createBudgetsTable = conn.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS budgets (" +
                             "category TEXT PRIMARY KEY," +
                             "budget_limit REAL NOT NULL" +

                             ");");
             PreparedStatement createUsersTable = conn.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS users (" +
                             "username TEXT PRIMARY KEY," +
                             "password TEXT NOT NULL" +
                             ");")) {

            createExpensesTable.executeUpdate();
            createBudgetsTable.executeUpdate();
            createUsersTable.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void registerUser(String username, String hashedPassword) {
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUserPassword(String username) {
        String sql = "SELECT password FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


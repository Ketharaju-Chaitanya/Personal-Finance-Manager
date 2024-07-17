////package org.example;
////
////
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.util.ArrayList;
////import java.util.List;
////
////public class ExpenseManager {
////
////    private static final String DATABASE_URL = "jdbc:sqlite:C:\\Users\\sreec\\OneDrive\\Desktop\\Finance Management Project\\Finance_Management\\personal_finance_manager.db";
////
////    public static void createTableIfNotExists() {
////        String sql = "CREATE TABLE IF NOT EXISTS expenses (" +
////                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
////                "date TEXT NOT NULL," +
////                "category TEXT NOT NULL," +
////                "description TEXT," +
////                "amount REAL NOT NULL)";
////
////        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
////             PreparedStatement pstmt = conn.prepareStatement(sql)) {
////            pstmt.execute();
////        } catch (SQLException e) {
////            System.out.println(e.getMessage());
////        }
////    }
////
////    // Method to add a new expense to the database
////    public static void addExpense(String date, String category, String description, double amount) {
////        String sql = "INSERT INTO expenses(date, category, description, amount) VALUES(?, ?, ?, ?)";
////
////        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
////             PreparedStatement pstmt = conn.prepareStatement(sql)) {
////            pstmt.setString(1, date);
////            pstmt.setString(2, category);
////            pstmt.setString(3, description);
////            pstmt.setDouble(4, amount);
////            pstmt.executeUpdate();
////        } catch (SQLException e) {
////            System.out.println(e.getMessage());
////        }
////    }
////
////    // Method to retrieve all expenses from the database
////    public static List<Expense> getAllExpenses() {
////        List<Expense> expenses = new ArrayList<>();
////        String sql = "SELECT id, date, category, description, amount FROM expenses";
////
////        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
////             PreparedStatement pstmt = conn.prepareStatement(sql);
////             ResultSet rs = pstmt.executeQuery()) {
////
////            while (rs.next()) {
////                Expense expense = new Expense(
////                        rs.getInt("id"),
////                        rs.getString("date"),
////                        rs.getString("category"),
////                        rs.getString("description"),
////                        rs.getDouble("amount")
////                );
////                expenses.add(expense);
////            }
////        } catch (SQLException e) {
////            System.out.println(e.getMessage());
////        }
////
////        return expenses;
////    }
////
////    // Method to delete an expense by ID
////    public static void deleteExpense(int id) {
////        String sql = "DELETE FROM expenses WHERE id = ?";
////
////        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
////             PreparedStatement pstmt = conn.prepareStatement(sql)) {
////            pstmt.setInt(1, id);
////            pstmt.executeUpdate();
////        } catch (SQLException e) {
////            System.out.println(e.getMessage());
////        }
////    }
////}
////
////
//package org.example;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExpenseManager {
//
//    private static final String DATABASE_URL = "jdbc:sqlite:C:/Users/sreec/OneDrive/Desktop/Finance Management Project/Finance_Management/personal_finance_manager.db";
////private static final String DATABASE_URL = "jdbc:sqlite:expenses.db";
//    // Method to create the expenses table if it doesn't exist
//    public static void createTableIfNotExists() {
//        String sql = "CREATE TABLE IF NOT EXISTS expenses (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "date TEXT NOT NULL," +
//                "category TEXT NOT NULL," +
//                "description TEXT," +
//                "amount REAL NOT NULL)";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.execute();
//            System.out.println("Expenses table created or already exists.");
//        } catch (SQLException e) {
//            System.out.println("Error creating table: " + e.getMessage());
//        }
//    }
//    // Method to set budget for a category
//    public static void setBudget(String category, double limit) {
//        String sql = "INSERT OR REPLACE INTO budgets(category, limit) VALUES(?, ?)";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, category);
//            pstmt.setDouble(2, limit);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    // Method to get budget limit for a category
//    public static double getBudget(String category) {
//        String sql = "SELECT limit FROM budgets WHERE category = ?";
//        double limit = 0;
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, category);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                limit = rs.getDouble("limit");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return limit;
//    }
//
//    // Method to add a new expense to the database
////    public static int addExpense()
//    public static void addExpense(String date, String category, String description, double amount) {
//        String sql = "INSERT INTO expenses(date, category, description, amount) VALUES(?, ?, ?, ?)";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, date);
//            pstmt.setString(2, category);
//            pstmt.setString(3, description);
//            pstmt.setDouble(4, amount);
//            pstmt.executeUpdate();
//            System.out.println("Expense added: " + date + ", " + category + ", " + description + ", " + amount);
//        } catch (SQLException e) {
//            System.out.println("Error adding expense: " + e.getMessage());
//        }
//    }
//
//    // Method to retrieve all expenses from the database
//    public static List<Expense> getAllExpenses() {
//        List<Expense> expenses = new ArrayList<>();
//        String sql = "SELECT id, date, category, description, amount FROM expenses";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()) {
//
//            while (rs.next()) {
//                Expense expense = new Expense(
//                        rs.getInt("id"),
//                        rs.getString("date"),
//                        rs.getString("category"),
//                        rs.getString("description"),
//                        rs.getDouble("amount")
//                );
//                expenses.add(expense);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error retrieving expenses: " + e.getMessage());
//        }
//
//        return expenses;
//    }
//
//    // Method to delete an expense by ID
//    public static void deleteExpense(int id) {
//        String sql = "DELETE FROM expenses WHERE id = ?";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//            System.out.println("Expense with ID " + id + " deleted.");
//        } catch (SQLException e) {
//            System.out.println("Error deleting expense: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        // Create the table if it doesn't exist
//        createTableIfNotExists();
//
//        // Test data (for demonstration purposes)
//        addExpense("2024-07-10", "Groceries", "Weekly shopping", 100.0);
//        List<Expense> expenses = getAllExpenses();
//        for (Expense expense : expenses) {
//            System.out.println(expense.getId() + ", " + expense.getDate() + ", " + expense.getCategory() + ", " + expense.getDescription() + ", " + expense.getAmount());
//        }
//    }
//}
//package org.example;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExpenseManager {
//
//    private static final String DATABASE_URL = "jdbc:sqlite:C:/Users/sreec/OneDrive/Desktop/Finance Management Project/Finance_Management/personal_finance_manager.db";
//
//    // Method to add a new expense to the database
//    public static void addExpense(String date, String category, String description, double amount) {
//        double budget = getBudgetForCategory(category);
//        double totalExpenses = getTotalExpensesForCategory(category);
//
//        if (totalExpenses + amount > budget) {
//            System.out.println("Budget crossed");
//            return;
//        }
//
//        String sql = "INSERT INTO expenses(date, category, description, amount) VALUES(?, ?, ?, ?)";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, date);
//            pstmt.setString(2, category);
//            pstmt.setString(3, description);
//            pstmt.setDouble(4, amount);
//            pstmt.executeUpdate();
//            System.out.println("Expense added: " + date + ", " + category + ", " + description + ", " + amount);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    // Method to set a budget for a category
//    public static void setBudget(String category, double budgetLimit) {
//        String sql = "INSERT INTO budgets(category, budget_limit) VALUES(?, ?) " +
//                "ON CONFLICT(category) DO UPDATE SET budget_limit = excluded.budget_limit";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, category);
//            pstmt.setDouble(2, budgetLimit);
//            pstmt.executeUpdate();
//            System.out.println("Budget set: " + category + ", " + budgetLimit);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    // Method to retrieve the budget limit for a category
//    public static double getBudgetForCategory(String category) {
//        String sql = "SELECT budget_limit FROM budgets WHERE category = ?";
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, category);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getDouble("budget_limit");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return 0;
//    }
//
//    // Method to retrieve the total expenses for a category
//    public static double getTotalExpensesForCategory(String category) {
//        String sql = "SELECT SUM(amount) as total FROM expenses WHERE category = ?";
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, category);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getDouble("total");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return 0;
//    }
//
//    // Method to retrieve all expenses from the database
//    public static List<Expense> getAllExpenses() {
//        List<Expense> expenses = new ArrayList<>();
//        String sql = "SELECT id, date, category, description, amount FROM expenses";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()) {
//
//            while (rs.next()) {
//                Expense expense = new Expense(
//                        rs.getInt("id"),
//                        rs.getString("date"),
//                        rs.getString("category"),
//                        rs.getString("description"),
//                        rs.getDouble("amount")
//                );
//                expenses.add(expense);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return expenses;
//    }
//
//    // Method to delete an expense by ID
//    public static void deleteExpense(int id) {
//        String sql = "DELETE FROM expenses WHERE id = ?";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
//package org.example;
//
//import javafx.application.Platform;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExpenseManager {
//
//    private static final String DATABASE_URL = "jdbc:sqlite:C:/Users/sreec/OneDrive/Desktop/Finance Management Project/Finance_Management/personal_finance_manager.db";
//
//    // Method to add a new expense to the database
//    public static void addExpense(String date, String category, String description, double amount) {
//        double budget = getBudgetForCategory(category);
//        double totalExpenses = getTotalExpensesForCategory(category);
//
//        if (totalExpenses + amount > budget) {
//            Platform.runLater(() -> showAlert("Budget Crossed!", "You have exceeded your budget for " + category));
//            return;
//        }
//
//        String sql = "INSERT INTO expenses(date, category, description, amount) VALUES(?, ?, ?, ?)";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, date);
//            pstmt.setString(2, category);
//            pstmt.setString(3, description);
//            pstmt.setDouble(4, amount);
//            pstmt.executeUpdate();
//            System.out.println("Expense added: " + date + ", " + category + ", " + description + ", " + amount);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    // Method to show an alert dialog
//    private static void showAlert(String title, String message) {
//        Alert alert = new Alert(AlertType.WARNING);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
//    // Method to set a budget for a category
//    public static void setBudget(String category, double budgetLimit) {
//        String sql = "INSERT INTO budgets(category, budget_limit) VALUES(?, ?) " +
//                "ON CONFLICT(category) DO UPDATE SET budget_limit = excluded.budget_limit";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, category);
//            pstmt.setDouble(2, budgetLimit);
//            pstmt.executeUpdate();
//            System.out.println("Budget set: " + category + ", " + budgetLimit);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    // Method to retrieve the budget limit for a category
//    public static double getBudgetForCategory(String category) {
//        String sql = "SELECT budget_limit FROM budgets WHERE category = ?";
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, category);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getDouble("budget_limit");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return 0;
//    }
//
//    // Method to retrieve the total expenses for a category
//    public static double getTotalExpensesForCategory(String category) {
//        String sql = "SELECT SUM(amount) as total FROM expenses WHERE category = ?";
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, category);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getDouble("total");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return 0;
//    }
//
//    // Method to retrieve all expenses from the database
//    public static List<Expense> getAllExpenses() {
//        List<Expense> expenses = new ArrayList<>();
//        String sql = "SELECT id, date, category, description, amount FROM expenses";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()) {
//
//            while (rs.next()) {
//                Expense expense = new Expense(
//                        rs.getInt("id"),
//                        rs.getString("date"),
//                        rs.getString("category"),
//                        rs.getString("description"),
//                        rs.getDouble("amount")
//                );
//                expenses.add(expense);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return expenses;
//    }
//
//    // Method to delete an expense by ID
//    public static void deleteExpense(int id) {
//        String sql = "DELETE FROM expenses WHERE id = ?";
//
//        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
package org.example;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {

    private static final String DATABASE_URL = "jdbc:sqlite:C:/Users/sreec/OneDrive/Desktop/Finance Management Project/Finance_Management/personal_finance_manager.db";

    // Method to add a new expense to the database
    public static void addExpense(String date, String category, String description, double amount) {
        double budget = getBudgetForCategory(category);
        double totalExpenses = getTotalExpensesForCategory(category);

        if (totalExpenses + amount > budget) {
            Platform.runLater(() -> showAlert("Budget Crossed!", "You have exceeded your budget for " + category));
            return;
        }

        String sql = "INSERT INTO expenses(date, category, description, amount) VALUES(?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, date);
            pstmt.setString(2, category);
            pstmt.setString(3, description);
            pstmt.setDouble(4, amount);
            pstmt.executeUpdate();
            Platform.runLater(() -> showAlert("Success", "Expense added successfully: " + date + ", " + category + ", " + description + ", " + amount));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to show an alert dialog
    private static void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to set a budget for a category
    public static void setBudget(String category, double budgetLimit) {
        String sql = "INSERT INTO budgets(category, budget_limit) VALUES(?, ?) " +
                "ON CONFLICT(category) DO UPDATE SET budget_limit = excluded.budget_limit";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            pstmt.setDouble(2, budgetLimit);
            pstmt.executeUpdate();
            System.out.println("Budget set: " + category + ", " + budgetLimit);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to retrieve the budget limit for a category
    public static double getBudgetForCategory(String category) {
        String sql = "SELECT budget_limit FROM budgets WHERE category = ?";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("budget_limit");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    // Method to retrieve the total expenses for a category
    public static double getTotalExpensesForCategory(String category) {
        String sql = "SELECT SUM(amount) as total FROM expenses WHERE category = ?";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    // Method to retrieve all expenses from the database
    public static List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT id, date, category, description, amount FROM expenses";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getInt("id"),
                        rs.getString("date"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getDouble("amount")
                );
                expenses.add(expense);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return expenses;
    }
    // Method to get total expenses for a specific month
    public static double getTotalExpensesForMonth(String month) {
        String sql = "SELECT SUM(amount) as total FROM expenses WHERE strftime('%Y-%m', date) = ?";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, month);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    // Method to get budget for a specific month
    public static double getBudgetForMonth(String month) {
        String sql = "SELECT SUM(budget_limit) as total FROM budgets WHERE strftime('%Y-%m', month) = ?";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, month);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    // Method to retrieve monthly expenses for the specified month (format: YYYY-MM)
    public static List<Expense> getMonthlyExpenses(String month) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT id, date, category, description, amount FROM expenses WHERE date LIKE ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, month + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Expense expense = new Expense(
                            rs.getInt("id"),
                            rs.getString("date"),
                            rs.getString("category"),
                            rs.getString("description"),
                            rs.getDouble("amount")
                    );
                    expenses.add(expense);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return expenses;
    }


    // Method to delete an expense by ID
    public static void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


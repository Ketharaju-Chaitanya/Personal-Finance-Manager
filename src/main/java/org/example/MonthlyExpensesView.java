//package org.example;
//
//import javafx.geometry.Insets;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//
//import java.util.List;
//
//public class MonthlyExpensesView {
//
//    public VBox getMonthlyExpensesView() {
//        VBox vbox = new VBox(10);
//        vbox.setPadding(new Insets(10, 10, 10, 10));
//
//        Label monthLabel = new Label("Enter Month (YYYY-MM):");
//        TextField monthInput = new TextField();
//
//        ListView<String> expenseListView = new ListView<>();
//        Button viewButton = new Button("View Expenses");
//
//        viewButton.setOnAction(e -> {
//            String month = monthInput.getText();
//            List<Expense> monthlyExpenses = ExpenseManager.getMonthlyExpenses(month);
//            expenseListView.getItems().clear();
//            for (Expense expense : monthlyExpenses) {
//                expenseListView.getItems().add(expense.toString());
//            }
//        });
//
//        vbox.getChildren().addAll(monthLabel, monthInput, viewButton, expenseListView);
//        return vbox;
//    }
//}
//
//package org.example;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//
//import java.util.List;
//
//public class MonthlyExpensesView {
//
//    public static void showMonthlyExpenses(Stage primaryStage) {
//        VBox layout = new VBox(10);
//        layout.setPadding(new Insets(20, 20, 20, 20));
//
//        Label promptLabel = new Label("Enter Month (YYYY-MM):");
//        TextField monthInput = new TextField();
//        Button viewButton = new Button("View Expenses");
//        TableView<Expense> tableView = new TableView<>();
//
//        viewButton.setOnAction(e -> {
//            String month = monthInput.getText();
//            List<Expense> expenses = ExpenseManager.getMonthlyExpenses(month);
//            ObservableList<Expense> expenseList = FXCollections.observableArrayList(expenses);
//            tableView.setItems(expenseList);
//        });
//
//        // Button to calculate remaining balance
//
//        Button calculateBalanceButton = new Button("Calculate Remaining Balance");
//        Label remainingBalanceLabel = new Label();
//
//        calculateBalanceButton.setOnAction(e -> {
//            String month = monthInput.getText();
//            double totalExpenses = ExpenseManager.getTotalExpensesForMonth(month);
//            double remainingBalance = ExpenseManager.getBudgetForMonth(month) - totalExpenses;
//            remainingBalanceLabel.setText(String.format("Remaining Balance: $%.2f", remainingBalance));
//        });
//
//        HBox balanceBox = new HBox(10);
//        balanceBox.getChildren().addAll(calculateBalanceButton, remainingBalanceLabel);
//
//        TableColumn<Expense, Integer> idColumn = new TableColumn<>("ID");
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<Expense, String> dateColumn = new TableColumn<>("Date");
//        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//
//        TableColumn<Expense, String> categoryColumn = new TableColumn<>("Category");
//        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//
//        TableColumn<Expense, String> descriptionColumn = new TableColumn<>("Description");
//        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
//
//        TableColumn<Expense, Double> amountColumn = new TableColumn<>("Amount");
//        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
//
//        tableView.getColumns().addAll(idColumn, dateColumn, categoryColumn, descriptionColumn, amountColumn);
//
//
//
//
//        layout.getChildren().addAll(promptLabel, monthInput, viewButton, tableView);
//
//        Scene scene = new Scene(layout, 800, 600);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//}
package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.List;

public class MonthlyExpensesView {

    public static void showMonthlyExpenses(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        Label promptLabel = new Label("Enter Month (YYYY-MM):");
        TextField monthInput = new TextField();
        Button viewButton = new Button("View Expenses");
        TableView<Expense> tableView = new TableView<>();

        // Calculate Remaining Balance Button
//        Button calculateBalanceButton = new Button("Calculate Remaining Balance");
//        Label remainingBalanceLabel = new Label();
//
//        calculateBalanceButton.setOnAction(e -> {
//            String month = monthInput.getText();
//            double totalExpenses = ExpenseManager.getTotalExpensesForMonth(month);
//            double budget = ExpenseManager.getBudgetForMonth(month);
//            double remainingBalance = budget - totalExpenses;
//            remainingBalanceLabel.setText("Remaining Balance: $" + remainingBalance);
//        });

//        HBox buttonBox = new HBox(10);
//        buttonBox.getChildren().addAll(calculateBalanceButton, remainingBalanceLabel);

        // View Expenses Button
        viewButton.setOnAction(e -> {
            String month = monthInput.getText();
            List<Expense> expenses = ExpenseManager.getMonthlyExpenses(month);
            ObservableList<Expense> expenseList = FXCollections.observableArrayList(expenses);
            tableView.setItems(expenseList);
        });

        TableColumn<Expense, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Expense, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Expense, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Expense, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Expense, Double> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        tableView.getColumns().addAll(idColumn, dateColumn, categoryColumn, descriptionColumn, amountColumn);

        layout.getChildren().addAll(promptLabel, monthInput, viewButton, tableView);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

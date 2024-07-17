//package org.example;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Tab;
//import javafx.scene.control.TabPane;
//import javafx.stage.Stage;
//
//public class PersonalFinanceManagerApp extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Personal Finance Manager");
//
//        // Create a TabPane to hold different tabs
//        TabPane tabPane = new TabPane();
//
//        // Add tabs to the TabPane
//        Tab expenseTab = new Tab("Add Expense", new ExpenseInputForm().getExpenseInputForm());
//        Tab budgetTab = new Tab("Set Budget", new BudgetInputForm().getBudgetInputForm());
//        Tab reportTab = new Tab("Report", new ReportView().getReportView());
//
//        tabPane.getTabs().add(expenseTab);
//        tabPane.getTabs().add(budgetTab);
//        tabPane.getTabs().add(reportTab);
//
//        // Set up the Scene and Stage
//        Scene scene = new Scene(tabPane, 800, 600);
//        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        // Initialize the database connection
//        Database.initialize();
//        // Launch the JavaFX application
//        launch(args);
//    }
//}
package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonalFinanceManagerApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Show the login page
        LoginPage.showLogin(primaryStage);
    }

    public static void showMainApp(Stage primaryStage) {
//
        primaryStage.setTitle("Personal Finance Manager");
//
        // Create a TabPane to hold different tabs
        TabPane tabPane = new TabPane();

        // Add tabs to the TabPane
        Tab expenseTab = new Tab("Add Expense", new ExpenseInputForm().getExpenseInputForm());
        Tab budgetTab = new Tab("Set Budget", new BudgetInputForm().getBudgetInputForm());
        Tab reportTab = new Tab("Report", new ReportView().getReportView());

        // Add a tab for Monthly Expenses View
        Tab monthlyExpensesTab = new Tab("Monthly Expenses");
        monthlyExpensesTab.setContent(new VBox());
        monthlyExpensesTab.setOnSelectionChanged(e -> {
            if (monthlyExpensesTab.isSelected()) {
                MonthlyExpensesView.showMonthlyExpenses(primaryStage);
            }
        });
//        Tab monthlyExpensesTab = new Tab("Monthly Expenses", new MonthlyExpensesView().getMonthlyExpensesView());
//        tabPane.getTabs().add(expenseTab);
//        tabPane.getTabs().add(budgetTab);
//        tabPane.getTabs().add(reportTab);
//        tabPane.getTabs().add(monthlyExpensesTab);
        tabPane.getTabs().addAll(expenseTab, budgetTab, reportTab, monthlyExpensesTab);
        // Set up the Scene and Stage
        Scene scene = new Scene(tabPane, 800, 600);
//        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        scene.getStylesheets().add(PersonalFinanceManagerApp.class.getResource("/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Initialize the database connection
        Database.initialize();
        // Launch the JavaFX application
        launch(args);
    }
}

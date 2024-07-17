////package org.example;
////
////import javafx.scene.layout.GridPane;
////import javafx.scene.control.Button;
////import javafx.scene.control.Label;
////import javafx.scene.control.TextField;
////import javafx.scene.control.Alert;
////import javafx.scene.control.Alert.AlertType;
////
////public class ExpenseInputForm {
////
////    public static GridPane getExpenseInputForm() {
////        GridPane gridPane = new GridPane();
////
////        Label dateLabel = new Label("Date:");
////        TextField dateField = new TextField();
////
////        Label categoryLabel = new Label("Category:");
////        TextField categoryField = new TextField();
////
////        Label descriptionLabel = new Label("Description:");
////        TextField descriptionField = new TextField();
////
////        Label amountLabel = new Label("Amount:");
////        TextField amountField = new TextField();
////
////        Button addButton = new Button("Add Expense");
////
////        // Add components to the grid pane
////        gridPane.add(dateLabel, 0, 0);
////        gridPane.add(dateField, 1, 0);
////        gridPane.add(categoryLabel, 0, 1);
////        gridPane.add(categoryField, 1, 1);
////        gridPane.add(descriptionLabel, 0, 2);
////        gridPane.add(descriptionField, 1, 2);
////        gridPane.add(amountLabel, 0, 3);
////        gridPane.add(amountField, 1, 3);
////        gridPane.add(addButton, 1, 4);
////
////        // Add action listener to the button to handle adding expenses
////        addButton.setOnAction(e -> {
////            String date = dateField.getText();
////            String category = categoryField.getText();
////            String description = descriptionField.getText();
////            double amount = Double.parseDouble(amountField.getText());
////
////            ExpenseManager.addExpense(date, category, description, amount);
////
////            Alert alert = new Alert(AlertType.INFORMATION);
////            alert.setTitle("Expense Added");
////            alert.setHeaderText(null);
////            alert.setContentText("Expense added successfully!");
////            alert.showAndWait();
////
////            // Clear the input fields
////            dateField.clear();
////            categoryField.clear();
////            descriptionField.clear();
////            amountField.clear();
////        });
////
////        return gridPane;
////    }
////}
//package org.example;
//
//import javafx.geometry.Insets;
//import javafx.scene.Node;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//
//public class ExpenseInputForm {
//
//    public Node getExpenseInputForm() {
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(10, 10, 10, 10));
//        grid.setVgap(8);
//        grid.setHgap(10);
//
//        // Date input
//        Label dateLabel = new Label("Date:");
//        GridPane.setConstraints(dateLabel, 0, 0);
//        TextField dateInput = new TextField();
//        GridPane.setConstraints(dateInput, 1, 0);
//
//        // Category input
//        Label categoryLabel = new Label("Category:");
//        GridPane.setConstraints(categoryLabel, 0, 1);
//        TextField categoryInput = new TextField();
//        GridPane.setConstraints(categoryInput, 1, 1);
//
//        // Description input
//        Label descriptionLabel = new Label("Description:");
//        GridPane.setConstraints(descriptionLabel, 0, 2);
//        TextField descriptionInput = new TextField();
//        GridPane.setConstraints(descriptionInput, 1, 2);
//
//        // Amount input
//        Label amountLabel = new Label("Amount:");
//        GridPane.setConstraints(amountLabel, 0, 3);
//        TextField amountInput = new TextField();
//        GridPane.setConstraints(amountInput, 1, 3);
//
//        // Submit button
//        Button submitButton = new Button("Add Expense");
//        GridPane.setConstraints(submitButton, 1, 4);
//        submitButton.setOnAction(e -> {
//            String date = dateInput.getText();
//            String category = categoryInput.getText();
//            String description = descriptionInput.getText();
//            double amount = Double.parseDouble(amountInput.getText());
//
//            // Add expense to the database
//            ExpenseManager.addExpense(date, category, description, amount);
//
//            // Clear inputs after adding
//            dateInput.clear();
//            categoryInput.clear();
//            descriptionInput.clear();
//            amountInput.clear();
//        });
//
//        grid.getChildren().addAll(dateLabel, dateInput, categoryLabel, categoryInput, descriptionLabel, descriptionInput, amountLabel, amountInput, submitButton);
//
//        return grid;
//    }
//}
package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ExpenseInputForm {

    public static GridPane getExpenseInputForm() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Date
        Label dateLabel = new Label("Date:");
        GridPane.setConstraints(dateLabel, 0, 0);
        TextField dateInput = new TextField();
        GridPane.setConstraints(dateInput, 1, 0);

        // Category
        Label categoryLabel = new Label("Category:");
        GridPane.setConstraints(categoryLabel, 0, 1);
        TextField categoryInput = new TextField();
        GridPane.setConstraints(categoryInput, 1, 1);

        // Description
        Label descriptionLabel = new Label("Description:");
        GridPane.setConstraints(descriptionLabel, 0, 2);
        TextField descriptionInput = new TextField();
        GridPane.setConstraints(descriptionInput, 1, 2);

        // Amount
        Label amountLabel = new Label("Amount:");
        GridPane.setConstraints(amountLabel, 0, 3);
        TextField amountInput = new TextField();
        GridPane.setConstraints(amountInput, 1, 3);

        // Add Expense Button
        Button addButton = new Button("Add Expense");
        GridPane.setConstraints(addButton, 1, 4);

        addButton.setOnAction(e -> {
            String date = dateInput.getText();
            String category = categoryInput.getText();
            String description = descriptionInput.getText();
            String amountText = amountInput.getText();

            if (date.isEmpty()) {
                showAlert("Missing Field", "Please enter the Date field");
            } else if (category.isEmpty()) {
                showAlert("Missing Field", "Please enter the Category field");
            } else if (description.isEmpty()) {
                showAlert("Missing Field", "Please enter the Description field");
            } else if (amountText.isEmpty()) {
                showAlert("Missing Field", "Please enter the Amount field");
            } else {
                try {
                    double amount = Double.parseDouble(amountText);
                    ExpenseManager.addExpense(date, category, description, amount);
                } catch (NumberFormatException ex) {
                    showAlert("Invalid Amount", "Please enter a valid number for the amount");
                }
            }
        });

        grid.getChildren().addAll(dateLabel, dateInput, categoryLabel, categoryInput, descriptionLabel, descriptionInput, amountLabel, amountInput, addButton);

        return grid;
    }

    // Method to show an alert dialog
    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

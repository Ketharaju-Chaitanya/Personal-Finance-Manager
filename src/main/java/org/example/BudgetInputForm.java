package org.example;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BudgetInputForm {

    public Node getBudgetInputForm() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Category input
        Label categoryLabel = new Label("Category:");
        GridPane.setConstraints(categoryLabel, 0, 0);
        TextField categoryInput = new TextField();
        GridPane.setConstraints(categoryInput, 1, 0);

        // Budget input
        Label budgetLabel = new Label("Budget:");
        GridPane.setConstraints(budgetLabel, 0, 1);
        TextField budgetInput = new TextField();
        GridPane.setConstraints(budgetInput, 1, 1);

        // Submit button
        Button submitButton = new Button("Set Budget");
        GridPane.setConstraints(submitButton, 1, 2);
        submitButton.setOnAction(e -> {
            String category = categoryInput.getText();
            double budget = Double.parseDouble(budgetInput.getText());

            // Set budget in the database
            ExpenseManager.setBudget(category, budget);

            // Clear inputs after adding
            categoryInput.clear();
            budgetInput.clear();
        });

        grid.getChildren().addAll(categoryLabel, categoryInput, budgetLabel, budgetInput, submitButton);

        return grid;
    }
}

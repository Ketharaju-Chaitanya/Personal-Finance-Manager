//package org.example;
//import javafx.geometry.Insets;
//import javafx.scene.Node;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//
//public class ReportView {
//    public static Node getReportView() {
//        TableView<Expense> table = new TableView<>();
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
//        table.getColumns().addAll(dateColumn, categoryColumn, descriptionColumn, amountColumn);
//
//        VBox layout = new VBox(table);
//        layout.setPadding(new Insets(20));
//
//        return layout;
//    }
//}
//
package org.example;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ReportView {

    public Node getReportView() {
        TableView<Expense> table = new TableView<>();

        TableColumn<Expense, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Expense, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Expense, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Expense, Double> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        table.getColumns().add(dateColumn);
        table.getColumns().add(categoryColumn);
        table.getColumns().add(descriptionColumn);
        table.getColumns().add(amountColumn);

        table.getItems().addAll(ExpenseManager.getAllExpenses());

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.getChildren().add(table);

        return vbox;
    }
}

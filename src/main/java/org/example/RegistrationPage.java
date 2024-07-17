//package org.example;
//
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//import org.mindrot.jbcrypt.BCrypt;
//
//
//
//public class RegistrationPage {
//
//    public static void showRegistration(Stage primaryStage) {
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(10, 10, 10, 10));
//        grid.setVgap(8);
//        grid.setHgap(10);
//
//        // Username
//        Label userLabel = new Label("Username:");
//        GridPane.setConstraints(userLabel, 0, 0);
//        TextField userInput = new TextField();
//        GridPane.setConstraints(userInput, 1, 0);
//
//        // Password
//        Label passLabel = new Label("Password:");
//        GridPane.setConstraints(passLabel, 0, 1);
//        PasswordField passInput = new PasswordField();
//        GridPane.setConstraints(passInput, 1, 1);
//
//        // Confirm Password
//        Label confirmPassLabel = new Label("Confirm Password:");
//        GridPane.setConstraints(confirmPassLabel, 0, 2);
//        PasswordField confirmPassInput = new PasswordField();
//        GridPane.setConstraints(confirmPassInput, 1, 2);
//
//        // Register Button
//        Button registerButton = new Button("Register");
//        GridPane.setConstraints(registerButton, 1, 3);
//
//        registerButton.setOnAction(e -> {
//            String username = userInput.getText();
//            String password = passInput.getText();
//            String confirmPassword = confirmPassInput.getText();
//
//            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
//                showAlert("Registration Failed", "All fields are required.");
//            } else if (!password.equals(confirmPassword)) {
//                showAlert("Registration Failed", "Passwords do not match.");
//            } else {
//                UserManager.registerUser(username, password);
//                showAlert("Registration Successful", "User registered successfully.");
//                LoginPage.showLogin(primaryStage);
//            }
//        });
//
//        grid.getChildren().addAll(userLabel, userInput, passLabel, passInput, confirmPassLabel, confirmPassInput, registerButton);
//
//        Scene scene = new Scene(grid, 300, 200);
//        scene.getStylesheets().add(RegistrationPage.class.getResource("/styles.css").toExternalForm());
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private static void showAlert(String title, String message) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//}
//
package org.example;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

public class RegistrationPage {

    public static void showRegistration(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.getStyleClass().add("form-container");

        // Username
        Label userLabel = new Label("Username:");
        GridPane.setConstraints(userLabel, 0, 0);
        TextField userInput = new TextField();
        GridPane.setConstraints(userInput, 1, 0);

        // Password
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);
        PasswordField passInput = new PasswordField();
        GridPane.setConstraints(passInput, 1, 1);

        // Confirm Password
        Label confirmPassLabel = new Label("Confirm Password:");
        GridPane.setConstraints(confirmPassLabel, 0, 2);
        PasswordField confirmPassInput = new PasswordField();
        GridPane.setConstraints(confirmPassInput, 1, 2);

        // Register Button
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 3);

        registerButton.setOnAction(e -> {
            String username = userInput.getText();
            String password = passInput.getText();
            String confirmPassword = confirmPassInput.getText();

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                showAlert("Registration Failed", "All fields are required.");
            } else if (!password.equals(confirmPassword)) {
                showAlert("Registration Failed", "Passwords do not match.");
            } else {
                UserManager.registerUser(username, password);
                showAlert("Registration Successful", "User registered successfully.");
                LoginPage.showLogin(primaryStage);
            }
        });

        grid.getChildren().addAll(userLabel, userInput, passLabel, passInput, confirmPassLabel, confirmPassInput, registerButton);

        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add(RegistrationPage.class.getResource("/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

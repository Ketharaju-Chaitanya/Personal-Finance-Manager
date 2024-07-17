////package org.example;
////
////import javafx.geometry.Insets;
////import javafx.scene.Scene;
////import javafx.scene.control.Alert;
////import javafx.scene.control.Button;
////import javafx.scene.control.Label;
////import javafx.scene.control.PasswordField;
////import javafx.scene.control.TextField;
////import javafx.scene.layout.GridPane;
////import javafx.stage.Stage;
////
////public class LoginPage {
////
////    private static final String USERNAME = "user";
////    private static final String PASSWORD = "password";
////
////    public static void showLogin(Stage primaryStage) {
////        GridPane grid = new GridPane();
////        grid.setPadding(new Insets(10, 10, 10, 10));
////        grid.setVgap(8);
////        grid.setHgap(10);
////
////        // Username
////        Label userLabel = new Label("Username:");
////        GridPane.setConstraints(userLabel, 0, 0);
////        TextField userInput = new TextField();
////        GridPane.setConstraints(userInput, 1, 0);
////
////        // Password
////        Label passLabel = new Label("Password:");
////        GridPane.setConstraints(passLabel, 0, 1);
////        PasswordField passInput = new PasswordField();
////        GridPane.setConstraints(passInput, 1, 1);
////
////        // Login Button
////        Button loginButton = new Button("Login");
////        GridPane.setConstraints(loginButton, 1, 2);
////
////        loginButton.setOnAction(e -> {
////            String username = userInput.getText();
////            String password = passInput.getText();
////
////            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
////                PersonalFinanceManagerApp.showMainApp(primaryStage);
////            } else {
////                showAlert("Login Failed", "Incorrect username or password.");
////            }
////        });
////
////        grid.getChildren().addAll(userLabel, userInput, passLabel, passInput, loginButton);
////
////        Scene scene = new Scene(grid, 300, 200);
////        scene.getStylesheets().add(LoginPage.class.getResource("/styles.css").toExternalForm());
////        primaryStage.setScene(scene);
////        primaryStage.show();
////    }
////
////    private static void showAlert(String title, String message) {
////        Alert alert = new Alert(Alert.AlertType.INFORMATION);
////        alert.setTitle(title);
////        alert.setHeaderText(null);
////        alert.setContentText(message);
////        alert.showAndWait();
////    }
////}
////
//package org.example;
//
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class LoginPage {
//
//    private static final String USERNAME = "user";
//    private static final String PASSWORD = "password";
//
//    public static void showLogin(Stage primaryStage) {
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
//        // Show Password checkbox
//        CheckBox showPassword = new CheckBox("Show Password");
//        GridPane.setConstraints(showPassword, 1, 2);
//
//        // TextField for showing password
//        TextField passInputVisible = new TextField();
//        passInputVisible.setManaged(false);
//        passInputVisible.setVisible(false);
//        GridPane.setConstraints(passInputVisible, 1, 1);
//
//        passInputVisible.managedProperty().bind(showPassword.selectedProperty());
//        passInputVisible.visibleProperty().bind(showPassword.selectedProperty());
//
//        passInput.managedProperty().bind(showPassword.selectedProperty().not());
//        passInput.visibleProperty().bind(showPassword.selectedProperty().not());
//
//        passInputVisible.textProperty().bindBidirectional(passInput.textProperty());
//
//        // Login Button
//        Button loginButton = new Button("Login");
//        GridPane.setConstraints(loginButton, 1, 3);
//
//        loginButton.setOnAction(e -> {
//            String username = userInput.getText();
//            String password = passInput.getText();
//
//            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
//                PersonalFinanceManagerApp.showMainApp(primaryStage);
//            } else {
//                showAlert("Login Failed", "Incorrect username or password.");
//            }
//        });
//
//        grid.getChildren().addAll(userLabel, userInput, passLabel, passInput, showPassword, passInputVisible, loginButton);
//
//        Scene scene = new Scene(grid, 300, 200);
//        scene.getStylesheets().add(LoginPage.class.getResource("/styles.css").toExternalForm());
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
//package org.example;
//
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//import org.mindrot.jbcrypt.BCrypt;
//
//public class LoginPage {
//
//    public static void showLogin(Stage primaryStage) {
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
//        // Show Password checkbox
//        CheckBox showPassword = new CheckBox("Show Password");
//        GridPane.setConstraints(showPassword, 1, 2);
//
//        // TextField for showing password
//        TextField passInputVisible = new TextField();
//        passInputVisible.setManaged(false);
//        passInputVisible.setVisible(false);
//        GridPane.setConstraints(passInputVisible, 1, 1);
//
//        passInputVisible.managedProperty().bind(showPassword.selectedProperty());
//        passInputVisible.visibleProperty().bind(showPassword.selectedProperty());
//
//        passInput.managedProperty().bind(showPassword.selectedProperty().not());
//        passInput.visibleProperty().bind(showPassword.selectedProperty().not());
//
//        passInputVisible.textProperty().bindBidirectional(passInput.textProperty());
//
//        // Login Button
//        Button loginButton = new Button("Login");
//        GridPane.setConstraints(loginButton, 1, 3);
//
//        // Register Button
//        Button registerButton = new Button("Register");
//        GridPane.setConstraints(registerButton, 1, 4);
//
//        registerButton.setOnAction(e -> RegistrationPage.showRegistration(primaryStage));
//
//        loginButton.setOnAction(e -> {
//            String username = userInput.getText();
//            String password = passInput.getText();
//            String storedHashedPassword = Database.getUserPassword(username);
//
//            if (storedHashedPassword != null && BCrypt.checkpw(password, storedHashedPassword)) {
//                PersonalFinanceManagerApp.showMainApp(primaryStage);
//            } else {
//                showAlert("Login Failed", "Incorrect username or password.");
//            }
//        });
//
//        grid.getChildren().addAll(userLabel, userInput, passLabel, passInput, showPassword, passInputVisible, loginButton, registerButton);
//
//        Scene scene = new Scene(grid, 300, 200);
//        scene.getStylesheets().add(LoginPage.class.getResource("/styles.css").toExternalForm());
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
package org.example;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

public class LoginPage {

    public static void showLogin(Stage primaryStage) {
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

        // Show Password checkbox
        CheckBox showPassword = new CheckBox("Show Password");
        GridPane.setConstraints(showPassword, 1, 2);

        // TextField for showing password
        TextField passInputVisible = new TextField();
        passInputVisible.setManaged(false);
        passInputVisible.setVisible(false);
        GridPane.setConstraints(passInputVisible, 1, 1);

        passInputVisible.managedProperty().bind(showPassword.selectedProperty());
        passInputVisible.visibleProperty().bind(showPassword.selectedProperty());

        passInput.managedProperty().bind(showPassword.selectedProperty().not());
        passInput.visibleProperty().bind(showPassword.selectedProperty().not());

        passInputVisible.textProperty().bindBidirectional(passInput.textProperty());

        // Login Button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 3);

        // Register Button
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 4);

        registerButton.setOnAction(e -> RegistrationPage.showRegistration(primaryStage));

        loginButton.setOnAction(e -> {
            String username = userInput.getText();
            String password = passInput.getText();
            String storedHashedPassword = Database.getUserPassword(username);

            if (storedHashedPassword != null && BCrypt.checkpw(password, storedHashedPassword)) {
                PersonalFinanceManagerApp.showMainApp(primaryStage);
            } else {
                showAlert("Login Failed", "Incorrect username or password.");
            }
        });

        grid.getChildren().addAll(userLabel, userInput, passLabel, passInput, showPassword, passInputVisible, loginButton, registerButton);

        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add(LoginPage.class.getResource("/styles.css").toExternalForm());
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

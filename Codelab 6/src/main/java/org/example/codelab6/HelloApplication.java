package org.example.codelab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hallaw");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label userLabel = new Label("User Name:");
        TextField userTextField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Sign in");
        Label messageLabel = new Label();

        gridPane.add(userLabel, 0, 0);
        gridPane.add(userTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);
        gridPane.add(messageLabel, 1, 3);

        loginButton.setOnAction(e -> {
            String userName = userTextField.getText();
            String password = passwordField.getText();

            if (authenticate(userName, password)) {
                messageLabel.setText("Login successful!");
                messageLabel.setStyle("-fx-text-fill: green;");
                openWelcomeStage();
                primaryStage.close();
            } else {
                messageLabel.setText("Username or Password is incorrect");
                messageLabel.setStyle("-fx-text-fill: red;");
            }
        });

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean authenticate(String userName, String password) {
        return "adit".equals(userName) && "password".equals(password);
    }

    private void openWelcomeStage() {
        Stage welcomeStage = new Stage();
        welcomeStage.setTitle("Welcome");

        StackPane stackPane = new StackPane();
        Label welcomeLabel = new Label("Hallaw Kak Adit!");

        stackPane.getChildren().add(welcomeLabel);

        Scene scene = new Scene(stackPane, 300, 200);
        welcomeStage.setScene(scene);
        welcomeStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package org.example.Tugas6;

import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import org.example.Tugas6.com.main.LibrarySystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();
        textField.setPromptText("Masukkan Text: ");

        Button button = new Button("Start Library System");
        Label outputLabel = new Label();
        VBox vbox = new VBox(10);

        Button button1 = new Button("Antah berantah");
        vbox.getChildren().addAll(textField, button, button1, outputLabel);

        button.setOnAction(event -> LibrarySystem.startLibrarySystem(stage));

        button1.setOnAction(event -> {
            String inputText = textField.getText();

            outputLabel.setText("Terimakasih" +inputText);
        });

        VBox root = new VBox(10, button, button1, outputLabel);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 320, 240);

        stage.setTitle("Library system");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

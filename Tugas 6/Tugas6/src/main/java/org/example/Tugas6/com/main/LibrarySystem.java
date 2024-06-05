package org.example.Tugas6.com.main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Tugas6.books.*;
import org.example.Tugas6.data.Admin;
import org.example.Tugas6.data.Student;
import org.example.Tugas6.data.User;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    // menyimpan semua object dalam satu array dengan teknik polymorphism
    //public static Book daftarBuku[] = new Book[100]; // array satu dimensi untuk menyimpan buku
    public static ArrayList <Book> daftarBuku = new ArrayList <>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static void startLibrarySystem(Stage stage) {
    daftarBuku.add(new StoryBook("SB32F", "Lima Sekawan", 17, "Story", "Enid Blyton"));
    daftarBuku.add(new HistoryBook("HB324", "Sapiens", 2, "History", "Arthur Beiser"));
    daftarBuku.add(new TextBook("TB323", "Pasutri", 4, "Text", "Eudora"));

    studentList.add(new Student("202310370311158", "Zaskia Nurismi Lingga", "Teknik","Informatika"));
    studentList.add(new Student("202310370311184", "Jasmine Najwati Qolbiy", "Teknik","Informatika"));
    studentList.add(new Student("202310370311200", "Lira Aurora Verina", "Teknik","Informatika"));

    VBox root = new VBox(10);
    Scene scene = new Scene(root, 400, 300);

    Label label = new Label("===== Library System =====");

    root.setAlignment(Pos.CENTER);
    Button studentLoginButton = new Button("Login as Student");
    studentLoginButton.setPrefHeight(80);
    studentLoginButton.setPrefWidth(200);

    Button adminLoginButton = new Button("Login as Admin");
    adminLoginButton.setPrefHeight(80);
    adminLoginButton.setPrefWidth(200);

    Button exitButton = new Button("Exit");
    exitButton.setPrefWidth(200);
    exitButton.setPrefHeight(80);

    studentLoginButton.setOnAction(event -> studentLogin(stage));
    adminLoginButton.setOnAction(event -> {
        try {
            new Admin().login(stage);
        } catch (Exception e) {
            showErrorDialog("Error", e.getMessage());
        }
    });
    exitButton.setOnAction(event -> stage.close());

    root.getChildren().addAll(label, studentLoginButton, adminLoginButton, exitButton);

    stage.setScene(scene);
    stage.setTitle("Library System");
    stage.show();
}

private static void studentLogin(Stage stage) {
    VBox root = new VBox(10);
    Scene scene = new Scene(root, 400, 300);

    Label label = new Label("Enter student NIM: ");
    TextField nimField = new TextField();
    Button loginButton = new Button("Login");
    Button backButton = new Button("Kembali");

    loginButton.setOnAction(event -> {
        String nimStudent = nimField.getText();
        if (nimStudent.length() == 15 && checkNim(nimStudent)) {
            Student student = new Student(nimStudent);
            student.login(stage);
        } else {
            showErrorDialog("Error", "Nim tidak terdaftar!");
        }
    });

    backButton.setOnAction(event -> startLibrarySystem(stage));

    root.getChildren().addAll(label, nimField, loginButton, backButton);

    stage.setScene(scene);
}

private static void showErrorDialog(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.showAndWait();
}

public static boolean checkNim(String nim) {
    for (Student student : studentList) {
        if (student.getNim().equals(nim)) {
            return true;
        }
    }
    return false;
}
}

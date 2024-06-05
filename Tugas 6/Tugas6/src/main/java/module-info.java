module org.example.Tugas6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.Tugas6 to javafx.fxml;
    exports org.example.Tugas6;
}

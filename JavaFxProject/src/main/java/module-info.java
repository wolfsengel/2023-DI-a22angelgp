module sanclemen.agp.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens sanclemen.agp.javafxproject to javafx.fxml;
    exports sanclemen.agp.javafxproject;
}
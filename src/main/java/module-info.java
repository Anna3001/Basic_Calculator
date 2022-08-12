module Basic.Calculator {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.base;

    exports sample to javafx.graphics, javafx.fxml;
    opens sample to javafx.fxml;
}
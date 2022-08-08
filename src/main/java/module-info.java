module Basic_Calculator {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports sample to javafx.graphics, javafx.fxml;
    opens sample to javafx.fxml;
}
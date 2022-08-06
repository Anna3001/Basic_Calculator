package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainViewInterface.fxml")))));
        stage.setResizable(false);
        stage.setTitle("Basic Calculator");
        stage.show();
    }

    public void run() {
        launch();
    }
}

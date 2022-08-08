package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(getClass().getResource("/MainViewInterface.fxml"));
        stage.setScene(new Scene(borderPane));
        stage.setResizable(false);
        stage.setTitle("Basic Calculator");
        stage.show();
    }

    public void run() {
        launch();
    }
}

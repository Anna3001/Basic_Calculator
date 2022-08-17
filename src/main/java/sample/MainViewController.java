package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ??
    }

    @FXML
    private Label expression;

    @FXML
    private Label result;

    public void insertNumber(String number) {
        expression.setText(expression.getText() + number);
    }

    public void insertOperator(String operator) {
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void clearExpression() {
        expression.setText("");
    }

    public Label getExpression() {
        return expression;
    }

    public void setResult(String newResult) {
        this.result.setText("= " + newResult);
    }

    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();

        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                insertOperator(buttonText);
                break;
            case "C":
                clearExpression();
                break;
            case "=":
                double result = Expression.evaluate(this.getExpression().getText());
                if(result == 10000000.0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "The result is too large!", ButtonType.OK);
                    alert.showAndWait();
                    clearExpression();
                    break;
                }
                if(result == 10000001.0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "This is not an expression!", ButtonType.OK);
                    alert.showAndWait();
                    clearExpression();
                    break;
                }
                if(result == 10000002.0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "One or more of the given numbers is/are too large! The maximum value is 10000.", ButtonType.OK);
                    alert.showAndWait();
                    clearExpression();
                    break;
                }
                setResult(String.valueOf(result));
                break;
        }
    }
}

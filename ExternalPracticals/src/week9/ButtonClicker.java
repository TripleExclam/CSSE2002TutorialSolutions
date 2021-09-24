package week9;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.naming.PartialResultException;

public class ButtonClicker extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(generateWidgets(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private BorderPane generateWidgets() {
        BorderPane border = new BorderPane();
        // Add your widgets here
        Button press = new Button("Press Me");
        Label text = new Label();
        StringProperty labelText = new SimpleStringProperty("Button has been " +
                "pressed 0 times");
        labelText.bindBidirectional(text.textProperty());

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(press);

        buttonBox.setAlignment(Pos.CENTER);

        border.setTop(buttonBox);
        border.setCenter(text);

        press.setOnAction(new EventHandler<>() {
            private int presses = 0;

            @Override
            public void handle(ActionEvent actionEvent) {
                presses++;
                labelText.setValue("Button has been " +
                        "pressed " + presses + " times");
            }
        });

        return border;
    }

    public static void main(String[] args) {
        launch();
    }
}

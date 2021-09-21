package week9;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Ex1 extends Application {
    private int counter = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(getMainLayout(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public Pane getMainLayout() {
        BorderPane pane = new BorderPane();
        Label textLabel = new Label("Button pressed 0 times");

        StringProperty sp = new SimpleStringProperty();
        sp.bindBidirectional(textLabel.textProperty());

        Button button = new Button("Press me!");
        pane.setTop(button);
        pane.setCenter(textLabel);
        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setMargin(button, new Insets(12,12,12,12));

        pane.setBottom(getBottomElements(sp));
        button.setOnAction(actionEvent -> {
            sp.setValue("Button pressed " + ++counter + " times");
        });
        return pane;
        // matthew.burton@uq.edu.au
    }

    public HBox getBottomElements(StringProperty sp) {
        HBox box = new HBox();
        Label text = new Label("Enter new text: ");
        TextField textField = new TextField("Enter some text");
        Button set = new Button("Set");
        Button cancel = new Button("Cancel");
        box.getChildren().addAll(text, textField, set, cancel);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10, 10, 10, 10));

        cancel.setOnAction(actionEvent -> {
            textField.setText("Cancelled");
        });

        set.setOnAction(actionEvent -> {
            sp.setValue(textField.getText());
        });

        return box;
    }



    public static void main(String[] args) {
        launch();
    }
}

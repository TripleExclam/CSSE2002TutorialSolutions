package week10;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * The View class for the Canvas Example.
 * <p>
 * This class creates the GUI view and has methods which can update the view.
 */
public class View {

    /** Root node of the scene graph, to which all the GUI elements are added. */
    private HBox rootBox;

    /** Canvas context, this context allows us to draw stuff on the canvas. */
    private GraphicsContext context;

    /**
     * Buttons to draw different shapes:
     * ["Rectangle", "Circle", "Triangle", "House", "Clear"]
     */
    private Button[] buttons;

    /**
     * Text field to enter the x and y coord, and previous pressed button/coords.
     */
    private TextField xInput, yInput, previous;

    /**
     * Create the initial view for the GUI.
     * <p>
     * When a view is created, start building the initial scene graph, 
     * by adding all the necessary components.
     */
    public View() {
        rootBox = new HBox();
        addComponents();
    }

    /**
     * Get the Scene of the GUI with the scene graph.
     * 
     * @return the current scene
     */
    public Scene getScene() {
        return new Scene(rootBox);
    }

    /**
     * Get the X coordinate entered in the corresponding X coordinate input
     * field.
     * 
     * @return the entered X coordinate from the text field
     */
    public String getXCoord() {
        return xInput.getText();
    }

    /**
     * Get the Y coordinate entered in the corresponding Y coordinate input
     * field.
     * 
     * @return the entered Y coordinate from the text field
     */
    public String getYCoord() {
        return yInput.getText();
    }

    /**
     * Set the previously drawn button and (x,y) coordinates on display.
     * 
     * @param button The previously pressed button.
     */
    public void setPrevious(String button) {
        previous.setText(button);
    }

    /**
     * Get the number of buttons in the GUI.
     * 
     * @return the number of buttons
     */
    public int numberOfButtons() {
        return buttons.length;
    }

    /**
     * Draws the shape with some colour at given x and y coordinates.
     * <p>
     * At the moment can only draw:
     * <ul><li> Rectangle
     * <li> Circle
     * <li> Triangle
     * <li> House
     * <li> Clear, which clears the canvas</ul>
     * 
     * @param shape The shape to draw.
     * @param x     The X coordinate of the shape.
     * @param y     The Y coordinate of the shape.
     */
    public void drawShape(String shape, int x, int y) {
        switch (shape) {
            case "Rectangle" :
                drawRectangle(x, y);
                break;
            case "Circle" :
                drawCircle(x, y);
                break;
            case "Triangle" :
                drawTriangle(x, y);
                break;
            case "House" :
                drawHouse(x, y);
                break;
            case "Clear" :
                clearCanvas();
                break;
        }
    }

    /**
     * Adds the given event handler to all the buttons.
     * 
     * @param handler The event handler to add to the buttons.
     */
    public void addButtonHandler(EventHandler<ActionEvent> handler) {
        /*
         * Adds a handler to the buttons, meaning when a button is pressed
         * this handler will be invoked.
         */
        for (Button b : buttons) {
            b.setOnAction(handler);
        }
    }

    /**
     * Draws a rectangle with BLANCHEDALMOND colour. :P
     * 
     * @param x The upper left X coordinate of the rectangle.
     * @param y The upper left Y coordinate of the rectangle.
     */
    private void drawRectangle(int x, int y) {
        /*
         * Draw a rectangle at the given x and y coords.
         * Use the GraphicsContext (context) to draw on the canvas.
         */
        context.setFill(Color.PINK);
        // width: 100, height: 200
        context.fillRect(x, y, 100, 120);
    }

    /**
     * Draws a circle with radius 50 and top left at (x,y) and TURQUOISE colour.
     * 
     * @param x The X coordinate of the upper left bound of the circle.
     * @param y The Y coordinate of the upper left bound of the circle.
     */
    private void drawCircle(int x, int y) {
        /*
         * Draw a circle at the given x and y coords.
         * Use the GraphicsContext (context) to draw on the canvas.
         */
        context.setFill(Color.MEDIUMPURPLE);
        context.fillOval(x, y, 100, 100); // radius: 100
    }

    /**
     * Draws a triangle at the given (x,y) coordinates and colour DARKORANGE.
     * <p>
     * Draws the triangle such that bottom left point is at (x,y) another is at
     * (x+50, y-50) and last at (x+100, y).
     * 
     * @param x The x coordinate to start drawing the triangle.
     * @param y The y coordinate to start drawing the triangle.
     */
    private void drawTriangle(int x, int y) {
        /*
         * Draw a triangle at the given x and y coords.
         * Use the GraphicsContext (context) to draw on the canvas.
         */
        context.setFill(Color.SEAGREEN);
        context.fillPolygon(new double[] {x, x + 50.0, x + 100.0},
                new double[] {y, y - 100.0, y}, 3);
    }

    /**
     * Draw the a house shape at the given x and y coords.
     * <p>
     * The House's bottom left edge will be the starting (x,y).<br>
     * x increase leftwards <br>
     * y increases downwards
     * 
     * @param x The x coordinate at which to start drawing the house.
     * @param y The y coordinate at which to start drawing the house.
     */
    private void drawHouse(int x, int y) {
        /*
         * Use multiple shapes and lines to draw something which looks like a
         * house.
         * 
         *           /\ 
         * (x,y) -> /__\ 
         *          |  | 
         *          |__|
         * 
         * Think about using existing methods from the View class.
         *
         * Use the GraphicsContext (context) to draw a house shape on the canvas.
         */
        drawTriangle(x, y);
        drawRectangle(x, y);
    }

    /**
     * Clear the whole canvas, removing all the shapes drawn on it.
     */
    private void clearCanvas() {
        /*
         * Remove all the shapes drawn on the canvas.
         * Use the GraphicsContext (context) to draw/clear the canvas.
         */
        context.clearRect(0, 0, 450, 300);
    }

    /**
     * Clear all the text fields.
     */
    public void clearFields() {
        /*
         * Clear all the TextFields so that users don't always have to clear
         * after entering a command.
         */
        xInput.clear();
        yInput.clear();
        previous.clear();
    }

    /**
     * Add all the GUI elements to the root layout.
     * <p>
     * This is where the scene graph is created.
     */
    private void addComponents() {
        VBox leftBox = new VBox();

        /* Add padding, colour to the left side. */
        leftBox.setPadding(new Insets(10, 10, 10, 10));
        leftBox.setStyle("-fx-background-color: white");

        /* Add all the leftside components to this leftBox. */
        addLeftSideComponents(leftBox);

        /* Another layout node for the left side of the GUI. */
        VBox rightBox = new VBox();

        /* Add colour and padding to the right layout. */
        rightBox.setSpacing(10);
        rightBox.setPadding(new Insets(20, 20, 20, 20));
        rightBox.setStyle("-fx-background-color: #336699");

        /* Add all the right side components to this rightBox. */
        addRightSideComponents(rightBox);

        /* Add both layouts to the root HBox layout. */
        rootBox.getChildren().addAll(leftBox, rightBox);
    }

    /**
     * Add all the GUI elements to the left container,
     * such as the canvas and the text fields
     * 
     * @param box The container to which the elements are added.
     */
    private void addLeftSideComponents(VBox box) {
        /*
         * This is where all the components which are on the left side such as
         * Canvas, TextFields and Labels will be added.
         */

        /*
         * Add the canvas inside a HBox, the HBox (canvasContainer) is used so
         * that border can be added around the canvas.
         */
        HBox canvasContainer = new HBox();
        Canvas canvas = new Canvas(450, 300);
        context = canvas.getGraphicsContext2D();
        canvasContainer.getChildren().add(canvas);
        canvasContainer.setStyle("-fx-border-color: black");

        /* Create another HBox and add textInputs and Labels inside it. */
        HBox inputBox = new HBox();
        inputBox.setPadding(new Insets(10, 10, 10, 10));
        inputBox.setSpacing(15);
        /* Make everything inside the HBox centre aligned. */
        inputBox.setAlignment(Pos.CENTER);

        /* Add labels and inputs to the HBox. */
        xInput = new TextField();
        yInput = new TextField();
        inputBox.getChildren().addAll(new Label("X-input"), xInput,
                new Label("Y-input"), yInput);

        /*
         * Add another textField to the VBox to display previous drawn command.
         * Assign the created TextField to the variable called "previous" 
         * (already created as intance variable), set the prompt as
         * "Previously entered command" and make sure the users are not able to
         * edit the field.
         */
        previous = new TextField();
        previous.setEditable(false);
        previous.setPromptText("Previously entered command");

        /*
         * Add everything to the left VBox (which is passed as argument), add
         * the canvasContaner, the box(inputBox) containing all the TextFields
         * and the TextField which records the previous command.
         */
        box.getChildren().addAll(canvasContainer, inputBox, previous);
    }

    /**
     * Add all the GUI elements to the right container.
     * 
     * @param box The container to which the elements are added.
     */
    private void addRightSideComponents(VBox box) {
        /* Add some text to indicate what the buttons are for. */
        Text drawText = new Text("Draw Commands");
        drawText.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        drawText.setFill(Color.WHITE);
        box.getChildren().add(drawText);

        /*
         * Add the following buttons to the VBox:
         * |Rectangle|
         * | Circle  | 
         * |Triangle |
         * |  House  |
         * |  Clear  |
         */
        buttons = new Button[5];
        buttons[0] = new Button("Rectangle");
        buttons[1] = new Button("Circle");
        buttons[2] = new Button("Triangle");
        buttons[3] = new Button("House");
        buttons[4] = new Button("Clear");

        // You can set a preferred size for all the button if you want.
        for (Button butt : buttons) {
            butt.setPrefSize(120, 20);
            box.getChildren().add(butt);
        }
    }
}

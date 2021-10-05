package week10;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Controller class for the GUI.
 * <p>
 * Used to control the View based on user input.
 */
public class Controller {
    
    /** View for the canvas application. */
    private View view;
    
    /**
     * Create a new Controller for the given view, adding EventHandlers to 
     * the view.
     *
     * @param view The view to be managed by this controller.
     */
    public Controller(View view) {
        this.view = view;
        view.addButtonHandler(new DrawHandler());
    }


    /**
     * EventHandler for the buttons, which records the pressed button and user 
     * inputs, and updates the view with the shape.
     * <p>
     * i.e. Draw the shape on the canvas, depending on which button was pressed.
     */
    private class DrawHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            /* Get the button which was just pressed. */
            Button pressedButton = (Button) event.getSource();
            
            /* The x and y coords which were entered. */
            int xCoord, yCoord;
            
            /*
             * Get the input from X-Coord and Y-Coord input TextField. 
             * Try to convert them to integers, if you can't then set them to (0,0).
             */
            try {
                xCoord = Integer.parseInt(view.getXCoord());
                yCoord = Integer.parseInt(view.getYCoord());
            } catch (NumberFormatException exp) {
                xCoord = 0;
                yCoord = 0;
            }
            
            /*
             * Draw the shape at the given x and y coordinate.
             * Use view to draw the shape, view has methods which can do this.
             */
            view.drawShape(pressedButton.getText(), xCoord, yCoord);

            /*
             * Once the information from the text fields is used, 
             * clear them so that new ones can be used for next drawing.
             * Use the view to do this, view has methods you can use.
             */
            view.clearFields();
            
            /*
             * Enter the information of the button which was just pressed.
             * Use the view to do this, view has methods you can use to achieve this.
             */
            view.setPrevious(pressedButton.getText());
        }
    }
}

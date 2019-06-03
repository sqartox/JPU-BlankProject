/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean michel crapaud
 * The class Main
 * Saved as file Main.java
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args the arguments
	 * @throws Exception exception
     */
	
    public static void main(final String[] args) throws Exception {
    	
		// Load the Game Model
        final Model model = new Model();
        
		// Load the Game View
        final View view = new View(model);
        
		// Set the controller
        final Controller controller = new Controller(view, model);
        view.setController(controller);
        
        // Set default Game controller properties
        controller.control();
        controller.orderPerform(ControllerOrder.Map1);
        controller.orderPerform(ControllerOrder.NOTHING);
        
        // Start Game
        controller.play();
    }
}
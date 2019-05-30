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
     * @param args            the arguments
     * @throws InterruptedException the interrupted exception
     */
	
    public static void main(final String[] args) throws InterruptedException {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);
        
        controller.control();
        controller.orderPerform(ControllerOrder.Map1);
        controller.orderPerform(ControllerOrder.NOTHING);
        controller.play();
    }
}
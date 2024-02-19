/**
 * This class represents the view, which handles the presentation of the information on the terminal for
 * the user to view. This class includes 3 methods: printMenu(), printString(), and toString(). The first method
 * displays the menu to the user. The second method prints whatever String is passed to it. Finally, the third
 * method displays the chicken's status; any relevant information including mood, life status, hearts, etc.
 *
 * @author Jasmine Montrichard
 * @version 1
 */

public class ChickenCraftView {
    // Prints the menu
    public void printMenu() {
        System.out.println("----------");
        System.out.println("1. Feed\n2. Play\n3. Hit\n4. Get Eggs\n5. Quit");
        System.out.print("Choice: ");
    }
    
    // Prints the passed String
    public void printString(String message) {
        System.out.println(message);
    }

    // Prints the chicken's status, any relevant information about it
    public String toString(ChickenModel chicken) {
        return String.format("Chicken %s\n1. Mood: %s\n2. Life Status: %s\n3. Health Hearts: %d\n4. Seed Mass: %.2f kg\n", chicken.getName(), chicken.getMood(), chicken.getLifeStatus(), chicken.getHealthHearts(), chicken.getMassSeeds());
    }
}

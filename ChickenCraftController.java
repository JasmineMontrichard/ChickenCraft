import java.util.Scanner;

/**
 * This class represents the controller, which controls the information flow between the view and the model.
 * This class includes the 4 commands the user can use to interact with the chickens: feedChicken(), play(), hitChicken(), getEggs() and includes a main method to instantiate the controller and pass 3 new instances of the Chicken Model class,
 * as well as a new instance of the ChickenCraftView class. Additionally, the main method gives a status report, displays the menu, gets user input, and uses a switch statement to execute the appropriate method that the user chose, and this is all
 * held in a do-while loop.
 *
 * @author Jasmine Montrichard
 * @version 1
 */

public class ChickenCraftController {
    private ChickenModel model1;
    private ChickenModel model2;
    private ChickenModel model3;
    private ChickenCraftView view;

    public ChickenCraftController(ChickenModel model1, ChickenModel model2, ChickenModel model3, ChickenCraftView view) {
        this.model1 = model1;
        this.model2 = model2;
        this.model3 = model3;
        this.view = view;
    }

    public void feedChicken(ChickenModel chicken, double amount) {
        // Add the provided amount to the chicken's seed mass
        chicken.setMassSeeds(chicken.getMassSeeds() + amount);

        // Increase health hearts by 1 if less than 4
        if (chicken.getHealthHearts() < 4) {
            chicken.setHealthHearts(chicken.getHealthHearts() + 1);
        }

        // Check if seed mass exceeds 2 and change life status if needed
        if (chicken.getMassSeeds() > 2) {
            chicken.setLifeStatus("dead"); // Set life status to false (dead)
        }

        // Print summary
        view.printString(String.format("Fed %s with %.2f kg of seeds.", chicken.getName(), amount, chicken.toString()));
        System.out.print("\n\n");
    }

    public void play(ChickenModel chicken1, ChickenModel chicken2) {
        if ((chicken1.getLifeStatus().equals("dead")) || (chicken2.getLifeStatus().equals("dead"))) {
            view.printString("Cannot play with dead chickens.");
            return;
        }

        // Set mood to happy for both chickens
        chicken1.setMood("happy");
        chicken2.setMood("happy");

        // Print summary
        view.printString("Chicken " + chicken1.getName() + " is playing with Chicken " + chicken2.getName() + ". They are both happy now.");
        System.out.print("\n\n");
    }

    public void hitChicken(ChickenModel chicken) {
        if (chicken.getLifeStatus().equals("dead")) {
            // Cannot hit a dead chicken
            view.printString("Cannot hit a dead chicken.");
            return;
        }

        // Decrease health hearts by 1 (if greater than 0)
        int currentHearts = chicken.getHealthHearts();
        if (currentHearts > 0) {
            chicken.setHealthHearts(currentHearts - 1);
        }

        // Check if the chicken is now dead
        if (chicken.getHealthHearts() == 0) {
            chicken.setLifeStatus("dead");
        }

        // Print summary
        view.printString("Chicken " + chicken.getName() + " has been hit. " +
                "Health: " + chicken.getHealthHearts() + " hearts. " +
                "Status: " + chicken.getLifeStatus());
        System.out.print("\n\n");
    }

    public void getEggs(ChickenModel chicken) {
        if (chicken.getLifeStatus().equals("dead")) {
            // Cannot get eggs from a dead chicken
            view.printString("Cannot get eggs from a dead chicken.");
            return;
        }

        // Calculate the number of eggs
        int numberOfEggs = (int) (chicken.getMassSeeds() / 0.25);

        // Calculate seed used
        double seedUsed = numberOfEggs * 0.25;

        // Set mass of seed remaining
        chicken.setMassSeeds(chicken.getMassSeeds() - seedUsed);

        // Double the number of eggs if the chicken is happy
        if (chicken.getMood().equals("Happy")) {
            numberOfEggs *= 2;
        }
        
        // Sets the chicken's mood to sad
        chicken.setMood("sad");

        // Print summary
        view.printString("You got " + numberOfEggs + " eggs from Chicken " + chicken.getName() +
                ". Seed used: " + seedUsed + " kg. Remaining seed: " + chicken.getMassSeeds() + " kg. " +
                "Mood: " + chicken.getMood());
        System.out.print("\n\n");
    }
    
    public void statusReport() {
        // Prints the statuses of all chickens
        view.printString("1. " + view.toString(model1));
        view.printString("2. " + view.toString(model2));
        view.printString("3. " + view.toString(model3));
    }

    public static void main(String[] args) {
        // Instantiates controller and passes 3 chicken models and 1 view as parameters
        ChickenCraftController controller = new ChickenCraftController(
                new ChickenModel("Syd"),
                new ChickenModel("Nancy"),
                new ChickenModel("Johnette"),
                new ChickenCraftView()
        );

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Displays status report
            controller.statusReport();

            // Displays menu and gets user input
            controller.view.printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Feeds a chicken
                    controller.feedChicken(controller.model1, 0.5);
                    break;
                case 2:
                    // Plays with chickens
                    controller.play(controller.model1, controller.model2);
                    break;
                case 3:
                    // Hits a chicken
                    controller.hitChicken(controller.model1);
                    break;
                case 4:
                    // Gets eggs from a chicken
                    controller.getEggs(controller.model1);
                    break;
                case 5:
                    // Quits the game
                    controller.view.printString("Goodbye!");
                    break;
                default:
                    controller.view.printString("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
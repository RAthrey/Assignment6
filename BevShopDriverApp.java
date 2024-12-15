/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a class to print out all info
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rohith Athrey
*/
import java.util.Scanner;

public class BevShopDriverApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();
        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());
        while (true) {
            System.out.println("#------------------------------------#");
            System.out.println("Would you please start a new order");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Would you please enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Please enter the time of the order (0-23): ");
            int time = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Please enter the day of the order (e.g., MONDAY): ");
            String dayStr = scanner.nextLine();
            DAY day = DAY.valueOf(dayStr.toUpperCase());
            bevShop.startNewOrder(time, day, name, age);
            double totalPrice = 0.0;
            boolean continueOrdering = true;
            while (continueOrdering) {
                System.out.println("Your Total Order for now is " + totalPrice);
                System.out.println("What would you like to add to your order?");
                System.out.println("1. Alcohol\n2. Coffee\n3. Smoothie\n4. Finish Order");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        if (age < bevShop.getMinAgeForAlcohol()) {
                            System.out.println("Your age is not appropriate for alcohol drinks!");
                        } else if (!bevShop.isEligibleForMore()) {
                            System.out.println("You have reached the maximum alcohol drinks for this order.");
                        } else {
                            System.out.print("Enter the name of the alcohol drink: ");
                            String alcoholName = scanner.nextLine();
                            System.out.print("Enter the size (SMALL, MEDIUM, LARGE): ");
                            SIZE size = SIZE.valueOf(scanner.nextLine().toUpperCase());
                            bevShop.processAlcoholOrder(alcoholName, size);
                            totalPrice = bevShop.getCurrentOrder().calcOrderTotal();
                            System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                        }
                        break;
                    case 2: 
                        System.out.print("Enter the name of the coffee: ");
                        String coffeeName = scanner.nextLine();
                        System.out.print("Enter the size (SMALL, MEDIUM, LARGE): ");
                        SIZE coffeeSize = SIZE.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("Do you want extra shot (true/false): ");
                        boolean extraShot = scanner.nextBoolean();
                        System.out.print("Do you want extra syrup (true/false): ");
                        boolean extraSyrup = scanner.nextBoolean();
                        bevShop.processCoffeeOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
                        totalPrice = bevShop.getCurrentOrder().calcOrderTotal();
                        break;
                    case 3: 
                        System.out.print("Enter the name of the smoothie: ");
                        String smoothieName = scanner.nextLine();
                        System.out.print("Enter the size (SMALL, MEDIUM, LARGE): ");
                        SIZE smoothieSize = SIZE.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("Enter the number of fruits: ");
                        int numOfFruits = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Do you want protein powder (true/false): ");
                        boolean addProtein = scanner.nextBoolean();
                        if (numOfFruits > bevShop.getMaxNumOfFruits()) {
                            System.out.println("You reached a maximum number of fruits");
                            numOfFruits = bevShop.getMaxNumOfFruits();
                        }
                        bevShop.processSmoothieOrder(smoothieName, smoothieSize, numOfFruits, addProtein);
                        totalPrice = bevShop.getCurrentOrder().calcOrderTotal();
                        break;
                    case 4: 
                        System.out.println("Finishing order. Your total price is: " + totalPrice);
                        bevShop.sortOrders(); 
                        continueOrdering = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            System.out.println("Do you want to start a new order? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("#------------------------------------#");
        System.out.println("Total amount for all orders: " + bevShop.totalMonthlySale());
        scanner.close();
    }
}

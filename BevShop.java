/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a interface for BevShop
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rohith Athrey
*/
import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;  
    private int numAlcoholDrinks;  
    private int currentOrder;

    public BevShop() {
        orders = new ArrayList<>();
    }

    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    public boolean isEligibleForMore() {
        return numAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    public int getNumOfAlcoholDrink() {
        return numAlcoholDrinks;
    }
    
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        Order order = new Order(time, day, customer);
        orders.add(order);
        numAlcoholDrinks = 0; 
        currentOrder = orders.indexOf(order);
    }

    public void processCoffeeOrder(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        orders.get(currentOrder).addNewBeverage(name, size, extraShot, extraSyrup);
    }

    public void processAlcoholOrder(String name, SIZE size) {
    	orders.get(currentOrder).addNewBeverage(name, size);
    	numAlcoholDrinks ++;
    }

    public void processSmoothieOrder(String name, SIZE size, int numOfFruits, boolean addProtein) {
    	orders.get(currentOrder).addNewBeverage(name, size, numOfFruits, addProtein);    }

    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

    public double totalMonthlySale() {
        double totalSale = 0;
        for (Order order : orders) {
            totalSale += order.calcOrderTotal();
        }
        return totalSale;
    }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    public Order getCurrentOrder() {
    	return orders.get(currentOrder);
    }

    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    public void sortOrders() {
        for (int i = 0; i < orders.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (getOrderAtIndex(j).getOrderNumber() < getOrderAtIndex(minIndex).getOrderNumber()) {
                	Collections.swap(orders, j, i);
                	minIndex = j;
                }
            }
        }
    }

    @Override
    public String toString() {
    	return orders + " " + totalMonthlySale();
    }
}

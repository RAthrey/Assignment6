/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a order class
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rohith Athrey
*/
import java.util.ArrayList;


public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private DAY orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, DAY orderDay, Customer customer) {
        this.orderNumber = generateRandomOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer);  
        this.beverages = new ArrayList<>();
    }

    private int generateRandomOrderNumber() {
        return (int) (Math.random() * (90000 - 10000)) + 10000;
    }

    @Override
    public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        Coffee coffee = new Coffee(name, size, extraShot, extraSyrup);
        beverages.add(coffee);
    }

    @Override
    public void addNewBeverage(String name, SIZE size) {
        Alcohol alcohol = new Alcohol(name, size);
        beverages.add(alcohol);
    }

    @Override
    public void addNewBeverage(String name, SIZE size, int numberOfFruits, boolean proteinAdded) {
        Smoothie smoothie = new Smoothie(name, size, numberOfFruits, proteinAdded);
        beverages.add(smoothie);
    }

    @Override
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        if (isWeekend() == true) {
			total += 0.6 * findNumOfBeveType(TYPE.ALCOHOL);
		}
		return total;	
    }

    @Override
    public int findNumOfBeveType(TYPE type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isWeekend() {
    	if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}
		return false;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo); 
        }
        return null;
    }

    @Override
    public String toString() {
    	return orderNumber + " " + orderTime + " " + customer.getName() + " " + customer.getAge() + " " + beverages + calcOrderTotal();
    }

    @Override
    public int compareTo(Order other) {
		if (this.orderNumber > other.orderNumber) {
			return 1;
		}
		if (this.orderNumber < other.orderNumber) {
			return -1;
		}
		return 0;
    }

    public Customer getCustomer() {
        return new Customer(this.customer); 
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public DAY getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(DAY orderDay) {
        this.orderDay = orderDay;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(ArrayList<Beverage> beverages) {
        this.beverages = beverages;
    }
    public int getTotalItems() {
		return beverages.size();
	}
}


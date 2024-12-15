/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a test for order class
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rohith Athrey
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

    private Order order;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", 25);
        order = new Order(10, DAY.SATURDAY, customer);
        order.addNewBeverage("Latte", SIZE.MEDIUM, true, false); 
        order.addNewBeverage("Pina Colada", SIZE.LARGE); 
        order.addNewBeverage("Berry Blast", SIZE.SMALL, 2, true); 
    }

    @Test
    void testAddNewBeverage() {
        assertEquals(3, order.getTotalItems());
        order.addNewBeverage("Mojito", SIZE.MEDIUM);
        assertEquals(4, order.getTotalItems());
    }

    @Test
    void testCalcOrderTotal() {
        double coffeePrice = 2.5 + 0.50;
        double alcoholPrice = 3.0; 
        double smoothiePrice = 2.0 + (2 * 0.50) + 1.50; 
        double weekendAlcoholFee = 0.6;
        double expectedTotal = coffeePrice + alcoholPrice + smoothiePrice + weekendAlcoholFee;
        assertEquals(expectedTotal, order.calcOrderTotal(), 0.01);
    }

    @Test
    void testFindNumOfBeveType() {
        assertEquals(1, order.findNumOfBeveType(TYPE.COFFEE));
        assertEquals(1, order.findNumOfBeveType(TYPE.ALCOHOL));
        assertEquals(1, order.findNumOfBeveType(TYPE.SMOOTHIE));
    }

    @Test
    void testIsWeekend() {
        assertTrue(order.isWeekend());
        Order weekdayOrder = new Order(15, DAY.MONDAY, customer);
        assertFalse(weekdayOrder.isWeekend());
    }

    @Test
    void testGetBeverage() {
        Beverage beverage = order.getBeverage(0);
        assertNotNull(beverage);
        assertEquals("Latte", beverage.getName());
    }

    @Test
    void testToString() {
        String orderString = order.toString();
        assertTrue(orderString.contains("John Doe"));
        assertTrue(orderString.contains("10"));
        assertTrue(orderString.contains("Latte"));
        assertTrue(orderString.contains("Pina Colada"));
        assertTrue(orderString.contains("Berry Blast"));
    }

    @Test
    void testCompareTo() {
        Order anotherOrder = new Order(12, DAY.SUNDAY, customer);
        anotherOrder.setOrderNumber(order.getOrderNumber() + 1);
        assertTrue(order.compareTo(anotherOrder) < 0);
        assertTrue(anotherOrder.compareTo(order) > 0);
        anotherOrder.setOrderNumber(order.getOrderNumber());
        assertEquals(0, order.compareTo(anotherOrder));
    }

    @Test
    void testGetCustomer() {
        Customer retrievedCustomer = order.getCustomer();
        assertEquals("John Doe", retrievedCustomer.getName());
        assertEquals(25, retrievedCustomer.getAge());
        retrievedCustomer.setName("Jane Smith");
        assertNotEquals("Jane Smith", order.getCustomer().getName());
    }
}

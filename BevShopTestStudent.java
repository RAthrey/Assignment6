/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a test class for BevShop
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

class BevShopTest {

    private BevShop bevShop;

    @BeforeEach
    void setUp() {
        bevShop = new BevShop();
    }

    @Test
    void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10));
        assertFalse(bevShop.isValidTime(25));
        assertFalse(bevShop.isValidTime(-1));
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(6));
        assertFalse(bevShop.isMaxFruit(3));
    }

    @Test
    void testIsEligibleForMore() {
        bevShop.startNewOrder(18, DAY.FRIDAY, "Joe", 25);
        assertTrue(bevShop.isEligibleForMore());
        for (int i = 0; i < bevShop.getMaxOrderForAlcohol(); i++) {
            bevShop.processAlcoholOrder("Wine", SIZE.SMALL);
        }
        assertFalse(bevShop.isEligibleForMore());
    }


    @Test
    void testStartNewOrder() {
        bevShop.startNewOrder(12, DAY.MONDAY, "Alice", 30);
        assertNotNull(bevShop.getCurrentOrder());
        assertEquals("Alice", bevShop.getCurrentOrder().getCustomer().getName());
        assertEquals(12, bevShop.getCurrentOrder().getOrderTime());
    }

    @Test
    void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, DAY.FRIDAY, "Bob", 25);
        bevShop.processCoffeeOrder("Espresso", SIZE.LARGE, true, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        Beverage coffee = bevShop.getCurrentOrder().getBeverage(0);
        assertEquals("Espresso", coffee.getName());
        assertEquals(TYPE.COFFEE, coffee.getType());
    }

    @Test
    void testProcessAlcoholOrder() {
        bevShop.startNewOrder(18, DAY.SATURDAY, "Charlie", 28);
        bevShop.processAlcoholOrder("Beer", SIZE.MEDIUM);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        Beverage alcohol = bevShop.getCurrentOrder().getBeverage(0);
        assertEquals("Beer", alcohol.getName());
        assertEquals(TYPE.ALCOHOL, alcohol.getType());
    }

    @Test
    void testProcessSmoothieOrder() {
        bevShop.startNewOrder(9, DAY.SUNDAY, "Diana", 22);
        bevShop.processSmoothieOrder("Green Smoothie", SIZE.SMALL, 4, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        Beverage smoothie = bevShop.getCurrentOrder().getBeverage(0);
        assertEquals("Green Smoothie", smoothie.getName());
        assertEquals(TYPE.SMOOTHIE, smoothie.getType());
    }

    @Test
    void testFindOrder() {
        bevShop.startNewOrder(10, DAY.MONDAY, "Eve", 35);
        bevShop.getCurrentOrder().setOrderNumber(1001);
        bevShop.startNewOrder(12, DAY.TUESDAY, "Frank", 40);
        bevShop.getCurrentOrder().setOrderNumber(1002);
        assertEquals(1, bevShop.findOrder(1002));
        assertEquals(-1, bevShop.findOrder(9999));
    }

    @Test
    void testTotalOrderPrice() {
        bevShop.startNewOrder(8, DAY.THURSDAY, "Grace", 45);
        bevShop.processCoffeeOrder("Cappuccino", SIZE.SMALL, false, false);
        bevShop.getCurrentOrder().setOrderNumber(2001);
        assertEquals(bevShop.getCurrentOrder().calcOrderTotal(), bevShop.totalOrderPrice(2001), 0.01);
    }

    @Test
    void testTotalMonthlySale() {
        bevShop.startNewOrder(10, DAY.WEDNESDAY, "Hank", 50);
        bevShop.processCoffeeOrder("Mocha", SIZE.MEDIUM, true, true);

        bevShop.startNewOrder(14, DAY.THURSDAY, "Ivy", 26);
        bevShop.processSmoothieOrder("Tropical", SIZE.LARGE, 3, true);

        double expectedTotal = bevShop.totalMonthlySale();
        assertTrue(expectedTotal > 0);
    }

    @Test
    void testSortOrders() {
    	bevShop.startNewOrder(6,DAY.MONDAY,"Hank", 26);
		bevShop.startNewOrder(9,DAY.TUESDAY,"John", 33);
		bevShop.startNewOrder(8,DAY.SATURDAY,"Ivy", 37);
		bevShop.sortOrders();
		assertTrue(bevShop.getOrderAtIndex(0).getOrderNumber()< bevShop.getOrderAtIndex(1).getOrderNumber());
		assertTrue(bevShop.getOrderAtIndex(1).getOrderNumber()< bevShop.getOrderAtIndex(2).getOrderNumber());
    }
} 

/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a test for coffee class
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

class CoffeeTest {

    private Coffee coffee1;
    private Coffee coffee2;

    @BeforeEach
    void setUp() {
        coffee1 = new Coffee("Latte", SIZE.MEDIUM, true, false);
        coffee2 = new Coffee("Cappuccino", SIZE.LARGE, false, true);
    }

    @Test
    void testCalcPrice() {
        double expectedPrice1 = 2.5 + 0.50; 
        assertEquals(expectedPrice1, coffee1.calcPrice(), 0.01);
        double expectedPrice2 = 3.0 + 0.50;
        assertEquals(expectedPrice2, coffee2.calcPrice(), 0.01);
    }

    @Test
    void testToString() {
    	assertTrue(coffee2.toString().contains(coffee2.getName()));
		assertTrue(coffee2.toString().contains(String.valueOf(coffee2.calcPrice()) ));
		assertTrue(coffee2.toString().contains(coffee2.getSize().toString() ));
    }

    @Test
    void testGettersAndSetters() {
        coffee1.setExtraShot(false);
        assertFalse(coffee1.getExtraShot());
        coffee2.setExtraSyrup(false);
        assertFalse(coffee2.getExtraSyrup());
    }

    @Test
    void testEquals() {
        Coffee coffee3 = new Coffee("Latte", SIZE.MEDIUM, true, false);
        assertTrue(coffee1.equals(coffee3));
        assertFalse(coffee1.equals(coffee2));
    }
}

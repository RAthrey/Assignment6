/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a test for alcohol class
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

class AlcoholTest {

    private Alcohol alcohol1;
    private Alcohol alcohol2;

    @BeforeEach
    void setUp() {
        alcohol1 = new Alcohol("Whiskey", SIZE.SMALL, true);
        alcohol2 = new Alcohol("Vodka", SIZE.LARGE, false);
    }

    @Test
    void testCalcPrice() {
        double expectedPrice1 = 2 + 0.60;
        assertEquals(expectedPrice1, alcohol1.calcPrice(), 0.01);
        double expectedPrice2 = 3.0;
        assertEquals(expectedPrice2, alcohol2.calcPrice(), 0.01);
    }

    @Test
    void testToString() {
    	assertTrue(alcohol1.toString().contains(alcohol1.getName()));
		assertTrue(alcohol1.toString().contains(String.valueOf(alcohol1.calcPrice()) ));
		assertTrue(alcohol1.toString().contains(alcohol1.getSize().toString() ));
    }

    @Test
    void testGettersAndSetters() {
        alcohol1.setOfferedOnWeekend(false);
        assertFalse(alcohol1.getOfferedOnWeekend());
        alcohol2.setOfferedOnWeekend(true);
        assertTrue(alcohol2.getOfferedOnWeekend());
    }

    @Test
    void testEquals() {
        Alcohol alcohol3 = new Alcohol("Whiskey", SIZE.SMALL, true);
        assertTrue(alcohol1.equals(alcohol3));
        assertFalse(alcohol1.equals(alcohol2));
    }
}

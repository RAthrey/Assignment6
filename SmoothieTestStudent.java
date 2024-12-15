/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a test for smoothie class
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

class SmoothieTest {

    private Smoothie smoothie1;
    private Smoothie smoothie2;

    @BeforeEach
    void setUp() {
        smoothie1 = new Smoothie("Berry Blast", SIZE.MEDIUM, 3, true);
        smoothie2 = new Smoothie("Tropical Twist", SIZE.LARGE, 2, false);
    }

    @Test
    void testCalcPrice() {
        double expectedPrice1 = 2.5 + (3 * 0.50) + 1.50;
        assertEquals(expectedPrice1, smoothie1.calcPrice(), 0.01);
        double expectedPrice2 = 3 + (2 * 0.50);
        assertEquals(expectedPrice2, smoothie2.calcPrice(), 0.01);
    }

    @Test
    void testToString() {
    	assertTrue(smoothie1.toString().contains(smoothie1.getName()));
		assertTrue(smoothie1.toString().contains(String.valueOf(smoothie1.calcPrice()) ));
		assertTrue(smoothie1.toString().contains(smoothie1.getSize().toString() ));
		assertTrue(smoothie1.toString().contains( String.valueOf(smoothie1.getNumberOfFruits()) ));
    }

    @Test
    void testGettersAndSetters() {
        smoothie1.setNumberOfFruits(4);
        assertEquals(4, smoothie1.getNumberOfFruits());
        smoothie2.setProteinAdded(true);
        assertTrue(smoothie2.getProteinAdded());
    }

    @Test
    void testEquals() {
        Smoothie smoothie3 = new Smoothie("Berry Blast", SIZE.MEDIUM, 3, true);
        assertTrue(smoothie1.equals(smoothie3));
        assertFalse(smoothie1.equals(smoothie2));
    }
}

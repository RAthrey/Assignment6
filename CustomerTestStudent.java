/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a test for customer class
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

class CustomerTest {

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {
        customer1 = new Customer("John Doe", 25);
        customer2 = new Customer("Jane Smith", 30);
    }

    @Test
    void testGettersAndSetters() {
        customer1.setName("Alice Johnson");
        assertEquals("Alice Johnson", customer1.getName());
        customer2.setAge(35);
        assertEquals(35, customer2.getAge());
    }

    @Test
    void testCopyConstructor() {
        Customer copy = new Customer(customer1);
        assertEquals(customer1.getName(), copy.getName());
        assertEquals(customer1.getAge(), copy.getAge());
    }

    @Test
    void testToString() {
        assertEquals("John Doe 25", customer1.toString());
        assertEquals("Jane Smith 30", customer2.toString());
    }
}

// Virginia Tech Honor Code Pledge:

//f
// As a Hokie, I will conduct myself with honor 
//and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;
package towerofhanoi;

import student.TestCase;

/**
 * @author Zachary Blocher (zblocher)
 * 
 * @version 3.16.22
 *
 */
public class DiskTest extends TestCase {

    private Disk test1;
    private Disk test2;
    private Disk test3;
    private Object test4;
    private Disk test5;

    /**
     * Create a method to set up the test disks
     */
    public void setUp() {
        test1 = new Disk(5);
        test2 = new Disk(10);
        test3 = new Disk(5);
        test4 = new Object();
        test5 = null;
    }


    /**
     * create a method to test the compareTo method
     */
    public void testCompareTo() {

        Exception thrown = null;
        try {
            test1.compareTo(test5);

        }
        catch (Exception e) {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalArgumentException);

        assertEquals(test1.compareTo(test2), -5);
        assertEquals(test2.compareTo(test3), 5);
        assertEquals(test1.compareTo(test3), 0);

    }


    /**
     * create a method to test toString
     */
    public void testToString() {
        assertEquals(test1.toString(), "5");
    }


    /**
     * create a method to test Equals
     */
    public void testEquals() {
        assertTrue(test1.equals(test1));
        assertTrue(test1.equals(test3));
        assertFalse(test1.equals(test2));
        assertFalse(test1.equals(test5));
        assertFalse(test1.equals(test4));
    }
}


// Virginia Tech Honor Code Pledge:

//f
// As a Hokie, I will conduct myself with honor 
//and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;/**
package towerofhanoi;

import student.TestCase;

/**
 * @author Zachary Blocher
 * 
 * @version 3.16.22
 *
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<String> test1;
    private LinkedStack<String> test2;

    /**
     * create a method to set up the tests
     */
    public void setUp() {
        test1 = new LinkedStack<>();
        test2 = new LinkedStack<>();

        test2.push("red");
        test2.push("blue");
        test2.push("green");
    }


    /**
     * create a method to test the push method
     */
    public void testPush() {
        assertTrue(test1.isEmpty());
        test1.push("red");
        test1.push("blue");
        test1.push("green");
        assertFalse(test1.isEmpty());
        assertEquals(test1.size(), 3);
        test1.clear();
    }


    /**
     * create a method to test the peek method
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            test1.peek();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        // assertTrue(thrown instanceOf EmptyStackException);
        test1.push("red");
        assertTrue(test1.peek().equals("red"));
        test1.clear();

    }


    /**
     * create a method to test the pop method
     */
    public void testPop() {
        Exception thrown = null;
        try {
            test1.pop();
        }
        catch (Exception e) {
            thrown = e;
        }
        test1.push("red");
        assertEquals(test1.pop(), "red");
    }


    /**
     * create a method to test clear
     */
    public void testClear() {
        assertFalse(test2.isEmpty());
        test2.clear();
        assertTrue(test2.isEmpty());
    }


    /**
     * create a method to testSize
     */
    public void testSize() {
        assertEquals(test1.size(), 0);
        test1.push("red");
        assertEquals(test1.size(), 1);
    }


    /**
     * create a method to test toString
     */
    public void testToString() {
        assertEquals(test2.toString(), "[green, blue, red]");
        test2.clear();
        assertEquals(test2.toString(), "[]");
    }
}

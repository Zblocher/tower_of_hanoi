// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;
package towerofhanoi;

import student.TestCase;

/**
 * 
 * @author Zachary Blocher
 *
 * @version 3.16.22
 */
public class TowerTest extends TestCase {
    private Tower tower1;
    private Tower tower2;
    private Tower tower3;
    private Tower tower4;

    /**
     * create the method to set up the tower
     */
    public void setUp() {
        tower1 = new Tower(Position.DEFAULT);
        tower2 = new Tower(Position.LEFT);
        tower3 = new Tower(Position.MIDDLE);
        tower4 = new Tower(Position.RIGHT);

    }


    /**
     * create the method to test the push method
     */
    public void testPush() {
        Disk test1 = new Disk(4);
        Disk test2 = new Disk(5);
        Disk test3 = new Disk(6);
        Disk testNull = null;

        assertTrue(tower1.isEmpty());
        Exception thrown = null;
        try {
            tower1.push(testNull);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);

        tower1.push(test3);
        assertEquals(tower1.size(), 1);
        tower1.push(test2);
        assertEquals(tower1.size(), 2);

        Exception thrown1 = null;
        try {
            tower1.push(test1);
        }
        catch (Exception e) {
            thrown1 = e;
        }
        // assertNotNull(thrown1);

    }


    /**
     * create the method to test the position
     */
    public void testPosition() {
        assertEquals(tower1.position(), Position.DEFAULT);
        assertEquals(tower2.position(), Position.LEFT);
        assertEquals(tower3.position(), Position.MIDDLE);
        assertEquals(tower4.position(), Position.RIGHT);
        
    }

}

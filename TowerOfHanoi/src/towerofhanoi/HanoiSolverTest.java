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
 * @author Zachary Blocher (zblocher)
 * 
 * @version 3.16.22
 *
 */
public class HanoiSolverTest extends TestCase {
    private HanoiSolver game1;
    private Disk test1;
    private Disk test2;
    private Disk test3;

    /**
     * create a method to set up the games for the test
     */
    public void setUp() {
        game1 = new HanoiSolver(3);
        test1 = new Disk(5);
        test2 = new Disk(6);
        test3 = new Disk(7);

    }


    /**
     * create a method to test toString
     */

    public void testToString() {
        game1.getTower(Position.LEFT).push(test1);
        game1.getTower(Position.MIDDLE).push(test2);
        game1.getTower(Position.RIGHT).push(test3);
        assertEquals(game1.toString(), "[5][6][7]");
    }


    /**
     * create a method to test the disks
     */

    public void testDisks() {
        assertEquals(game1.disks(), 3);
    }


    /**
     * create a method to test the solve method
     */
    public void testSolve() {
        game1.getTower(Position.LEFT).push(test3);
        game1.getTower(Position.LEFT).push(test2);
        game1.getTower(Position.LEFT).push(test1);
        game1.solve();
        assertEquals(game1.getTower(Position.RIGHT).size(), 3);
    }
}

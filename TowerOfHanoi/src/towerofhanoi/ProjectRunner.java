// Virginia Tech Honor Code Pledge:

//f
// As a Hokie, I will conduct myself with honor 
//and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;
/**
 * 
 */
package towerofhanoi;

/**
 * @author zachary Blocher (zblocher)
 * 
 * @version 3.16.22
 *
 */
public class ProjectRunner {

    /**
     * @param args
     *            sends through the parameter
     */
    public static void main(String[] args) {
        int disk = 6;
        if (args.length == 1) {
            disk = Integer.parseInt(args[0]);
        }
        new PuzzleWindow(new HanoiSolver(disk));

    }

}

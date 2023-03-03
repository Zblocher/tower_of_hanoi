// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;
package towerofhanoi;

/**

 * 
 */
import java.util.Observable;

/**
 * @author Zachary Blocher (zblocher)
 * @version 3.16.22
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * Create the constructor for the hanoiSolver
     * 
     * @param numDisk
     *            send in the number of disks
     */
    public HanoiSolver(int numDisk) {
        numDisks = numDisk;

        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);

    }


    /**
     * create the method to get the number of disks
     * 
     * @return
     *         return the numberofdisks
     */
    public int disks() {
        return numDisks;
    }


    /**
     * Create the method to assign the positions
     * 
     * @param pos
     *            send in the position of the disk
     * @return
     *         return which tower to use
     */
    public Tower getTower(Position pos) {
        if (pos == Position.LEFT) {
            return left;
        }
        else if (pos == Position.MIDDLE) {
            return middle;
        }
        else if (pos == Position.RIGHT) {
            return right;
        }
        return middle;
    }


    /**
     * Create the method that turns to a string
     * 
     * @return
     *         Return the string created
     */
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append(left.toString());
        string.append(middle.toString());
        string.append(right.toString());
        return string.toString();
    }


    /**
     * create a method to move the towers
     * 
     * @param source
     *            send in where the tower starts at
     * @param destination
     *            return in where the tower ends at
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());

    }


    /**
     * Create a method to solve the tower puzzle using recurssion
     * 
     * @param currentDisks
     *            send in the amount of disks
     * @param startPole
     *            send in which pole it starts on
     * @param tempPole
     *            send in which pole it can move to
     * @param endPole
     *            send in which pole it ends at
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Create a function to call the solvetowers function
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }
}

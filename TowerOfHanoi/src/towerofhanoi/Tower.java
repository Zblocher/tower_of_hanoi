
// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;/**
package towerofhanoi;

/**
 * @author Zachary Blocher (zblocher)
 * 
 * @version 3.16.22
 *
 */
public class Tower extends LinkedStack<Disk> {

    private Position position;

    /**
     * Create the generic constructor for tower
     * 
     * @param pos
     *            send the position of the tower
     */
    public Tower(Position pos) {
        super();
        position = pos;
    }


    /**
     * create a function to get the position
     * 
     * @return
     *         return the position
     */
    public Position position() {
        return position;
    }


    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty() || this.peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}

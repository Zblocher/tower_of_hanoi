
// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;
package towerofhanoi;

import cs2.Shape;
import java.awt.*;
import student.TestableRandom;

/**
 * 
 */

/**
 * @author Zach Blocher (zblocher)
 * 
 * @version 3.16.22
 *
 */
public class Disk extends Shape implements Comparable<Disk> {
    /**
     * Create the constructor for the disk
     * 
     * @param width
     *            enter in the width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom generator = new TestableRandom();
        int color1 = generator.nextInt(256);
        int color2 = generator.nextInt(256);
        int color3 = generator.nextInt(256);
        this.setBackgroundColor(new Color(color1, color2, color3));
    }


    @Override
    /**
     * create a method to compare two disks
     * 
     * @param o
     *            enter in the disk to compare
     */
    public int compareTo(Disk o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        return (this.getWidth() - o.getWidth());
    }


    /**
     * create the method that puts the disk to a string
     * 
     * @return
     *         return the string concatenated
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(getWidth());
        return string.toString();
    }


    /**
     * create the equals method to check if the disks are equals
     * 
     * @param obj
     *            send in the object to compare to
     * @return
     *         return if theyre equal or not
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == this.getClass()) {
            Disk temp = (Disk)obj;

            if (temp.getWidth() == this.getWidth()) {
                return true;
            }
        }
        return false;
    }

}

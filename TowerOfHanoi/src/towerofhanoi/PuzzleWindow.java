
// Virginia Tech Honor Code Pledge:

//f
// As a Hokie, I will conduct myself with honor 
//and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;/**
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * @author Zachary Blocher (zblocher)
 * 
 * @version 3.16.22
 *
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    private HanoiSolver game;

    static final int WIDTH_FACTOR = 30;
    static final int DISK_GAP = 0;
    static final int DISK_HEIGHT = 10;

    /**
     * Create the constructor for the puzzle window
     * 
     * @param g
     *            send in the game information
     */
    public PuzzleWindow(HanoiSolver g) {
        game = g;
        g.addObserver(this);
        window = new Window("Tower of Hanoi");

        left = new Shape((g.disks()) * WIDTH_FACTOR,100, 5, 200, Color.RED);
        middle = new Shape((g.disks()*3) * WIDTH_FACTOR, 100, 5, 200,  Color.BLUE);
        right = new Shape((g.disks()*5) * WIDTH_FACTOR, 100, 5, 200, Color.GREEN);

        for (int x = 0; x < game.disks(); x++) {
            g.getTower(Position.LEFT).push(new Disk(WIDTH_FACTOR *(g.disks() + 1 -x)));
            window.addShape(g.getTower(Position.LEFT).peek());
            moveDisk(Position.LEFT);

        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");

    }


    /**
     * create the method to move the disks in the game
     * 
     * @param pos
     *            send in the current position of the disk
     */
    public void moveDisk(Position pos) {
        Disk currentDisk = game.getTower(pos).peek();
        Shape currentPole;

        if (pos == Position.LEFT) {
            currentPole = left;
        }
        else if (pos == Position.MIDDLE) {
            currentPole = middle;
        }
        else if (pos == Position.RIGHT) {
            currentPole = right;
        }
        else {
            currentPole = middle;
        }

        int x = currentPole.getX();
        int y = currentPole.getY() + 200 - (game.getTower(pos).size()
            * (DISK_HEIGHT + DISK_GAP));
        currentDisk.moveTo(x - (currentDisk.getWidth() -5) / 2, y - DISK_GAP);
    }


    /**
     * create the method to update the window
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass().equals(Position.class)) {
            moveDisk((Position)arg);
            sleep();
        }
    }


    /**
     * create the sleep method
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * Create the method that happens once solved is clicked
     * 
     * @param button
     *            send in the button being clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            @Override
            public void run() {
                game.solve();
            }
        }.start();
    }

}

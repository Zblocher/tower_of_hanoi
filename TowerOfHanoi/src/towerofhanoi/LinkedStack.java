// Virginia Tech Honor Code Pledge:

// f
// As a Hokie, I will conduct myself with honor
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Your name (zblocher)package towerofhanoi;
package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

/**
 * @author Zach Blocher (zblocher)
 * 
 * @version 3.16.22
 *
 * @param <T>
 *            generic parmeter to send any data type in
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int size;

    /**
     * Create the generic constructor for the linked stack
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * Create the method to clear the stack
     */

    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }


    /**
     * Create the method to check if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Create the peek method which gets the first nodes data
     * 
     * @return
     *         return the data from the first node
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * Return and remove the data from the first node
     * 
     * @return
     *         return the data from the first node
     */
    @Override
    public T pop() {
        T top = peek();
        topNode = topNode.getNextNode();
        size--;
        return top;
    }


    /**
     * Push in a new entry into the stack
     * 
     * @param
     * send
     *            in the new entry to add to the stack
     */

    @Override
    public void push(T entry) {
        topNode = new Node<T>(entry, topNode);
        size++;
    }


    /**
     * create a method to return the size of the stack
     * 
     * @return
     *         return the size of the stack
     */
    public int size() {
        return size;
    }


    /**
     * create a method to turn into a string
     * 
     * @return
     *         return the string created
     */
    public String toString() {
        String temp = "[";
        Node<T> localNode = topNode;
        boolean first = true;
        while (localNode != null) {
            if (!first) {
                temp += ", ";
            }
            else {
                first = false;
            }
            temp += localNode.getData().toString();
            localNode = localNode.getNextNode();
        }
        temp += "]";
        return temp;
    }

    /**
     * Create a private node class
     * 
     * @author zachary Blocher (zblocher)
     *
     * @param <T>
     *            generic type to pass anything into node
     */
    private static class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * Create a generic constuctor for the node
         * 
         * @param data
         *            send in the data for the node
         */
        public Node(T data) {
            this(data, null);
        }


        /**
         * specific constuctor for node
         * 
         * @param entry
         *            send in the data for the node
         * @param node
         *            send in the pointer for the node
         */
        public Node(T entry, Node<T> node) {
            data = entry;
            next = node;
        }


        /**
         * Create a method to get the data from the node
         * 
         * @return data
         *         return the nodes data
         */
        public T getData() {
            return data;
        }


        /**
         * Create a method to set the pointer to the next node
         * 
         * @param node
         *            send in the node you want to point to
         */
        public void setNextNode(Node<T> node) {
            next = node;
        }


        /**
         * Create a method to get the next node
         * 
         * @return Node<T>
         *         return the node that is next in the stack
         */
        public Node<T> getNextNode() {
            return next;
        }
    }
}

package ihatejava;

import javax.swing.*;

public class aigen {

    public static void main(String[] args) {
        // Create a new JFrame object to hold the window
        JFrame frame = new JFrame("Hello World");
        // Set the default close operation to exit the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window in pixels
        frame.setSize(300, 200);
        // Create a new JLabel object to display the text "Hello World"
        JLabel label = new JLabel("Hello World", SwingConstants.CENTER);
        // Add the label to the content pane of the frame
        frame.getContentPane().add(label);
        // Make the window visible on the screen
        frame.setVisible(true);
    }
}
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ConvertorMainScreen extends JFrame implements MouseListener {

    private JLabel welcomeText;
    public JTextField numberInput;
    public JButton performConverting;
    //declaration of the GUI elements

    public ConvertorMainScreen() {
        super("Numbers convertor");
        setSize(1000, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        welcomeText = new JLabel("Hello. \n This is a simple program which converts numbers to words. The program " +
                "works within the following integer range - > [0;999].");
        add(welcomeText);
        welcomeText.setVisible(true);

        numberInput = new JTextField("Enter the number here");
        numberInput.setPreferredSize(new Dimension(200,24));
        add(numberInput);
        numberInput.setVisible(true);
        numberInput.addMouseListener(this);

        performConverting = new JButton("Convert");
        add(performConverting);
        performConverting.setVisible(true);
        //constructor which creates the window and adds all elements and sets their respective properties
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == numberInput) {
            numberInput.setText("");
        }
        //basic action listener method which clears the input text field everytime we click with the mouse on it
        //for more convenience
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getNumberInput() {
        return Integer.parseInt(numberInput.getText());
    }
    //a simple "Getter" method which obtains the integer value of the text field

    public void convertButtonListener(ActionListener listenForConvertButton) {
        performConverting.addActionListener(listenForConvertButton);
    }
    //this method accepts an action listener parameter and its implementation, in our case -> nested class

    public void displayErrorMessageOne() {
        JOptionPane.showMessageDialog(this,
                "You can only use numbers as input",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void displayErrorMessageTwo() {
        JOptionPane.showMessageDialog(this,
                "The input number is above the upper threshold of 999",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void displayErrorMessageThree() {
        JOptionPane.showMessageDialog(this,
                "The input integer is negative which is not accepted",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    //three different methods, which upon execution will be shown, with a respective error message

    public void displayOutputString(String outputString) {
        JOptionPane.showMessageDialog(this,
                "Generated result: " + outputString,
                "Result:",
                JOptionPane.INFORMATION_MESSAGE);
    }
    //method which upon execution will show the window with the resultant string
}

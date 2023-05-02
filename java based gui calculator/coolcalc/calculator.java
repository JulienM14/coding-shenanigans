package coolcalc;

import javax.swing.*;
import java.util.Scanner;
import java.util.function.LongToDoubleFunction;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;

import coolcalc.constants.*;
 

public class calculator {
    public static JFrame window;
    public static JButton additionButton, subtractionButton, multiplicationButton, divisionButton, storageButton, closeButton;
    public static JTextField number1, number2;
    public static JLabel answerField;
    public static boolean buttonsMade, drawWindowButtons;
    public static int[] actionHistory = new int[storageConstants.storageSize];
    public static double[] resultHistory = new double[storageConstants.storageSize];
    public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd HHmm");
    public static LocalDateTime launchTime;
    public static File logFile;
    public static String logFileLocation;
    public static FileWriter logFileWriter;
    public static double answer;
    // coolcalc\logfiles
    public static void main(String[] args) {
        launchTime = LocalDateTime.now();
        logFileLocation = "coolcalc/" + "logfiles/" + dateFormat.format(launchTime) + ".txt";
        System.out.println("coolcalc/" + "logfiles/" + dateFormat.format(launchTime) + ".txt");
        logFile = new File(logFileLocation);
        try {
            logFileWriter = new FileWriter(logFileLocation);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        windowMaker();
    }

    public static void windowMaker() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        window = new JFrame("Calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(windowConstants.windowWidth, windowConstants.windowHeight);
        buttonMaker();
        window.setLayout(new GridLayout(4,3));
        window.setVisible(true);
    }

    public static void mathcompleter(double x, double y, int function) {
        switch (function) {
            case 1: answer = x + y; break;
            case 2: answer = x - y; break;
            case 3: answer = x * y; break;
            case 4: answer = x / y; break;
            default: answer = 0; break;
        }
    }

    public static void functionPasser(int function) {
        double x, y;
        x = Double.parseDouble(number1.getText());
        y = Double.parseDouble(number2.getText());
        mathcompleter(x, y, function);
        System.out.println(x);
        System.out.println(y);
        System.out.println(answer);
        for (int i = 0; i < storageConstants.storageSize; i++) {
            if (resultHistory[i] == 0) {
                resultHistory[i] = answer;
                break;
            }
            else {
                continue;
            }
        }
        answerField.setText(String.valueOf(answer));
        }
    
    public static void closeApp() {
        int additionActions = 0;
        int subtractionActions = 0;
        int multiplicationActions = 0;
        int divisionActions = 0;
        if (logFile.exists() == false) {
            try {
                logFile.createNewFile();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < storageConstants.storageSize; i++) {
            switch (actionHistory[i]) {
                case 1: additionActions++; break;
                case 2: subtractionActions++; break;
                case 3: multiplicationActions++; break;
                case 4: divisionActions++; break;
                default: break;
            }
        }   
        try {
            logFileWriter.write("You did " + additionActions +" Addition Actions \n");
            logFileWriter.write("You did " + subtractionActions +" Subtraction Actions \n");
            logFileWriter.write("You did " + multiplicationActions +" Multiplications Actions \n");
            logFileWriter.write("You did " + divisionActions +" Division Actions \n");
            logFileWriter.write("Results Below VV \n");
            for (int i = 0; i < storageConstants.storageSize; i++) {
                if (resultHistory[i] != 0) {
                    logFileWriter.write("Result " + (i + 1) +" : " + String.valueOf(resultHistory[i]) + "\n");
                }
            }
            logFileWriter.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }   

    public static void buttonPressed(int button) {
        switch (button) {
            case 1: System.out.println("You pressed addition"); functionPasser(1); break;
            case 2: System.out.println("You pressed subtraction"); functionPasser(2); break;
            case 3: System.out.println("You pressed multiplication"); functionPasser(3); break;
            case 4: System.out.println("You pressed division"); functionPasser(4); break;
            case 5: System.out.println("You pressed storage button"); System.out.println(Arrays.toString(actionHistory)); break;
            case 6: System.out.println("You pressed the Exit Button"); closeApp(); break;
            default: System.out.println("Something broke!"); break;
        }
        for (int i = 0; i < storageConstants.storageSize; i++) {
            if (actionHistory[i] == 0) {
                actionHistory[i] = button;
                break;
            }
            else {
                continue;
            }
        }

    }

    public static void buttonMaker() {
        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("x");
        divisionButton = new JButton("/");
        storageButton = new JButton("Stored Data");
        closeButton = new JButton("Exit");
        number1 = new JTextField("num1");
        number2 = new JTextField("num2");
        answerField = new JLabel("Answer");
        additionButton.setSize(buttonConstants.buttonWidth,buttonConstants.buttonHeight);
        subtractionButton.setSize(buttonConstants.buttonWidth,buttonConstants.buttonHeight);
        multiplicationButton.setSize(buttonConstants.buttonWidth,buttonConstants.buttonHeight);
        divisionButton.setSize(buttonConstants.buttonWidth, buttonConstants.buttonHeight);
        storageButton.setSize(buttonConstants.buttonWidth, buttonConstants.buttonHeight);
        closeButton.setSize(buttonConstants.buttonWidth, buttonConstants.buttonHeight);
        number1.setHorizontalAlignment(JTextField.CENTER);
        number2.setHorizontalAlignment(JTextField.CENTER);
        answerField.setHorizontalAlignment(JTextField.CENTER);
        buttonsMade = true;
        if (buttonsMade) {
            System.out.println("Buttons successfully made");
            drawWindowButtons = true;
        } 
        else {
            System.out.println("Buttons not made : (");
            drawWindowButtons = false;
        }
        if (drawWindowButtons) {
            System.out.println("Drawing buttons on Window...");
            window.add(number1);
            window.add(answerField);
            window.add(number2);
            window.add(additionButton);
            window.add(subtractionButton);
            window.add(multiplicationButton);
            window.add(divisionButton);
            window.add(storageButton);
            window.add(closeButton);
            System.out.println("Buttons drawn!");
        } 
        else {
            System.out.println("Buttons not made, drawing error message");
            JLabel errorMessage = new JLabel("Button Error : (", SwingConstants.CENTER);
            window.getContentPane().add(errorMessage);
        }
        additionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPressed(1);
            }
        });
        subtractionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPressed(2);
            }
        });
        multiplicationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPressed(3);
            }
        });
        divisionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPressed(4);
            }
        });
        storageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPressed(5);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPressed(6);
            }
        });
    }
}

final class constants {
    public static final class windowConstants {
        public static int windowWidth = 480;
        public static int windowHeight = 640;
    }

    public static final class buttonConstants {
        public static int buttonWidth = 100;
        public static int buttonHeight = 100;
    }

    public static final class storageConstants {
        public static int storageSize = 10*100;
    }
}

    // LEGACY STUFF FOR TEXT BASED CALC BELOW
    // PLS IGNORE

    // public static double numbergrabber() {
    //     Scanner userInput = new Scanner(System.in);
    //     System.out.println("Please input a number \n");
    //     double number = userInput.nextdouble();
    //     userInput.close();
    //     return number;  
    // }

    // public static int functiongrabber() {
    //     Scanner userInput = new Scanner(System.in);
    //     System.out.println("Please input a function \n");
    //     System.out.println("Addition (1), Subtraction (2) \n");
    //     System.out.println("Multiplication (3), Division(4) \n");
    //     int function = userInput.nextInt();
    //     userInput.close();
    //     return function;
    // }


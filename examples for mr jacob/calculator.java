package ihatejava;
import java.util.Scanner;

class calculator {
    public static void main(String[] args) 
    {
        double x = numbergrabber();
        double y = numbergrabber();
        int function = functiongrabber();
        double answer = mathcompleter(x, y, function);
        System.out.println("Your answer is " + answer);
    }
    
    public static double numbergrabber()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please input a number \n");
        double number = userInput.nextDouble();
        return number;
    }
    
    public static int functiongrabber()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please input a function \n");
        System.out.println("Addition (1), Subtraction (2) \n");
        System.out.println("Multiplication (3), Division(4) \n");
        int function = userInput.nextInt();
        return function;
    }
    public static double mathcompleter(double x, double y, int function)
    {
        double answer = 0;
        if (function == 1) 
        {
            answer = x + y;
        }
        else if (function == 2)
        {
            answer = x - y;
        }
        else if (function == 3)
        {
            answer = x * y;
        }
        else if (function == 4) 
        {
            answer = x / y;
        }
        else 
        {
            answer = 0;
        }
        return answer;
    }

}
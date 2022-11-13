#include <stdio.h>

double numbergrabber() 
{
    double number;
    printf("Please input a number \n");
    scanf("%lf", &number);
    return number;
}

int functiongrabber()
{
    int function;
    printf("Please input a function \n");
    printf("Addition (1), Subtraction (2) \n");
    printf("Multiplication (3), Division (4) \n");
    scanf("%d", &function);
    return function;
}

double mathcompleter(double x, double y, int function) 
{
    double answer;
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

int main() 
{
    double x = numbergrabber();
    double y = numbergrabber();
    int function = functiongrabber();
    double answer = mathcompleter(x, y, function);
    printf("Your answer is %lf", answer);
    printf("\n");
}
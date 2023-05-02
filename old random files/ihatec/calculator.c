#include <stdio.h>

double numbergrabber()
{
    printf("\e[1;1H\e[2J");
    double number;
    printf("Please input a number \n");
    scanf("%lf", &number);
    return number;
    // comments work the smae : )
}

int functiongrabber()
{
    printf("\e[1;1H\e[2J");
    int function;
    printf("Please input a function \n");
    printf("Addition (1), Subtraction (2) \n");
    printf("Multiplication (3), Division (4) \n");
    scanf("%d", & function);
    return function;
}

double mathcompleter(double x, double y, int function)
{
    printf("\e[1;1H\e[2J");
    double answer;
    switch (function) {
        case 1: answer = x + y; break;
        case 2: answer = x - y; break;
        case 3: answer = x * y; break;
        case 4: answer = x / y; break;
        default: answer = 0; break;
    }
    return answer;
}

int main()
{
    printf("\e[1;1H\e[2J");
    double x = numbergrabber();
    double y = numbergrabber();
    int function = functiongrabber();
    double answer = mathcompleter(x, y, function);
    printf("Your answer is %lf", answer);
    printf("\n");
}
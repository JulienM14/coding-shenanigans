#include <iostream>
using namespace std;

double numbergrabber() 
{
    double number;
    cout << "Input a number! \n";
    cin >> number;
    return number;
}

int functiongrabber() 
{
    int function;
    cout << "Input a function! \n";
    cout << "Addition (1), Subtraction (2) \n";
    cout << "Mulitplication (3), Division (4) \n";
    cin >> function;
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
    return answer;
}

int main() 
{
    double x = numbergrabber();
    double y = numbergrabber();
    int function = functiongrabber();
    double answer = mathcompleter(x, y, function);
    cout << "Your answer is " << answer << "\n";
}
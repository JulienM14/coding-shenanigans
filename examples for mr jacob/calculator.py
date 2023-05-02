def numbergrabber():
    print("Input a number! \n")
    number = int(input(" > "))
    return number


def functiongrabber():
    print("Input a function! \n")
    print("Addition (1), Subtraction (2) \n")
    print("Mulitplication (3), Division (4) \n")
    function = int(input(" > "))
    return function


def mathcompleter(x, y, function):
    if function == 1:
        answer = x + y
    elif function == 2:
        answer = x - y
    elif function == 3:
        answer = x * y
    elif function == 4:
        answer = x / y
    else:
        answer = 0
    return answer


x = numbergrabber()
y = numbergrabber()
function = functiongrabber()
answer = mathcompleter(x, y, function)
print("Your answer is", answer)

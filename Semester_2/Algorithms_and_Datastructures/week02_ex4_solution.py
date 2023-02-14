def pow(a, b):
    if (b < 1):
        return 1
    return a * pow(a, b - 1)


def fib1(n):
    # Basic solution
    if (n < 1):
        return 0
    if (n == 1):
        return 1
    return fib1(n - 1) + fib1(n - 2)


def fib2(n):
    # Solution with runtime complexity O(n)
    return fib2_helper(0, 1, n)


def fib2_helper(a, b, n):
    if (n == 0):
        return a
    return fib2_helper(b, a + b, n - 1)


def isPalindrome(word):
    if len(word) < 2:
        return True
    if word[0] != word[-1]:
        return False
    return isPalindrome(word[1:len(word)-1])

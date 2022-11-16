# Contents of this project

This project contains an assignment from the course "Algorithms and Datastructures".

The "missing" exercises do not contain code, and are therefore omitted.

The describtion of each exercise can be found below:

## Exercise 1

Write a recursive algorithm/method, which takes a positive integer as parameter and returns the sum of the odd numbers squares from 1 to N.

Example: called with the parameter 8, the method returns 84 (1^2 +3^2 + 5^2 + 7^2).

It is important to optimize the algorithm so that unnecessary recursive calls are avoided.


## Exercise 3

Write a recursive method/algorithm with the following signature:

                    bool additive(String s)

The parameter contains a string of numbers, e.g. "82842605".

The algorithm returns true if the string contains a substring of three consecutive numbers where the third character is the sum of the two previous characters.

In the example above the method returns true, because index 5(6) is the sum of indices 3 and 4(4 plus 2).

Hint: the ASCII value of the character "7" is 55.


## Exercise 4

Write an algorithm that takes an array of unsorted, unique natural numbers as input and finds the three numbers in the array whose sum is closest to a power of 2. The same number can only be used once.

The return value of your algorithm must be an integer array that contains first the three values and then the corresponding power of two (e.g. 512).

Called with the array {23,56,22,11,65,89,3,44,87,910,45,35,98}, the three numbers returned are 89, 3, 35 and the power of 2 is 128.

What is the Big-Oh time complexity of your algorithm? Explain your answer and discuss the possibilities of optimizing your solution.


## Exercise 6

Write a recursive method/algorithm with the following signature:

                    int sumDivisibleBy3(int N)

The algorithm returns the sum of integers greater than 0 and smaller than or equal to N that are divisible by 3.

Called with N = 12 the correct return value is 30 (3+6+9+12). Called with N = 14 the correct return value is also 30.

You should optimize your method/algorithm to avoid unnecessary recursive calls.


## Exercise 7

6561 is an example of a natural number that can be written as XY where X and Y are integers, i.e. 9^4. Another example is 3125 (5^5).

Write an algorithm that can decide if a given natural number Z < 100,000 (the parameter of the algorithm) can be written as Z=X^Y where X and Y are integers with X > 2 and Y > 2.

The return value of the algorithm must be designed so that the following information can be deducted from it:

* [The value of X (in case of 6561 we have X=9).]
* [The value of Y (in case of 6561 we have Y=4).]
* [For the given Z, there can be several solution pairs (X,Y). In case of 3125 there is only one solution pair; in case of 6561, X=3 and Y=8 is also an option. If there is more than one solution, the one with the largest X value must be returned.]
* [If the given Z has no solution pair (X,Y) or Z contains an illegal value, some sort of dummy/default value must be returned.]

Your algorithm must be optimized assuming that the maximum value for Z and the minimum values for X and Y will never change.


## Exercise 10

Write a recursive method with the following signature:

                    int logTo(int N)

The algorithm returns the base 2 logarithm of N, and it is a precondition that N is a positive number and a power of 2.

Called with N = 32 it returns 5, and with N = 4096 returns 12.


## Exercise 11

The array below represents the votes cast at an election.

                {7,4,3,5,3,1,6,4,5,1,7,5}

In the example there are t candidates (1-7), and 12 votes have been cast. Candidate 6 got 1 vote, candidates 1, 3, 4 and 7 each got 2 votes, candidate 5 got 3 votes, and candidate 2 got 0 votes.

The task is to write an algorithm, which called with the array (and possibly the length of the array) can decide if any candidate got more than 50 % of the votes. In that case the number of the candidate is returned. If no candidate got more than 50 % of the vote -1 is returned.

In the example none of the candidates obtained a majority, and -1 is returned.

What is the time complexity of your algorithm?
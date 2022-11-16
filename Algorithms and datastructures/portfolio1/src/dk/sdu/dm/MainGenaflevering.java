package dk.sdu.dm;


import com.sun.source.tree.ReturnTree;

import java.util.*;

public class MainGenaflevering {

    //Exercise 1 - optimised
    private static int exercise1(int N) {

        //base case
        if (N <= 0) return 0;

        if (N % 2 == 0)
            return exercise1(N - 1);


        return N * N + exercise1(N - 2);

    }

    //Exercise 3
    static boolean additive(String s) {

        //base case
        if (s.length() < 3)
            return false;

        // start index to end index (not including end index)
        int firstIndex = Integer.parseInt(s.substring(0, 1));
        int secondIndex = Integer.parseInt(s.substring(1, 2));
        int thirdIndex = Integer.parseInt(s.substring(2, 3));

        if (firstIndex + secondIndex != thirdIndex)
            return additive(s.substring(1));

        return true;
    }


    //Exercise 4
    static HashMap<String, Object> exercise4(int[] inputArray) {

        int[] combination = new int[3];
        List<int[]> combinations = new ArrayList<>();

        exercise4Combinations(combination, combinations, inputArray, 0, inputArray.length - 1, 0);

        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < combinations.size(); i++) {
            int[] currentCombination = combinations.get(i);
            int sum = 0;
            for (int j = 0; j < currentCombination.length; j++) {
                int currentValue = currentCombination[j];
                sum += currentValue;
            }
            sums.add(sum);
        }

        int powerOfTwoOffset = 0;
        int powerOfTwoOffsetIndex = 0;
        int closestPowerOfTwo = 0;

        for (int i = 0; i < sums.size(); i++) {
            int currentSum = sums.get(i);
            int closestLogTwo = (int) Math.round(Math.log(currentSum) / Math.log(2));
            int currentPowerOfTwo = (int) Math.pow(2, closestLogTwo);
            int currentOffset = Math.abs(currentSum - currentPowerOfTwo);

            if (i == 0) {
                powerOfTwoOffset = currentOffset;
                closestPowerOfTwo = currentPowerOfTwo;
            } else if (currentOffset < powerOfTwoOffset) {
                powerOfTwoOffset = currentOffset;
                powerOfTwoOffsetIndex = i;
            }
        }

        int[] closestCombination = combinations.get(powerOfTwoOffsetIndex);
        HashMap<String, Object> result = new HashMap<>();
        result.put("Combination", closestCombination);
        result.put("PowerOfTwoValue", closestPowerOfTwo);

        return result;
    }

    // exercise4 combinations
    // Solution derived from : https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
    static void exercise4Combinations(int[] combination, List<int[]> combinations, int[] inputArray, int start, int end, int currentIndex) {

        if (currentIndex == combination.length) {
            int[] tempArray = combination.clone();
            combinations.add(tempArray);
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= combination.length - currentIndex; i++) {
            combination[currentIndex] = inputArray[i];
            exercise4Combinations(combination, combinations, inputArray, i + 1, end, currentIndex + 1);
        }
    }

    //Exercise 6
    static int sumDivisibleBy3(int N) {

        //Base case
        if (N <= 2)
            return N;

        //checks if N is not divisible by 3. Returns the recursive method minus the surplus
        if (N % 3 != 0)
            return sumDivisibleBy3(N - N % 3);

        /*
        if N is divisible by 3, we add N and call the
        method for the next recurrence of the number divisible by 3
         */
        return N + sumDivisibleBy3(N - 3);

    }

    //Exercise 7
    static int[] exercise7(int z) {

        int x = 0;
        int y = 0;

        //base case
        /*Checks
        if z is bigger or equal to 100.000
        if y = 2 (squared)
        if z is power of two
        if z = 1
         */

        if (z >= 100000 ||
                Math.floor(Math.log(z) / Math.log(2)) == Math.ceil(Math.log(z) / Math.log(2)) ||
                z == 1)
            return new int[]{x, y};

        //
        double i = 3.0;

        while (x == 0) {
            if (Math.pow(z, 1.0 / i) < 3) {
                break;
            } else if (Math.abs(Math.round(Math.pow(z, 1.0 / i)) - Math.pow(z, 1.0 / i)) < 0.00001) {
                x = (int) Math.round(Math.pow(z, 1.0 / i));
                y = (int) i;
            }

            i++;
        }

        return new int[]{x, y};
    }


    //Exercise 10
    // power of two method found here: https://www.geeksforgeeks.org/java-program-to-find-whether-a-no-is-power-of-two/
    static int logTo(int N) {

        //base case
        if (N < 2)
            return 0;

        // returns base 2 logarithm of N (which power of 2 is needed). +1 is needed as a counter.
        return logTo(N/2) + 1;

    }

    //Exercise 11
    static int exercise11(int[] array) {

        //Sorting the array
        Arrays.sort(array);

        int occurrences = 0;
        int arrayLength = array.length;
        int benchmark = arrayLength / 2;
        int candidate = 0;


        for (int i = 0; i < arrayLength; i++) {
            int currentCandidate = array[i];
            System.out.println(currentCandidate);
            if (candidate != currentCandidate) {
                candidate = currentCandidate;
                occurrences = 1;
            } else
                occurrences++;

            if (occurrences > benchmark)
                return candidate;

        }

        return -1;
    }


    public static void main(String[] args) {


        System.out.println("------------------------- Exercise 1 -------------------------\n");
        System.out.println("---- Test 1 ----");
        int some_input1 = 4;//Fill in your input

        System.out.println("Input is:\n" + some_input1); //Print the input
        int some_result1 = exercise1(some_input1);
        System.out.println("Result is:\n" + some_result1); //Print the result

        System.out.println("---- Test 2 ----");
        int some_input12 = 8;
        System.out.println("Input is:\n" + some_input12); //Print the input
        int some_result12 = exercise1(some_input12);
        System.out.println("Result is:  \n" + some_result12); //Print the result

        System.out.println("------------------------- Exercise 3 -------------------------\n");

        System.out.println("---- Test 1 ----");
        String some_input2 = "12256";
        System.out.println("Input is:\n" + some_input2); //Print the input
        boolean some_result2 = additive(some_input2);
        System.out.println("Result is:\n" + some_result2); //Print the result

        System.out.println("---- Test 2 ----\n");
        String some_input3 = "82842605";
        System.out.println("Input is:\n" + some_input3); //Print the input
        boolean some_result3 = additive(some_input3);
        System.out.println("Result is:\n" + some_result3); //Print the result

        System.out.println("------------------------- Exercise 4 -------------------------\n\n");
        System.out.println("---- Test 1 ----\n");
        int[] some_input4 = new int[]{23,56,22,11,65,89,3,44,87,910,45,35,98}; //Fill in your input

        System.out.println("Input is:\n" + Arrays.toString(some_input4)); //Print the input

        HashMap<String, Object> some_result4 = exercise4(some_input4);
        int[] exercise4Combination = (int[]) some_result4.get("Combination");
        int exercise4PowerOfTwoValue = (int) some_result4.get("PowerOfTwoValue");

        System.out.println("Result is:  \n" + "Combination: " + Arrays.toString(exercise4Combination) + " Closest to Power of two: " + exercise4PowerOfTwoValue); //Print the result


        System.out.println("------------------------- Exercise 6 -------------------------\n\n");
        System.out.println("---- Test 1 ----\n");
        int some_input6 = 10;//Fill in your input

        System.out.println("Input is:\n\n" + some_input6); //Print the input
        int some_result6 = sumDivisibleBy3(some_input6);
        System.out.println("Result is:  \n" + some_result6); //Print the result


        System.out.println("------------------------- Exercise 7 -------------------------\n\n");
        System.out.println("---- Test 1 ----\n");
        int some_input7 = 26;//Fill in your input

        System.out.println("Input is:\n" + some_input7); //Print the input
        int[] some_result7 = exercise7(some_input7);
        System.out.println("Result is:  \n" + Arrays.toString(some_result7)); //Print the result


        System.out.println("------------------------- Exercise 10 -------------------------\n\n");
        System.out.println("---- Test 1 ----\n");
        int some_input10 = 32;//Fill in your input

        System.out.println("Input is:\n" + some_input10); //Print the input
        int some_result10 = logTo(some_input10);
        System.out.println("Result is:  \n" + some_result10); //Print the result

        System.out.println("------------------------- Exercise 11 -------------------------\n\n");
        System.out.println("---- Test 1 ----\n");
        int[] some_input11 = {7, 4, 3, 5, 3, 1, 6, 4, 5, 1, 7, 5};//Fill in your input

        System.out.println("Input is:\n\n" + Arrays.toString(some_input11)); //Print the input
        int some_result11 = exercise11(some_input11);
        System.out.println("Result is:  \n" + some_result11); //Print the result

        System.out.println("---- Test 2 ----\n");
        int[] some_input11_2 = {7, 3, 5, 1, 7, 5, 5, 1, 1, 1, 1, 1, 1};//Fill in your input

        System.out.println("Input is:\n" + Arrays.toString(some_input11_2)); //Print the input
        int some_result11_2 = exercise11(some_input11_2);
        System.out.println("Result is:  \n\n" + some_result11_2); //Print the result

    }
}
// Terminal output
//        ------------------------- Exercise 1 -------------------------
//
//        ---- Test 1 ----
//        Input is:
//        4
//        Result is:
//        10
//        ---- Test 2 ----
//        Input is:
//        8
//        Result is:
//        84
//        ------------------------- Exercise 3 -------------------------
//
//        ---- Test 1 ----
//        Input is:
//        12256
//        Result is:
//        false
//        ---- Test 2 ----
//
//        Input is:
//        82842605
//        Result is:
//        true
//        ------------------------- Exercise 4 -------------------------
//
//
//        ---- Test 1 ----
//
//        Input is:
//        [23, 56, 22, 11, 65, 89, 3, 44, 87, 910, 45, 35, 98]
//        Result is:
//        Combination: [89, 3, 35] Closest to Power of two: 128
//        ------------------------- Exercise 6 -------------------------
//
//
//        ---- Test 1 ----
//
//        Input is:
//
//        10
//        Result is:
//        18
//        ------------------------- Exercise 7 -------------------------
//
//
//        ---- Test 1 ----
//
//        Input is:
//        26
//        Result is:
//        [0, 0]
//        ------------------------- Exercise 10 -------------------------
//
//
//        ---- Test 1 ----
//
//        Input is:
//        32
//        Result is:
//        5
//        ------------------------- Exercise 11 -------------------------
//
//
//        ---- Test 1 ----
//
//        Input is:
//
//        [7, 4, 3, 5, 3, 1, 6, 4, 5, 1, 7, 5]
//        1
//        1
//        3
//        3
//        4
//        4
//        5
//        5
//        5
//        6
//        7
//        7
//        Result is:
//        -1
//        ---- Test 2 ----
//
//        Input is:
//        [7, 3, 5, 1, 7, 5, 5, 1, 1, 1, 1, 1, 1]
//        1
//        1
//        1
//        1
//        1
//        1
//        1
//        Result is:
//
//        1









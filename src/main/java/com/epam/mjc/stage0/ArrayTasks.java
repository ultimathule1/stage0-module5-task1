package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[] {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int retInd = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                retInd = i;
                break;
            }
        }
        return retInd;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] retArr = arr.clone();
        for (int i = 0, j = retArr.length - 1; i < j; i++, j--) {
            String tmp = arr[i];
            retArr[i] = arr[j];
            retArr[j] = tmp;
        }

        return retArr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int lengthPosArr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                lengthPosArr++;
            }
        }
        System.out.println("lengthPosArr = " + lengthPosArr);
        int[] retArr = new int[lengthPosArr];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                retArr[j++] = arr[i];
            }
        }

        return retArr;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) {
                if (!isSorted) {
                    i = -1;
                    isSorted = true;
                    continue;
                } else {
                    break;
                }
            }

            if (arr[i].length > arr[i + 1].length) {
                int[] temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                isSorted = false;
            }
        }

        isSorted = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j + 1 == arr[i].length) {
                    if (!isSorted) {
                        j = -1;
                        isSorted = true;
                        continue;
                    } else {
                        break;
                    }
                }

                if (arr[i][j] > arr[i][j + 1]) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;
                    isSorted = false;
                }
            }
        }

        return arr;
    }
}

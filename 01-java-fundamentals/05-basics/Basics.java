import java.util.ArrayList;
import java.util.Arrays;

public class Basics {
    public static void main(String[] args) {
        print255();
        printOdd();
        printSum();
        int[] arr1 = {1,3,5,7,9,13};
        iterateArr(arr1);
        findMax(arr1);
        int[] arr2 = {2,10,3};
        findAvg(arr2);
        oddArr();
        int[] arr3 = {1,3,5,7};
        greaterThanY(arr3, 3);
        int[] arr4 = {1,5,10,-2};
        squareVal(arr4);
        elimiateNegNum(arr4);
        int[] mma = maxMinAvg(arr4);
        System.out.println(Arrays.toString(mma));
        shiftVal(arr4);

        

    }
    // Print 1-255
    // Write a method that prints all the numbers from 1 to 255.

    public static void print255() {
        for(int i=1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    // Print odd numbers between 1-255
    // Write a method that prints all the odd numbers from 1 to 255.

    public static void printOdd() {
        for( int i=1; i <= 255; i++) {
            if(i % 2 != 0) {
                System.out.print(i);
            }
        }
    }

    // Print Sum
    // Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers that have been printed so far. 

    public static void printSum() {
        int sum = 0;
        for(int i=0; i <= 255; i++) {
            sum = i + sum;
            System.out.println("New number: " + i + " Sum: " + sum );
        }
    }
    
    // Iterating through an array
    // Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array and print each value on the screen. Being able to loop through each member of the array is extremely important. 

    public static void iterateArr(int[] x) {
        for(int i=0; i <= 5; i++) {
            System.out.println(x[i]);
        }
    }

    // Find Max
    // Write a method (sets of instructions) that takes any array and prints the maximum value in the array. Your method should also work with a given array that has all negative numbers (e.g. [-3, -5, -7]), or even a mix of positive numbers, negative numbers and zero.

    public static void findMax(int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    // Get Average
    // Write a method that takes an array, and prints the AVERAGE of the values in the array. For example for an array [2, 10, 3], your method should print an average of 5. Again, make sure you come up with a simple base case and write instructions to solve that base case first, then test your instructions for other complicated cases.

    public static void findAvg(int[] arr) {
        int avg = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum = arr[i] + sum;
        }
        avg = sum/ arr.length;
        System.out.println(avg);
    }

    // Array with Odd Numbers
    // Write a method that creates an ArrayList 'y' that contains all the odd numbers between 1 to 255. When the method is done, 'y' should have the value of [1, 3, 5, 7, ... 255].

    public static void oddArr() {
        ArrayList<Object> y = new ArrayList<Object>();
        for( int i=1; i <= 255; i++) {
            if(i % 2 != 0) {
            y.add(i);
            }
        }
        System.out.print(y);
    }

    // Greater Than Y
    // Write a method that takes an array and returns the number of values in that array whose value is greater than a given value y. For example, if array = [1, 3, 5, 7] and y = 3, after your method is run it will print 2 (since there are two values in the array that are greater than 3).

    public static void greaterThanY(int[] arr, int y) {
        int counter = 0;
        for(int i=0; i < arr.length; i++){
            if(arr[i] > y) {
                counter++;               
            }
        }
        System.out.println(counter);
    }

    // Square the values
    // Given any array x, say [1, 5, 10, -2], write a method that multiplies each value in the array by itself. When the method is done, the array x should have values that have been squared, say [1, 25, 100, 4].

    public static void squareVal(int[] x) {
        for(int i=0; i < x.length; i++) {
            x[i] = x[i] * x[i];
        }
        System.out.println(Arrays.toString(x));
    }

    // Eliminate Negative Numbers
    // Given any array x, say [1, 5, 10, -2], write a method that replaces any negative number with the value of 0. When the method is done, x should have no negative values, say [1, 5, 10, 0].

    public static void elimiateNegNum(int[] x) {
        for(int i=0; i < x.length; i++) {
            if(x[i] < 0) {
                x[i] = 0;
            }
        }
        System.out.println(Arrays.toString(x));
    }

    // Max, Min, and Average
    // Given any array x, say [1, 5, 10, -2], write a method that returns an array with the maximum number in the array, the minimum value in the array, and the average of the values in the array. The returned array should be three elements long and contain: [MAXNUM, MINNUM, AVG]

    public static int[] maxMinAvg(int[] arr) {
        int[] newArr = new int[3];
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        newArr[0] = max;
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        newArr[1] = min;
        int avg = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum = arr[i] + sum;
        }
        avg = sum/ arr.length;
        newArr[2] = avg;
        return newArr;
    }

    // Shifting the Values in the Array
    // Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front. For example, when the method is done, an x of [1, 5, 10, 7, -2] should become [5, 10, 7, -2, 0]. Notice that the last number is 0. The method does not need to wrap around the values shifted out of bounds.

    public static void shiftVal(int[] x) {
        for(int i = 0; i < x.length; i++) {
            if(i == x.length-1) {
                x[i] = 0;
                break;
            }
            x[i] = x[i+1];
        }
        System.out.println(Arrays.toString(x));
    }
}
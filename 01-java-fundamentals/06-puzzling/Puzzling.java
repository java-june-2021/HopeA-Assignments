import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Puzzling {
    public static void main(String[] args) {
        int[] puzzArr = {3,5,1,2,7,9,8,13,25,32};
        Object[] returnVal = printSumReturnLrg(puzzArr);
        System.out.println(Arrays.toString(returnVal));
        String[] name = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        System.out.println(Arrays.toString(shuffleAndList(name)));
        letterShuff();
        System.out.println(Arrays.toString(randomNum()));
        sortAndList();
        System.out.println(ranLetterString());
        System.out.println(Arrays.toString(ranTenStrings()));


    }

    // Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)

    public static Object[] printSumReturnLrg(int[] arr) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int sum = 0;
        for(int i=0; i < arr.length; i++) {
            sum +=arr[i];
            if (arr[i] > 10) {
                newArr.add(arr[i]);
            }
            
        }
        System.out.println(sum);
        return newArr.toArray();
    }

    // Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.

    public static Object[] shuffleAndList(String[] arr){
        ArrayList<String> newArr = new ArrayList<String>();
        List<String> nameList = new ArrayList<String>();
        for(int i=0; i < arr.length; i++) {
            nameList.add(arr[i]);
            
        }
        Collections.shuffle(nameList);
        for(int i=0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
            if (nameList.get(i).length() > 5) {
                newArr.add(nameList.get(i));
            }
            
        }
        return newArr.toArray();
    }

    // Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.

    public static void letterShuff() {
        ArrayList<Character> letter = new ArrayList<Character>();
        for (char i = 'a'; i <= 'z'; i++) {
            letter.add(i);
        }
        Collections.shuffle(letter);
        System.out.println(letter);
        System.out.println(letter.get(letter.size()-1));
        System.out.println(letter.get(0));
        if(letter.get(0) == 'a' || letter.get(0) == 'e' || letter.get(0) == 'i' || letter.get(0) == 'o' || letter.get(0) == 'u') {
            System.out.println("I'm a vowel!");
        }
    }

    // Generate and return an array with 10 random numbers between 55-100

    public static int[] randomNum() {
        int[] randomArr = new int[10];
        Random r = new Random();
        for(int i = 0; i < randomArr.length; i++) {
            randomArr[i] = r.nextInt(45)+55;
        }
        
        return randomArr;
    }

    // Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.

    public static Object[] sortAndList() {
        int[] randomArr = randomNum();
        List<Integer> sortList = new ArrayList<Integer>();
        for(int i=0; i < randomArr.length; i++) {
            sortList.add(randomArr[i]);
            
        }
        
        Collections.sort(sortList);
        System.out.println(sortList);
        
        //max
        
        int max = sortList.get(0);
        for(int i=1; i<sortList.size(); i++){
            if (sortList.get(i) > max) {
                max = sortList.get(i);
            }
        }
        System.out.println("The maximum number is: " + max);
        //min

        int min = sortList.get(0);
        for(int i=1; i<sortList.size(); i++){
            if (sortList.get(i) < min) {
                min = sortList.get(i);
            }
        }
        System.out.println("The minimum number is: " + min);

        return sortList.toArray();
    }   

    // Create a random string that is 5 characters long.

    public static String ranLetterString() {
        ArrayList<Character> ranCharArr = new ArrayList<Character>();
        ArrayList<Character> letter = new ArrayList<Character>();
        for (char i = 'a'; i <= 'z'; i++) {
            letter.add(i);
        }
        Collections.shuffle(letter);
        for ( int i = 0; i < 5; i++) {
            ranCharArr.add(letter.get(i));
        }
        System.out.println(ranCharArr);
        StringBuilder ranString = new StringBuilder();
        for(char ranChar : ranCharArr) {
            ranString.append(ranChar);
        }
        return ranString.toString();
    }

    // Generate an array with 10 random strings that are each 5 characters long

    public static String[] ranTenStrings() {
        String[] ranTenStrings = new String[10];
        for(int i=0; i < 10; i++){
            ranTenStrings[i] = ranLetterString();
        }
        return ranTenStrings;

    }


}

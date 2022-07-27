import java.util.*;

class Video_Task {
    public static long method1(String s) {
        long accum = 0;
        int mult = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            char digit = s.charAt(i);
            accum += ( (int) digit - 48 ) * ( Math.pow(10, mult) );
            mult++;
        }

        return accum;
    }

    /* 
    Fill out the below table on video
    Fill out blanks in following questions
    Big O refers to the tight bound in this question
    |-----------------------------------------------|
    | Line                      | Number of Steps   |
    | long accum = 0            |        1           |
    | int mult = 0              |        1           |
    | int i = s.length() - 1    |        1           |
    | i > -1                    |        n + 1           |
    | i--                       |        n           |
    | char digit = s.charAt(i)  |        n           |
    | accum += ...              |        n           |
    | mult++                    |        n           |
    | return accum              |        1           |
    |-----------------------------------------------|

    Runtime Equation: 5n + 5

    Total runtime: O(n)
    */

    public static int[] method2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 3 == 0) {
                int amount = 1;

                for (int j = 0; j < arr.length / 2; j++) {
                    amount *= arr[i];
                }

                arr[i] = amount;
            }
        }

        return arr;
    }

    /* 
    Fill out the below table on video
    Fill out blanks in following questions
    Big O refers to the tight bound in this question

    |-----------------------------------------------|
    | Line                      | Number of Steps   |
    | int i = 0                 |       1            |
    | i < arr.length            |       n+1            |
    | i++                       |       n            |
    | if (i % 3 == 0)           |       n            |
    | int amount = 1            |       n/3            |
    | int j = 0                 |       n/3            |
    | j < arr.length / 2        |       n/3(n/2+1)            |
    | j++                       |       n/3(n/2)            |
    | amount *= arr[i]          |       n/3(n/2)            |
    | arr[i] = amount           |       n/3            |
    | return arr                |       1            |
    |-----------------------------------------------|
    
    Runtime Equation: n^2/2 + 13/3 * n + 3

    Total runtime: O(n^2)
    */
}

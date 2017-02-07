package com.codility.lesson.four;

/***
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 * that, given a non-empty zero-indexed array A of N integers, 
 * returns the minimal positive integer (greater than 0) that does not occur in A.
 *
 * For example, given:
 *
 * A[0] = 1 
 * A[1] = 3 
 * A[2] = 6 
 * A[3] = 4 
 * A[4] = 1 
 * A[5] = 2 
 * the function should return 5.
 *
 * Assume that:
 *
 * N is an integer within the range [1..100,000]; 
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 *
 * Complexity:
 *
 * expected worst-case time complexity is O(N); 
 * expected worst-case space complexity is O(N), 
 * beyond input storage (not counting the storage required for input arguments). 
 * Elements of input arrays can be modified.
 *
 * @author avinash anand
 *
 */
public class MissingInteger {

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 4, 1, 2};
        MissingInteger mi = new MissingInteger();
        System.out.println(mi.solution(a));
        int[] a1 = {1}; //answer is 2
        System.out.println(mi.solution(a1));
        int[] a2 = {2}; // answer is 1 - minimal number > 0 in sequence
        System.out.println(mi.solution(a2));
        int[] a3 = {-1}; // 1 first positive number
        System.out.println(mi.solution(a3));
    }

    public int solution(int[] A) {
        int length = A.length;
        boolean[] counter = new boolean[length];
        for (int i = 0; i < length; i++) {
            //if number at i is +ve i.e. > 0 and its also within length of array
            // it should be within length because that is a sequence from 1 to length that is > 0
            // so any missing number must be within 1 to length
            // so for each found number within length, decrement it by 1, as index of array is 0
            // then fill true at that place in array saying this number in sequence is present
            //by default array is populated with false by java
            if (A[i] > 0 && A[i] <= length) counter[A[i] - 1] = true;
        }

        for (int i = 0; i < counter.length; i++) {
            //any false index means index + 1 from sequence is missing
            if (!counter[i]) return i + 1;
        }
        // this return is for that if everything is there already in sequence,
        // so that means next integer is missing from sequence
        return A.length + 1;
    }

}

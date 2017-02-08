package com.codility.lesson.four;

import java.util.Arrays;

/***
 * A small frog wants to get to the other side of a river. 
 * The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). 
 * Leaves fall from a tree onto the surface of the river.
 *
 * You are given a zero-indexed array A consisting of N integers representing the falling leaves. 
 * A[K] represents the position where one leaf falls at time K, measured in seconds.
 *
 * The goal is to find the earliest time when the frog can jump to the other side of the river. 
 * The frog can cross only when leaves appear at every position across the river from 1 to X 
 * (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). 
 * You may assume that the speed of the current in the river is negligibly small, i.e.
 * the leaves do not change their positions once they fall in the river.
 *
 * For example, you are given integer X = 5 and array A such that:
 *
 * A[0] = 1 
 * A[1] = 3 
 * A[2] = 1 
 * A[3] = 4 
 * A[4] = 2 
 * A[5] = 3 
 * A[6] = 5 
 * A[7] = 4 
 * In second 6, a leaf falls into position 5. 
 * This is the earliest time when leaves appear in every position across the river.
 *
 * Write a function:
 *
 * class Solution { public int solution(int X, int[] A); }
 * that, given a non-empty zero-indexed array A consisting of N integers and integer X,
 * returns the earliest time when the frog can jump to the other side of the river.
 *
 * If the frog is never able to jump to the other side of the river, 
 * the function should return −1.
 *
 * For example, given X = 5 and array A such that:
 *
 * A[0] = 1 
 * A[1] = 3 
 * A[2] = 1 
 * A[3] = 4 
 * A[4] = 2 
 * A[5] = 3 
 * A[6] = 5 
 * A[7] = 4 
 * the function should return 6, as explained above.
 *
 * Assume that:
 *
 * N and X are integers within the range [1..100,000]; 
 * each element of array A is an integer within the range [1..X]. 
 *
 * Complexity:
 *
 * expected worst-case time complexity is O(N); 
 * expected worst-case space complexity is O(X), 
 * beyond input storage (not counting the storage required for input arguments). 
 * Elements of input arrays can be modified.
 *
 * @author avinash anand
 *
 */
public class FrogRiverOne {

    public static void main(String[] args) {
        FrogRiverOne f = new FrogRiverOne();
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        int X = 5;
        System.out.println(f.solution(X, A)); // expected 6 as answer
        int[] A1 = {1, 3, 1, 4, 2, 3, 4};
        int X1 = 5;
        System.out.println(f.solution(X1, A1)); // expected -1 as answer
        int[] A2 = {5, 1, 3, 1, 4, 2, 3, 5, 4};
        int X2 = 5;
        System.out.println(f.solution(X2, A2)); // expected 5 as answer
    }

    // we want to find the earliest moment when all the positions from 1 to X
    // are covered by leaves
    public int solution(int X, int[] A) {
        int moment = -1;
        // position[i] means leaves at position i fell at position[i] moment
        int[] position = new int[X + 1];
        Arrays.fill(position, -1);

        if (A.length < X) {
            return moment;
        } else {
            for (int i = 0; i < A.length; i++) {
                if (A[i] <= X && position[A[i]] == -1) {
                    position[A[i]] = i;// this position is filled at second `i`
                }
            }
            if (position[X] != -1) {
                // System.out.println("position[X] = " + position[X]);
                int max = -1;
                for (int i = 0; i <= X; i++) {
                    if (position[i] > max) {
                        max = position[i];
                    }
                    if (i >= 1 && position[i] == -1) {
                        return -1;
                    }
                }
                moment = max;
            }
        }
        return moment;
    }

}

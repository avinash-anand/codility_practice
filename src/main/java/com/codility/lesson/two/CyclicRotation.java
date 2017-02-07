package com.codility.lesson.two;

import java.util.Arrays;

/***
 * A zero-indexed array A consisting of N integers is given. Rotation of the
 * array means that each element is shifted right by one index, and the last
 * element of the array is also moved to the first place.
 * 
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7].
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right by K indexes.
 * 
 * Write a function:
 * 
 * class Solution { public int[] solution(int[] A, int K); } that, given a
 * zero-indexed array A consisting of N integers and an integer K, returns the
 * array A rotated K times.
 * 
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should
 * return [9, 7, 6, 3, 8].
 * 
 * Assume that:
 * 
 * N and K are integers within the range [0..100]; each element of array A is an
 * integer within the range [−1,000..1,000]. In your solution, focus on
 * correctness. The performance of your solution will not be the focus of the
 * assessment.
 * 
 * @author avinash anand
 *
 */
public class CyclicRotation {

	public static void main(String[] args) {
		CyclicRotation c = new CyclicRotation();
		int[] a1 = {3,8,9,7,6};
		Arrays.stream(c.solution(a1, 3)).forEach(x -> System.out.print(x));
		System.out.println("\n------------");
		Arrays.stream(c.solution(a1, 8)).forEach(x -> System.out.print(x));
		System.out.println("\n------------");
		Arrays.stream(c.solution(a1, 0)).forEach(x -> System.out.print(x));
	}

	public int[] solution(int[] A, int K) {
		int N = A.length;
		int numberOfTimesRotated = N == 0 ? 0 : K % N;
		int [] newArray = new int[N];
		if(A.length == 0 || K == 0) {
			newArray = A;
		} else {
			for(int i=N-numberOfTimesRotated,j=0;i<N;i++,j++) {
				newArray[j] = A[i];
			}
			for(int i = 0,j=numberOfTimesRotated;i<N-numberOfTimesRotated;i++,j++) {
				newArray[j] = A[i];
			}
		}
		return newArray;
	}

}

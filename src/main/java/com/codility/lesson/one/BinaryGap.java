package com.codility.lesson.one;

/***
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros
 * that is surrounded by ones at both ends in the binary representation of N.
 *
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 * The number 529 has binary representation 1000010001 and contains two binary gaps:
 * one of length 4 and one of length 3.
 * The number 20 has binary representation 10100 and contains one binary gap of length 1.
 * The number 15 has binary representation 1111 and has no binary gaps.
 *
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 * that, given a positive integer N, returns the length of its longest binary gap.
 * The function should return 0 if N doesn't contain a binary gap.
 *
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001
 * and so its longest binary gap is of length 5.
 *
 * Assume that:
 *
 * N is an integer within the range [1..2,147,483,647].
 *
 * Complexity:
 *
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 *
 */

public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        // System.out.println(bg.getBinaryOfNum(15));
        // System.out.println(bg.getBinaryOfNum(0));
        // System.out.println(bg.getBinaryOfNum(1));
        // System.out.println(bg.getBinaryOfNum(16));
        // System.out.println(bg.getBinaryOfNum(Integer.MAX_VALUE));
        // System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(bg.solution(Integer.MAX_VALUE));
        System.out.println(bg.solution(16));
        System.out.println(bg.solution(15));
        System.out.println(bg.solution(0));
        System.out.println(bg.solution(9));
        System.out.println(bg.solution(20));
        System.out.println(bg.solution(1041));

    }

    public int solution(int N) {
        int max = 0;
        String binary = Integer.toBinaryString(N);
        char[] arrayOfChars = binary.toCharArray();
        int count = 0;
        if (binary.contains("10") && binary.contains("01")) {
            for (int i = 1; i < arrayOfChars.length; i++) {
                if ((arrayOfChars[i] == '0') && (arrayOfChars[i - 1] == '1')) {
                    count++;
                } else if ((arrayOfChars[i] == '0') && (arrayOfChars[i - 1] == '0') && count > 0) {
                    count++;
                } else if ((arrayOfChars[i] == '1') && (arrayOfChars[i - 1] == '0') && count > 0) {
                    if (count > max) max = count;
                    count = 0;
                }
            }
        }
        return max;
    }

    private String getBinaryOfNum(int n) {
        StringBuffer binaryOfNum = new StringBuffer();
        if (n == 0) {
            binaryOfNum.append(0);
        } else {
            while (n != 0) {
                int remainder = n % 2;
                binaryOfNum.append(remainder);
                n /= 2;
            }
        }
        return binaryOfNum.reverse().toString();
    }

}


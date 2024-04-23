package backjoon.string;

import java.util.*;

public class Test_1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }

    public static char solution(String input1) {
        input1 = input1.toUpperCase();
        char[] arr = input1.toCharArray();
        Arrays.sort(arr);
        int[] wordCount = new int[26];
        for (int i = 0; i < arr.length; i++) {
            int cnt = wordCount[arr[i] - 'A'];
            wordCount[arr[i] - 'A'] = ++cnt;
        }
        int max = wordCount[0];
        char maxChar = 'A';
        for (int i = 1; i < 26; i++) {
            if (wordCount[i] > max) {
                max = wordCount[i];
                maxChar = (char) ('A' + i);
            } else if (wordCount[i] == max) {
                maxChar = '?';
            }
        }
        return maxChar;
    }
}

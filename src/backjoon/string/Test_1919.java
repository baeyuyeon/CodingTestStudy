package backjoon.string;

import java.util.*;

public class Test_1919 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();

        System.out.println(solution(input1, input2));

    }

    public static int solution(String input1, String input2) {
        int[] input1Num = new int[26];
        int[] input2Num = new int[26];

        int result = 0;
        for (int i = 0; i < input1.length(); i++) {
            int index = input1.charAt(i) - 'a';
            input1Num[index] = ++input1Num[index];

        }

        for (int i = 0; i < input2.length(); i++) {
            int index = input2.charAt(i) - 'a';
            input2Num[index] = ++input2Num[index];

        }
        //System.out.println(Arrays.toString(input1Num));
        //System.out.println(Arrays.toString(input2Num));
        for (int i = 0; i < 26; i++) {
            if (input1Num[i] > input2Num[i]) {
                result += input1Num[i] - input2Num[i];
            } else if (input1Num[i] < input2Num[i]) {
                result += input2Num[i] - input1Num[i];
            }
        }
        return result;
    }
}

package backjoon.string;

import java.util.Scanner;
import java.util.*;

public class Test_2744 {

    static int findCnt = 0;
    static Set<String> set = new HashSet<>();
    static int[] initArr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            String in = input.charAt(i) + "";
            if (in.compareTo("A") >= 0 && in.compareTo("Z") <= 0) {
                result.append(in.toLowerCase());
            } else {
                result.append(in.toUpperCase());
            }
        }
        return result.toString();
    }


}
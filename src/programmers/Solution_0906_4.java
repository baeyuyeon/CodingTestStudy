package programmers;

import java.util.*;

public class Solution_0906_4 {

    public static void main(String[] args) {
        String my_string = "people";
        System.out.println("result " + solution(my_string));
    }

    public static String solution(String my_string) {
        String answer = "";
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < my_string.length(); i++) {
            //if (!set.contains(my_string.charAt(i) + "")) {
            answer += my_string.charAt(i);
            set.add(my_string.charAt(i) + "");
            //} else {
            //    cnt++;
            //}
        }
        System.out.println("set = " + set);
        return set.toString();// + "_" + Integer.toString(cnt);
    }
}

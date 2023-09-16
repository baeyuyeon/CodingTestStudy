package programmers.practice;

public class Solution_0907_6 {

    public static void main(String[] args) {
        int age = 23;
        System.out.println(solution(age));
    }

    public static String solution(int age) {
        String answer = "";
        String strAge = Integer.toString(age);
        for (int i = 0; i < strAge.length(); i++) {
            char c = strAge.charAt(i);
            answer += (char) ('a' + Integer.parseInt(String.valueOf(c)));
        }
        return answer;
    }
}

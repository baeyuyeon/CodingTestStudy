package programmers.practice;

import java.util.Arrays;

public class Solution_0910_2 {

    public static void main(String[] args) {
        String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
        System.out.println(Arrays.toString(solution(quiz)));
    }

    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String data = quiz[i];
            String X = data.split(" ")[0];
            String operator = data.split(" ")[1];
            String Y = data.split(" ")[2];
            String Z = data.split(" ")[4];

            /*int x = X.startsWith("-") ? (-1) * Integer.parseInt(X.replace("-", ""))
                    : Integer.parseInt(X.replace("-", ""));
            int y = Y.startsWith("-") ? (-1) * Integer.parseInt(Y.replace("-", ""))
                    : Integer.parseInt(Y.replace("-", ""));
            int z = Z.startsWith("-") ? (-1) * Integer.parseInt(Z.replace("-", ""))
                    : Integer.parseInt(Z.replace("-", ""));*///감쟈합니다...
            int x = Integer.parseInt(X);
            int y = Integer.parseInt(Y);
            int z = Integer.parseInt(Z);
            int result = 0;
            if (operator.equals("-")) {
                result = x - y;
            } else if (operator.equals("+")) {
                result = x + y;
            }
            answer[i] = (result == z) ? "O" : "X";
        }
        return answer;
    }

}

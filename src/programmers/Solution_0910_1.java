package programmers;

public class Solution_0910_1 {

    public static void main(String[] args) {
        String s = "2 1 P 4 Z 7";
        String s2 = "2 1 Z P 3 P 4";

        System.out.println(solution(s));
        System.out.println(solution(s2));

    }

    public static int solution(String s) {
        int answer = 0;
        int before = 0;
        for (String data : s.split(" ")) {
            if (data.equals("Z")) {
                answer -= before;
            } else if (data.equals("P")) {
                answer += before;
            } else {
                answer += Integer.parseInt(data);
                before = Integer.parseInt(data);
            }
        }
        return answer;
    }
}
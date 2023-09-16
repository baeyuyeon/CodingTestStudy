package programmers.practice;

public class Solution_0907_4 {

    public static void main(String[] args) {
        int[] sides = {11, 7};
        System.out.println(solution(sides));
    }

    public static int solution(int[] sides) {
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        int cnt = 0;
        //가장 긴변이 sides안에 속할 경우
        for (int i = max - min + 1; i <= max; i++) {
            cnt++;
        }

        //가장 긴변이 sides안에 안속할 경우
        for (int i = max + 1; i < max + min; i++) {
            cnt++;
        }
        return cnt;
    }
}

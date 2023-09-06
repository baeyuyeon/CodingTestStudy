package programmers.exhustSearch;

import java.util.Arrays;

//카펫 문제
public class Solution_0906_2 {

    public static void main(String[] args) {
        int brown = 4004;
        int yellow = 999999;
        int[] solution = solution(brown, yellow);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int y = 1; y <= yellow; y++) {
            if (yellow % y == 0) {
                int x = yellow / y;
                int brownY = y + 2;
                int brownX = x + 2;
                if (((brownX * brownY) - (x * y)) == brown) {
                    answer[0] = brownX;
                    answer[1] = brownY;
                    break;
                }
            }
        }
        return answer;
    }
}

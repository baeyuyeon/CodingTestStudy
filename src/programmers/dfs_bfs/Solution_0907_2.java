package programmers.dfs_bfs;

import java.util.*;

public class Solution_0907_2 {

    public static int cnt = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        solution(numbers, target);
        System.out.println("cnt = " + cnt);
    }

    public static int solution(int[] numbers, int target) {
        dfs(0, numbers[0], 0, numbers, target);
        dfs(0, -numbers[0], 0, numbers, target);
        return cnt;
    }

    private static void dfs(int index, int num, int sum, int[] numbers, int target) {
        if (num + sum == target && index == numbers.length - 1) {
            cnt++;
            return;
        }
        if (index == numbers.length - 1) {
            return;
        }
        dfs(index + 1, numbers[index + 1], sum + num, numbers, target);
        dfs(index + 1, -numbers[index + 1], sum + num, numbers, target);

    }
}


package programmers.practice;

import java.util.*;

public class Solution_0915_3 {

    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                int stackIndex = stack.removeLast();
                if (numbers[i] > numbers[stackIndex]) {
                    answer[stackIndex] = numbers[i];
                } else {
                    stack.offer(stackIndex);
                    break;
                }
            }
            stack.offer(i);
        }
        return answer;
    }
}

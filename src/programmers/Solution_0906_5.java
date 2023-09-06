package programmers;

import java.util.*;

public class Solution_0906_5 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int K = 5;
//        int[] numbers = {1, 2, 3, 4};
//        int K = 2;
        System.out.println(solution2(numbers, K));
    }

    public static int solution(int[] numbers, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(numbers).forEach(a -> queue.offer(a));
        int first = queue.poll();
        if (k <= 1) {
            return first;
        }
        for (int i = 2; i <= k; i++) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            if (i == 2) {
                queue.offer(first);
            }
            queue.offer(num1);
            queue.offer(num2);
            if (i == k) {
                answer = num2;
            }
            //System.out.println("queue = " + queue);
        }
        return answer;
    }

    public static int solution2(int[] numbers, int k) {
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(numbers).forEach(a -> queue.offer(a));

        for (int i = 1; i < k + 1; i++) {
            if (i == 1) {
                int a = queue.poll();
                queue.offer(a);
            } else {
                for (int j = 0; j < 2; j++) {
                    int a = queue.poll();
                    queue.offer(a);
                }
            }
        }

        return queue.peekLast();
    }
}

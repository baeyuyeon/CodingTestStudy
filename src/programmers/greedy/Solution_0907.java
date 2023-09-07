package programmers.greedy;

import java.util.*;

public class Solution_0907 {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = people.length - 1; i >= 0; i--) {
            deque.offer(people[i]);
        }
        while (!deque.isEmpty()) {
            int first = deque.peekFirst();
            int last = deque.peekLast();
            if (deque.size() == 1) {
                answer++;
                break;
            }
            if (first + last <= limit) {
                answer++;
                deque.pollFirst();
                deque.pollLast();
            } else {
                answer++;
                deque.pollFirst();
            }
        }
        return answer;
    }
}

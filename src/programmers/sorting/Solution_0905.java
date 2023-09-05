package programmers.sorting;

import java.util.*;

// 가장 큰수(아주 좋은 문제인듯!!)
public class Solution_0905 {

    public static void main(String[] args) {
        //int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};
        //int[] numbers = {1, 11, 110, 1110};
        System.out.println("result : " + solution(numbers));
    }

    /*public static String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strArr, Collections.reverseOrder());

        System.out.println("Arrays.toString(strArr = " + Arrays.toString(strArr));
        Deque<String> queue = new ArrayDeque<>();
        Arrays.stream(strArr).forEach(a -> queue.add(a));

        String temp = "";
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            String poll2 = "";
            if (!queue.isEmpty()) {
                poll2 = queue.poll();
                if (Long.parseLong(poll + poll2) >= Long.parseLong(poll2 + poll)) {
                    queue.addFirst(poll + poll2);
                    //answer += poll;
                } else {
                    //answer += (poll2 + poll);
                    queue.addFirst(poll2 + poll);
                }

            } else {
                answer += poll;
                break;
            }

        }
        if (answer.startsWith("0")) {
            answer = "0";
        }

        return answer;
    }*/
    public static String solution(int[] numbers) {
        Queue<String> queue = new PriorityQueue<>((a, b) -> {
            if (Long.parseLong(a + b) >= Long.parseLong(b + a)) {
                return -1;
            } else {
                return 1;
            }
        });
        Arrays.stream(numbers).forEach(a -> queue.offer(Integer.toString(a)));
        String answer = "";
        while (!queue.isEmpty()) {
            answer += queue.poll();
        }
        if (answer.startsWith("0")) {
            answer = "0";
        }

        return answer;
    }
}

package programmers;

import java.util.*;

public class Solution_0910_4 {

    public static void main(String[] args) {
        int[] numlist = {10000, 20, 36, 47, 40, 6, 10, 7000};
        int n = 30;
        System.out.println(Arrays.toString(solution(numlist, n)));
    }

    public static int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Queue<Number> queue = new PriorityQueue<>((a, b) -> {
            if (a.distance == b.distance) {
                return b.num - a.num;
            } else {
                return a.distance - b.distance;
            }
        });
        for (int i = 0; i < numlist.length; i++) {
            queue.offer(new Number(numlist[i], Math.abs(n - numlist[i])));
        }
        int i = 0;
        while (!queue.isEmpty()) {
            answer[i] = queue.poll().num;
            i++;
        }
        return answer;
    }
}

class Number {

    int num;
    int distance;

    public Number(int num, int distance) {
        this.num = num;
        this.distance = distance;
    }
}

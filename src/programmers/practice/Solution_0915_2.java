package programmers.practice;

import java.util.*;

class Solution_0915_2 {

    public static void main(String[] args) {

        System.out.println("solution(38, 40, 2) = " + solution(38, 40, 2));
    }

    public static int solution(int x, int y, int n) {
        int answer = 0;
        Queue<X> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(new X(x, 0));
        while (!queue.isEmpty()) {
            X poll = queue.poll();

            if (poll.value == y) {
                return poll.cnt;
            }
            if (poll.value > y) {
                continue;
            }
            int pollCnt = poll.cnt + 1;
            if (!set.contains(poll.value + n)) {
                if (poll.value + n == y) {
                    return pollCnt;
                }
                queue.offer(new X(poll.value + n, pollCnt));
                set.add(poll.value + n);
            }
            if (!set.contains(poll.value * 2)) {
                if (poll.value * 2 == y) {
                    return pollCnt;
                }
                queue.offer(new X(poll.value * 2, pollCnt));
                set.add(poll.value * 2);
            }
            if (!set.contains(poll.value * 3)) {
                if (poll.value * 3 == y) {
                    return pollCnt;
                }
                queue.offer(new X(poll.value * 3, pollCnt));
                set.add(poll.value * 3);
            }
        }
        return -1;
    }

}

class X {

    int value;
    int cnt;

    X(int value, int cnt) {
        this.value = value;
        this.cnt = cnt;
    }
}
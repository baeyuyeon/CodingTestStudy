package programmers.heap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_0904 {

    public static void main(String[] args) {
        /*int[] scovile = {2, 1, 3, 9, 10, 12};
        int K = 7;*/
        /*int[] scovile = {1, 2, 3};
        int K = 11;*/
        int[] scovile = {7};
        int K = 7;
        System.out.println("result = " + solution(scovile, K));

    }

    public static int solution(int[] scoville, int K) {
        //int answer = 0;

        Queue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach((a) -> queue.offer(a));
        int cnt = 0;
        int temp = 0;
        while (!queue.isEmpty()) {
            int pollData = queue.poll();

            if (pollData >= K && temp == 0) {
                if (cnt == 0) {
                    return 0;
                }
                break;
            } else {

                if (temp == 0) {
                    temp = pollData;
                } else {
                    int newData = temp + (pollData * 2);
                    queue.offer(newData);
                    temp = 0;
                    cnt++;

                    if (queue.size() == 1 && newData < K) {
                        return -1;
                    }
                }
            }
        }

        if (cnt == 0) {
            return -1;
        }

        return cnt;
    }
}

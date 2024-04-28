package backjoon.priorityQueue;

import java.util.*;

public class Test_11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr);
    }

    public static void solution(int arr[]) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.offer(arr[i]);
            }
        }
    }
}

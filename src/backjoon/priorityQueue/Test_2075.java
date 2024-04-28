package backjoon.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Test_2075 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        //int[][] arr = new int[N][N];

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(sc.nextInt());
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                queue.offer(sc.nextInt());
                queue.poll();
            }
        }
        System.out.println(queue.poll());
    }

}

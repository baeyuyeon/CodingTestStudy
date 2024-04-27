package backjoon.bfs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

//DFS와 BFS
public class Test_1260 {

    static int N;
    static int M;
    static int V;
    static int arr[][];
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            //String input2 = sc.nextLine();
            int first = sc.nextInt();
            int second = sc.nextInt();
            arr[first][second] = 1;
            arr[second][first] = 1;
        }
        solution();
    }

    public static void solution() {
        dfs(V);
        System.out.println("");
        visited = new boolean[N + 1];
        bfs(V);
    }

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (visited[poll]) {
                continue;
            }
            System.out.print(poll + " ");
            visited[poll] = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[poll][i] == 1 && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
    }

    public static void dfs(int num) {
        if (visited[num]) {
            return;
        }
        System.out.print(num + " ");
        visited[num] = true;
        for (int i = 1; i <= N; i++) {
            if (arr[num][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}

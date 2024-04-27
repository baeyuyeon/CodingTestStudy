package backjoon.dfs;

import java.util.Scanner;

public class Test_11724_2 {

    static int N;
    static int M;
    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            //String input2 = sc.nextLine();
            int first = sc.nextInt();
            int second = sc.nextInt();
            arr[first][second] = 1;
            arr[second][first] = 1;
        }
        System.out.println(solution());
    }

    public static int solution() {
        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }

        return result;
    }

    public static void dfs(int num) {
        if (visited[num]) {
            return;
        }
        visited[num] = true;
        for (int i = 1; i < N + 1; i++) {
            if (arr[num][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}

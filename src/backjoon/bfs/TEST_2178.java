package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//미로 탐색 문제
public class TEST_2178 {

    boolean[][] visit;
    Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sero = Integer.parseInt(st.nextToken());
        int garo = Integer.parseInt(st.nextToken());

        int[][] arr = new int[sero][garo];

        for(int i=0; i<sero; i++){
            st =new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<garo; j++){
                arr[i][j]= Integer.parseInt(line.substring(j, j+1));
            }
        }
        /*int sero = 2;
        int garo = 25;
        int[][] arr = {

                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}
                , {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1}
        };*/
        TEST_2178 test = new TEST_2178();
        int result = test.solution(sero, garo, arr);
        System.out.println(result);
    }

    private int solution(int sero, int garo, int[][] arr) {

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        visit = new boolean[sero][garo];
        queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int newY = point.y + dy[i];
                int newX = point.x + dx[i];

                if (newY >= 0 && newY < sero && newX >= 0 && newX < garo
                        && !visit[newY][newX] &&
                        arr[newY][newX] != 0) {
                    arr[newY][newX] = arr[point.y][point.x] + 1;
                    visit[newY][newX] = true;
                    queue.offer(new Point(newY, newX));
                }
            }
        }
        return arr[sero - 1][garo - 1];
    }

    class Point {

        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}

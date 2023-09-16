package programmers.practice;

import java.util.*;

public class Solution_0916_2 {

    boolean[][] visited;
    int[][] moved = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //동서남북

    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (maps[i][j] == 0) { //돌로 막힌 부분은 방문했다고 처리함.
                    visited[i][j] = true;
                }
            }
        }
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 1));
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int plusPosition = ++position.value;
            for (int i = 0; i < moved.length; i++) {

                //맵을 넘어서면 continue;
                if (position.y + moved[i][0] >= maps.length || position.y + moved[i][0] < 0
                        || position.x + moved[i][1] >= maps[0].length
                        || position.x + moved[i][1] < 0) {
                    continue;
                }

                //벽이면 continue
                if (maps[position.y + moved[i][0]][position.x + moved[i][1]] == 0) {
                    continue;
                }
                //방문했으면 continue;
                if (visited[position.y + moved[i][0]][position.x + moved[i][1]]) {
                    continue;
                }

                visited[position.y + moved[i][0]][position.x + moved[i][1]] = true;
                maps[position.y + moved[i][0]][position.x + moved[i][1]] = plusPosition;
                queue.offer(new Position(position.y + moved[i][0], position.x + moved[i][1],
                        plusPosition));
            }
        }
        //맨마지막 위치에 방문하지 못하였다면
        if (!visited[maps.length - 1][maps[0].length - 1]) {
            return -1;
        }
        return maps[maps.length - 1][maps[0].length - 1];
    }
}

class Position {

    int y, x;
    int value;

    public Position(int y, int x, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }
}
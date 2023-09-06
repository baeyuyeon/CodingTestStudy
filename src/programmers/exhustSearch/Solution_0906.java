package programmers.exhustSearch;

import java.lang.reflect.Array;
import java.util.Queue;

import java.util.*;

//이문제 포기
public class Solution_0906 {

    static ArrayList<Integer>[] listArr;
    static int mangNum;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        mangNum = n;
        int answer = -1;
        init(n, wires);
        answer = slice();
        return answer;
    }

    private static int slice() {
        int result = 0;
        for (int i = 1; i < listArr.length; i++) {
            ArrayList<Integer> list = listArr[i];
            int a = getTreeSizeDiff(i, list);
        }
        return result;
    }

    private static int getTreeSizeDiff(int point, ArrayList<Integer> list) {
        int diff = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean[] visited = new boolean[mangNum];
            ArrayList<Integer> points = listArr[list.get(i)];

        }
        return diff;
    }


    private static void init(int n, int[][] wires) {
        listArr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            listArr[i] = list;
        }
        for (int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            listArr[x].add(y);
            listArr[y].add(x);
        }
    }
}

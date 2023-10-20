package programmers.exhustSearch;

import java.util.*;

public class Solution_1020 {

    ArrayList<Integer>[] arrayLists;
    int N;

    public static void main(String[] args) {
        //int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        //int n = 9;

        /*int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        int n = 4;*/
        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        int n = 7;

        Solution_1020 s = new Solution_1020();
        int solution = s.solution(n, wires);
    }

    public int solution(int n, int[][] wires) {
        int answer = n;
        arrayLists = new ArrayList[n + 1];
        N = n;
        for (int i = 0; i <= wires.length + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < wires.length; i++) {
            arrayLists[wires[i][0]].add(wires[i][1]);
            arrayLists[wires[i][1]].add(wires[i][0]);
        }
        for (int i = 1; i < arrayLists.length; i++) {
            ArrayList<Integer> dataList = arrayLists[i];

            for (int j = 0; j < dataList.size(); j++) {
                int data = dataList.get(j);
                ArrayList<Integer>[] clone = new ArrayList[n + 1];
                for (int k = 0; k < clone.length; k++) {
                    clone[k] = new ArrayList<>();
                    clone[k].addAll(arrayLists[k]);
                }

                clone[i].remove(Integer.valueOf(data));
                clone[data].remove(Integer.valueOf(i));
                int diff = findDiff(i, clone);
                if (diff < answer) {
                    answer = diff;
                }
            }
        }

        return answer;
    }

    private int findDiff(int breakPoint, ArrayList<Integer>[] lists) {
        int diff = 0;
        boolean[] visited = new boolean[lists.length + 1];
        ArrayList<Integer> list = lists[breakPoint];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        list.stream().forEach(a -> deque.addLast(a));
        visited[breakPoint] = true;
        int count = 1; // breakPoint 방문 한번
        while (!deque.isEmpty()) {
            int data = deque.removeLast();
            if (visited[data]) {
                continue;
            }
            count++;
            visited[data] = true;
            ArrayList<Integer> tempList = lists[data];
            tempList.stream().forEach(a -> {
                        if (!visited[a]) {
                            deque.addLast(a);
                        }
                    }
            );
        }
        diff = (N - count) - (count);
        return Math.abs(diff);
    }
}

package programmers;

import java.util.*;

public class Solution_0910_3 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};
        System.out.println(solution(array));
    }

    public static int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int value = map.getOrDefault(array[i], 0);
            map.put(array[i], ++value);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Queue<Data> queue = new PriorityQueue<>((a, b) -> {
            return b.cnt - a.cnt;
        });

        for (int i = 0; i < keyList.size(); i++) {
            queue.offer(new Data(keyList.get(i), map.get(keyList.get(i))));
        }
        Data first = queue.poll();
        if (queue.isEmpty()) {
            return first.data;
        }
        Data second = queue.poll();
        if (first.cnt == second.cnt) {
            answer = -1;
        } else {
            answer = first.data;
        }

        return answer;
    }
}

class Data {

    int data;
    int cnt;

    public Data(int data, int cnt) {
        this.data = data;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                ", cnt=" + cnt +
                '}';
    }
}
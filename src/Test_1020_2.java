import java.util.*;

//3번 문
public class Test_1020_2 {

    ArrayList<Integer>[] parkLists;

    public static void main(String[] args) {
        int[][] parking =
                {{1, 2}, {3, 4}, {-1, -1}, {-1, -1}, {-1, -1}};
        Test_1020_2 test_1020_2 = new Test_1020_2();
        long result = test_1020_2.solution(parking);
        System.out.println("result = " + result);

    }

    public long solution(int[][] parking) {
        long answer = 0;

        parkLists = new ArrayList[parking.length];
        for (int i = 0; i < parking.length; i++) {
            parkLists[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < parking.length; i++) {

            if (parking[i][0] != -1) {
                parkLists[i].add(parking[i][0]);
                /*if (i != 0) {
                    parkLists[parking[i][0]].add(i);
                }*/
            }
            if (parking[i][1] != -1) {
                parkLists[i].add(parking[i][1]);
                /*if (i != 0) {
                    parkLists[parking[i][1]].add(i);
                }*/
            }
        }
        //주차는 1번 위치부터 가능
        for (int i = 1; i < parkLists.length; i++) {
            //주차가 안되는 위치를 찾기
            Set<Integer> removePoint = getRemovePoints(i);
            for (int j = i + 1; j < parkLists.length; j++) {

                if (!removePoint.contains(j)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    //주차가 안되는 위치를 찾기
    private Set<Integer> getRemovePoints(int parkPoint) {
        Set<Integer> result = new HashSet<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> removeList = parkLists[parkPoint];
        boolean[] visited = new boolean[parkLists.length];
        visited[0] = true;
        visited[parkPoint] = true;
        result.add(parkPoint);
        removeList.stream().forEach(a -> deque.addLast(a));
        while (!deque.isEmpty()) {
            int last = deque.removeLast();
            if (visited[last]) {
                continue;
            }
            visited[last] = true;
            result.add(last);
            ArrayList<Integer> temp = parkLists[last];
            temp.stream().forEach(a -> deque.addLast(a));
        }

        return result;
    }
}
package programmers.heap;

import java.util.*;

//디스크 컨트롤러
public class Solution_0904_2 {

    public static void main(String[] args) {
        /*  int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};*/
        //int[][] jobs = {{1, 3}, {2, 6}, {1, 9}};
        int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34},
                {15, 2}, {35, 43}, {26, 1}};
        System.out.println("result :: " + solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        Queue<Position> workQueue = new PriorityQueue<>((a, b) -> {
            return a.work - b.work;
        });
        Queue<Position> startQueue = new PriorityQueue<>((a, b) -> {
            if (a.start == b.start) {
                return a.work - b.work;
            } else {
                return a.start - b.start;
            }

        });
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            //workQueue.offer(new Position(jobs[i][1], jobs[i][0]));
            startQueue.offer(new Position(jobs[i][1], jobs[i][0]));
        }
        Position firstData = startQueue.poll();
        int endTime = firstData.work + firstData.start;
        answer += (endTime - firstData.start);
        while (!startQueue.isEmpty()) {
            workQueue.offer(startQueue.poll());
        }
        while (!workQueue.isEmpty()) {
            Position position = workQueue.poll();
            if (endTime < position.start) {
                //list.add(position);
                workQueue.offer(position);
                position = startQueue.poll();
            } else {
                answer += (endTime + position.work - position.start);
                endTime = endTime + position.work;
                /*if (list.size() > 0) {
                    list.stream().forEach(a -> workQueue.offer(a));
                }*/

            }

        }
        answer = answer / jobs.length;
        return answer;
    }
}

class Position {

    int work;
    int start;
    boolean use;

    public Position(int work, int start) {
        this.work = work;
        this.start = start;
        this.use = false;
    }
}

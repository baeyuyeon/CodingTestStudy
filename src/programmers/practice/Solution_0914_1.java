package programmers.practice;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class Solution_0914_1 {

    public static void main(String[] args) throws ParseException {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"},
                {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(Arrays.toString(solution(plans)));
    }

    public static String[] solution(String[][] plans) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("hhmm");
        Calendar cal = Calendar.getInstance();
        List<String> answer = new ArrayList<>();
        Queue<Work> queue = new PriorityQueue<>((a, b) -> {
            return a.start - b.start;
        });
        for (String[] plan : plans) {
            queue.offer(new Work(plan[0], Integer.parseInt(plan[1].replace(":", "")),
                    Integer.parseInt(plan[2])));
        }

        Deque<Work> stack = new ArrayDeque<>();

        Work beforeWork = queue.poll();
        while (!queue.isEmpty()) {
            Work pollWork = queue.poll();

            String endTime = "";
            Date beforeEndTime = sdformat.parse(Integer.toString(beforeWork.start));
            cal.setTime(beforeEndTime);
            cal.add(Calendar.MINUTE, beforeWork.workTime);
            System.out.print(beforeWork.workTime + ",");
            endTime = sdformat.format(cal.getTime());
            System.out.println(endTime);
            if (Integer.parseInt(endTime) > pollWork.start) {
                stack.push(beforeWork);
            } else {
                answer.add(beforeWork.name);
            }
            beforeWork = pollWork;
        }
        answer.add(beforeWork.name);

        while (!stack.isEmpty()) {
            Work popWork = stack.pop();
            answer.add(popWork.name);
        }
        String[] result = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;

    }
}

class Work {

    String name;
    int start;
    int workTime;

    public Work(String name, int start, int workTime) {
        this.name = name;
        this.start = start;
        this.workTime = workTime;
    }
}

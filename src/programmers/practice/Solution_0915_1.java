package programmers.practice;

import java.util.*;
import java.text.SimpleDateFormat;

public class Solution_0915_1 {

    public static void main(String[] args) throws Exception {
        String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        System.out.println(solution(book_time));

    }

    public static int solution(String[][] book_time) throws Exception {
        SimpleDateFormat sdformat = new SimpleDateFormat("HHmm");
        Calendar cal = Calendar.getInstance();

        int answer = 0;
        Queue<Room> roomQueue = new PriorityQueue<>((a, b) -> {
            return a.start.compareTo(b.start);
        });
        for (String[] book : book_time) {
            roomQueue.offer(new Room(book[0].replace(":", "")
                    , book[1].replace(":", "")));
        }
        System.out.println(roomQueue);
        //퇴실시간이 저장된 목록
        Queue<Date> booked = new PriorityQueue<>();
        while (!roomQueue.isEmpty()) {
            Room room = roomQueue.peek();

            if (!booked.isEmpty()) { // 예약된 방이 있을 때
                Date endTime = booked.peek();
                Date date = sdformat.parse(room.start);
                // date1과 date2의 분을 비교
                long timeInMillis1 = endTime.getTime();
                long timeInMillis2 = date.getTime();

                // 밀리초를 분으로 변환
                int minutes1 = (int) (timeInMillis1 / (60 * 1000));
                int minutes2 = (int) (timeInMillis2 / (60 * 1000));

                if (minutes1 <= minutes2) {// 현재 예약하려는 방보다 끝나는 시간이 작다면
                    booked.poll(); //예약된 방 꺼낸다.
                }
            }
            Room temp = roomQueue.poll();
            Date date = sdformat.parse(temp.end);
            cal.setTime(date);
            cal.add(Calendar.MINUTE, 10);
            booked.offer(cal.getTime());
        }
        return booked.size();
    }
}

class Room {

    String start;
    String end;

    public Room(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Room{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
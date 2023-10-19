package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution_1019 {

    public static void main(String[] args) throws ParseException {

        System.out.println(Math.ceil(154 / 10.0));

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN",
                "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        Queue<Car> queue = new PriorityQueue<>((a, b) -> {
            return a.carNum.compareTo(b.carNum);
        });

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        HashMap<String, Car> map = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            //"05:34 5961 IN"
            String[] recode = records[i].split(" ");
            if (!map.containsKey(recode[1])) {
                map.put(recode[1], new Car(recode[1], 0, recode[0]));
            } else {
                Car car = map.get(recode[1]);
                if (recode[2].equals("OUT")) {
                    Date start = sdf.parse(car.tempTime);
                    Date end = sdf.parse(recode[0]);
                    // Date -> 밀리세컨즈
                    long timeMil1 = start.getTime();
                    long timeMil2 = end.getTime();

                    // 비교
                    long diff = timeMil2 - timeMil1;

                    long diffMin = diff / (1000 * 60);
                    car.tempTime = "";
                    car.parkSum += diffMin;

                } else {
                    car.tempTime = recode[0];
                }
            }
        }

        for (String carNum : map.keySet()) {
            Car car = map.get(carNum);
            if (!car.tempTime.equals("")) {
                Date start = sdf.parse(car.tempTime);
                Date end = sdf.parse("23:59");
                // Date -> 밀리세컨즈
                long timeMil1 = start.getTime();
                long timeMil2 = end.getTime();

                // 비교
                long diff = timeMil2 - timeMil1;

                long diffMin = diff / (1000 * 60);
                car.tempTime = "";
                car.parkSum += diffMin;
            }
            queue.offer(car);
        }
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];
        int[] answer = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            Car car = queue.poll();

            if (car.parkSum <= defaultTime) {
                answer[i] = defaultFee;
            } else {
                answer[i] = (int) (defaultFee
                        + Math.ceil((double) (car.parkSum - defaultTime) / perTime) * perFee);
            }
            i++;
        }

        return answer;
    }

    static class Car {

        String carNum;
        int parkSum;
        String tempTime;

        public Car(String carNum, int parkSum, String tempTime) {
            this.carNum = carNum;
            this.parkSum = parkSum;
            this.tempTime = tempTime;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "carNum='" + carNum + '\'' +
                    ", parkSum=" + parkSum +
                    ", tempTime='" + tempTime + '\'' +
                    '}';
        }
    }
}

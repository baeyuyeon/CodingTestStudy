package programmers.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//기능개발
public class Solution_0831 {

    public static void main(String[] args) {
/*
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
*/


        int[] progresses = {96, 99, 98, 97};
        int[] speeds = {1,1,1,1};

        int[] result = solution(progresses, speeds);
        System.out.println("Arrays.toString(result = " + Arrays.toString(result));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {0};
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int x = (int) Math.ceil(((float) (100 - progresses[i]) / speeds[i]));
            list.add(x);
        }
        if (list.size() == 0) {
            return answer;
        }
        int cnt = 1;
        int temp=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            /*if (i == list.size() - 1) {
                result.add(cnt);
                result.add(1);
                break;
            }*/

            if (temp >= list.get(i)) {
                if (i == list.size() - 1) {
                    result.add(++cnt);
                }else{
                    cnt++;
                }

            } else {
                if (i == list.size() - 1) {
                    result.add(cnt);
                    result.add(1);
                }else{
                    result.add(cnt);
                    temp = list.get(i);
                    cnt = 1;
                }

            }
        }
        int[] resultArr = result.stream().mapToInt(i -> i).toArray();
        return resultArr;
    }

}

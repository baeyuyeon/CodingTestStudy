package programmers;

import java.util.*;

public class Solution_0907_3 {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(solution2(s));
    }

    public static String solution(String s) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i) + "", map.getOrDefault(s.charAt(i) + "", 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String data : map.keySet()) {
            if (map.get(data) == 1) {
                list.add(data);
            }
        }
        String arr[] = list.toArray(new String[list.size()]);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer;
    }

    public static String solution2(String s) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i) + "", map.getOrDefault(s.charAt(i) + "", 0) + 1);
        }
        List<String> keySet = new ArrayList<>(map.keySet());

        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);

        for (int i = 0; i < keySet.size(); i++) {
            if (map.get(keySet.get(i)) == 1) {
                answer += keySet.get(i);
            }
        }

        return answer;
    }
}

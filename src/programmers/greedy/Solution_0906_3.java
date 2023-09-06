package programmers.greedy;

import java.util.*;

// 체육복
public class Solution_0906_3 {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {1, 2, 3, 4, 5};
        int[] reserve = {2, 1};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Set<Integer> set = new HashSet<>();

        Arrays.stream(reserve).forEach(a -> set.add(a));
        Arrays.sort(lost);
        List<Integer> list = new ArrayList<>();
        Arrays.stream(lost).forEach(a -> list.add(a));

        for (int i = 0; i < list.size(); i++) {
            if (set.contains(list.get(i))) {
                set.remove(lost[i]);
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (set.contains(list.get(i) - 1)) {
                set.remove(list.get(i) - 1);
            } else if (set.contains(list.get(i) + 1)) {
                set.remove(list.get(i) + 1);
            } else {
                answer--;
            }
        }
        return answer;
    }
}

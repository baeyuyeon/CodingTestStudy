package programmers.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_0907_5 {

    public static void main(String[] args) {
        String[] spell = {"s", "o", "m", "d"};
        String[] dic = {"moos", "dzx", "smm", "sunmmo", "som"};
        System.out.println(solution(spell, dic));

    }

    public static int solution(String[] spell, String[] dic) {
        int answer = 2;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < dic.length; i++) {
            Arrays.stream(spell).forEach(a -> set.add(a));
            // chk가 true : 알파벳키에 존재하지 않음, false : 존재함
            boolean chk = false;
            for (int j = 0; j < dic[i].length(); j++) {
                String word = dic[i].charAt(j) + "";
                if (!set.contains(word)) {
                    chk = true;
                    break;
                } else {
                    set.remove(word);
                }
            }
            if (!chk && set.size() == 0) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}

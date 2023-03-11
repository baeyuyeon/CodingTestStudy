package mapTest;
import java.util.*;
public class Test3 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
    //위장 문제
    public static int solution(String[][] clothes) {
        int answer=1;
        Map<String, Integer> map = new HashMap<>(clothes.length);
        for(int i=0; i<clothes.length; i++){
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind,0)+1);
        }
        System.out.println(map.toString());
        for(int value : map.values()){
            answer *= (value+1);
        }
        answer = answer- 1;
        return answer;
    }
}

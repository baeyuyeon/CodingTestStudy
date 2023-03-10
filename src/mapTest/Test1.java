package mapTest;

import java.util.*;
//포켓몬 문제.
public class Test1 {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        if(set.size() > (nums.length/2)){
            answer= nums.length/2;
        }else{
            answer = set.size();
        }
        return answer;
        //return answer;
    }
}
package heap;

import java.util.*;
public class Test1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pQueue = new PriorityQueue<>((a,b)->a-b);
        for(int s : scoville){
            pQueue.offer(s);
        }
        if(pQueue.size()<2){
            return -1;
        }
        boolean  chk = false; //스코빌 지수 위로 올릴 수 있을 때 true

        while(!pQueue.isEmpty()){
            int first = pQueue.poll();//첫번째로 작은수
            if(pQueue.size()==0){
                if(first >= K) chk = true;
                break;
            }
            int second = pQueue.poll(); //둘째로 작은수
            if(first < K){
                first = first + (second*2);
                answer++;
            }else{
                chk=true;
                break;
            }
            pQueue.offer(first);
        }
        if(!chk){
            answer = -1;
        }
        return answer;
    }
}
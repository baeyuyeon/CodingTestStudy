package stackQueueTest;
import java.util.*;
//기능개발
public class Test2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] days = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            double x = Math.ceil((double)(100-progresses[i])/speeds[i]);
            list.add((int)x);
        }
        int max=list.get(0);
        int cnt=1;

        for(int i=1; i<list.size(); i++){
            if(max>=list.get(i)){
                cnt++;
            }else{
                answerList.add(cnt);
                max=list.get(i);
                cnt=1;
            }
        }

        answerList.add(cnt);

        return answerList.stream().mapToInt(i->i).toArray();
    }
}

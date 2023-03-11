package stackQueueTest;
import java.util.*;
//같은 숫자는 싫어
public class Test1 {
    public int[] solution(int []arr) {
        List<Integer> answerList = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++){
            //마지막 값을 확인해서 다 르면 넣음
            if(!deque.isEmpty() && deque.peekLast() !=arr[i]){
                deque.addLast(arr[i]);
            }else if(deque.isEmpty()){
                deque.addLast(arr[i]);
            }
        }

        while(!deque.isEmpty()){
            answerList.add(deque.pollFirst());
        }
        return answerList.stream().mapToInt(i->i).toArray();
    }
}

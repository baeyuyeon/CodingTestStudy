package stackQueueTest;
import java.util.*;
public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();

        System.out.println(test4.solution(new int[]{2, 1, 3, 2},2));
    }
    public  int solution(int[] priorities, int location) {
        int answer = -1;
        Queue<P> queue = new LinkedList<>();
        Queue<P> priorityQueue = new PriorityQueue<>((a,b)->{
            return b.priority-a.priority;
        });
        Queue<P> result = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            queue.offer(new P(priorities[i],i));
            priorityQueue.offer(new P(priorities[i],i));
        }
        int count=0;
        while(true){
            P queueP = queue.poll();
            P priorityQueueP = priorityQueue.poll();
            if(priorityQueueP.priority==queueP.priority){
                count++;
                if(location==queueP.index){//답을 찾음
                    answer = count;
                    break;
                }
            }else{
                queue.offer(queueP);
                priorityQueue.offer(priorityQueueP);
            }
        }


        return answer;
    }
    class P{
        int priority, index;
        P(int priority, int index){
            this.priority = priority;
            this.index=index;
        }
    }
}

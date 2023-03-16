package heap;

import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 5}, {2, 10}, {10000, 2}};

        Test2 test2=new Test2();
        System.out.println(test2.solution(jobs));
    }
    public int solution(int[][] jobs) {

        int answer = 0;
        Queue<Job> timeQueue = new PriorityQueue<>(
                (a, b)->{
                    if(a.time==b.time){
                        return a.position-b.position;
                    }else{
                        return a.time-b.time;
                    }
                }
        );

        Queue<Job> positionQueue = new PriorityQueue<>(
                (a, b)->{
                    if(a.position==b.position){
                        return a.time-b.time;
                    }else{
                        return a.position-b.position;
                    }
                }
        );
        for(int i=0; i<jobs.length; i++){
            positionQueue.offer(new Job(jobs[i][0], jobs[i][1]));
        }
        System.out.println(positionQueue);
        Job first = positionQueue.poll();
        int current =first.position+ first.time;
        int sum=first.time;
        while(!positionQueue.isEmpty()){
            timeQueue.clear();
            positionQueue.stream().forEach(job->timeQueue.offer(job));
            while(!timeQueue.isEmpty()){
                Job job = timeQueue.peek();
                if(job.position<=current){
                    job=timeQueue.poll();
                    sum = sum+job.time+(current- job.position);
                    current=current+job.time;
                    positionQueue.remove(job);
                }else{
                    job=positionQueue.poll();
                    if(job.position>current){
                        sum = sum+job.time;
                    }else{
                        sum = sum+job.time+(current- job.position);
                    }
                    current=current+job.time;
                    break;
                }
            }
        }

        answer = (int)sum/jobs.length;
        return answer;
    }
    class Job{
        int position, time;
        Job(int position, int time){
            this.position = position;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "position=" + position +
                    ", time=" + time +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Job)) return false;
            Job job = (Job) o;
            return position == job.position && time == job.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, time);
        }
    }
}
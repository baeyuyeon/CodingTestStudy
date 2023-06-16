package backjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class TEST_10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Person> queue = new PriorityQueue<>(
                (Person p1, Person p2)->{
                    if(p1.age <p2.age){
                        return -1;
                    }else if(p1.age > p2.age){
                        return 1;
                    }else{
                        if(p1.join < p2.join){
                            return -1;
                        }else{
                            return 1;
                        }
                    }
                }
        );

        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            queue.offer(new Person(age, i, name));
        }
        while(!queue.isEmpty()){
            Person person = queue.poll();
            System.out.println(person.age+" "+person.name);
        }
    }
    static class Person{
        int age;
        int join;
        String name;
        public Person(int age, int join, String name){
            this.age = age;
            this.join = join;
            this.name = name;
        }
    }
}

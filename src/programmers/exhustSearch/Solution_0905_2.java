package programmers.exhustSearch;

import java.io.PrintWriter;
import java.util.*;

//모의고사
public class Solution_0905_2 {

    public static void main(String[] args) {
        //int[] answers = {5, 5, 4, 2, 3};
        int[] answers = {3, 3, 4, 5, 1, 4, 2, 4, 2, 4};
        //int[] answers = {3, 3, 2, 1, 5};
        System.out.println("result :: " + Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList();

        int[] first = {1, 2, 3, 4, 5}; //5개
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5}; //8개
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개

        Queue<Person> queue = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) {
                return a.num - b.num;
            } else {
                return b.score - a.score;
            }
        });

        Person p1 = new Person(0, 1);
        Person p2 = new Person(0, 2);
        Person p3 = new Person(0, 3);
        for (int i = 0; i < answers.length; i++) {
            int subFirst =
                    (i + 1) % first.length == 0 ? (first.length - 1) : (i + 1) % first.length - 1;
            int subSecond = (i + 1) % second.length == 0 ? (second.length - 1)
                    : (i + 1) % second.length - 1;
            int subThird =
                    (i + 1) % third.length == 0 ? (third.length - 1) : (i + 1) % third.length - 1;
           /* System.out.println("subFirst = " + subFirst);
            System.out.println("subSecond = " + subSecond);
            System.out.println("subThird = " + subThird);*/

            if (answers[subFirst] == first[subFirst]) {
                p1.score++;
            }
            if (answers[subSecond] == second[subSecond]) {
                p2.score++;
            }
            if (answers[subThird] == third[subThird]) {
                p3.score++;
            }
        }
        queue.offer(p1);
        queue.offer(p2);
        queue.offer(p3);

        int s = 0;
        while (!queue.isEmpty()) {
            Person poll = queue.poll();
            if (s > poll.score) {
                break;
            }
            s = poll.score;

            answer.add(poll.num);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

}

class Person {

    int score;
    int num;

    public Person(int score, int num) {
        this.score = score;
        this.num = num;
    }

}

package backjoon.string;

import java.util.Scanner;
import java.util.*;

public class Test_1543 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();

        String input2 = sc.nextLine();

        System.out.println(solution(input1, input2));

    }


    public static int solution(String input1, String input2) {
        int result = 0;
        int input2Length = input2.length();

        Deque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < input1.length(); i++) {
            queue.offer(input1.substring(i, i + 1));
        }
        int base = 0; //input1을 순회할 위치

        while (!queue.isEmpty()) {
            String word = queue.poll();
            System.out.println("word = " + word);
            System.out.println(
                    "input2.substring(base, base + 1) = " + input2.substring(base, base + 1));
            if (input2.substring(base, base + 1).equals(word)) {
                base++;
                if (base == input2Length) {
                    result++;
                    base = 0;
                }
            } else {
                base = 0;
                queue.addFirst(word);
            }
        }

        return result;
    }
}

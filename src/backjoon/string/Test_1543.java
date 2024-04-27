package backjoon.string;

import java.util.Scanner;
import java.util.*;

public class Test_1543 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();

        String input2 = sc.nextLine();

        System.out.println(solution3(input1, input2));

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


    public static int solution2(String input1, String input2) {
        int result = 0;

        int position = 0;
        for (int i = 0; i < input1.length(); i++) {
            String word = input1.substring(i, i + 1);
            System.out.println("word :: " + word);
            System.out.println(
                    "input2.substring(position, position + 1) :: " + input2.substring(position,
                            position + 1));
            if (input2.substring(position, position + 1).equals(word)) {
                if (position == input2.length() - 1) {
                    result++;
                    position = 0;
                } else {
                    position++;
                }
            } else {
                position = 0;
            }
        }

        return result;

    }

    //쌤풀
    public static int solution3(String input1, String input2) {
        int result = 0;

        while (true) {
            int index = input1.indexOf(input2);
            //System.out.println(index);
            if (index < 0) {
                break;
            } else {
                result++;
                input1 = input1.substring(index + input2.length());
            }
        }
        return result;
    }
}

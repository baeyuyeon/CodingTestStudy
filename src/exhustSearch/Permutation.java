package exhustSearch;

import java.util.Stack;

public class Permutation {
    private static boolean[] chosen; // 뽑은 원소를 기록
    private static int n;

    public static void main(String[] args) {
        n = 3;
        chosen = new boolean[n];
        final Stack<Integer> stack = new Stack<>();
        search_yy(stack);
    }

    private static void search_yy(Stack<Integer> stack){
        if(stack.size()==n){
            System.out.println(stack.toString());
            return;
        }
        for(int i=1;i<=n; i++){
            if(chosen[i-1]) continue;

            chosen[i-1] = true;
            stack.push(i);

            search_yy(stack);
            chosen[i-1]=false;
            stack.pop();

        }
    }


    private static void search(Stack<Integer> stack) {
        if (stack.size() >= n) {
            System.out.println(stack.toString());
        } else {
            for(int i=1; i<=n; i++) {
                if(chosen[i-1]) continue; // 이미 뽑은 경우는 SKIP


                chosen[i-1] = true; // 포함
                stack.push(i);

                search(stack);

                chosen[i-1] = false; // 제외
                stack.pop();
            }
        }
    }
}
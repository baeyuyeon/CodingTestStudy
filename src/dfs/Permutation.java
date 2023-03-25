import java.util.Stack;

public class Permutation {
    private static boolean[] chosen; // 뽑은 원소를 기록
    private static int n;

    public static void main(String[] args) {
        n = 3;
        chosen = new boolean[n+1];
        final Stack<Integer> stack = new Stack<>();
        search(stack);
    }

    private static void search(Stack<Integer> stack) {
        if (stack.size() >= n) {
            System.out.println(stack.toString());
        } else {
            for(int i=1; i<=n; i++) {
                if(chosen[i]) continue; // 이미 뽑은 경우는 SKIP


                chosen[i] = true; // 포함
                stack.push(i);

                search(stack);

                chosen[i] = false; // 제외
                stack.pop();
            }
        }
    }
}
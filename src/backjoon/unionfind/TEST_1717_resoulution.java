package backjoon.unionfind;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TEST_1717_resoulution {
    int[] parent = null;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TEST_1717_resoulution test = new TEST_1717_resoulution();
        test.init(n);
        for (int i = 0; i < m; i++) {
            int flag = sc.nextInt();
            int first = sc.nextInt();
            int second = sc.nextInt();

            //union
            if (flag == 0) {
                test.union(first, second);
            } else { // valid
                boolean result = test.valid(first, second);
                if (result) {
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
    public void init(int n){
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public void union(int first, int second) {
        first = find(first);
        second = find(second);
        if (first != second) {
            if(first>second){
                parent[first] = second;
            }else{
                parent[second] = first;
            }
        }
    }

    public int find(int n) {
        if(n == parent[n]) {
            return n;
        }else{
            int result = find(parent[n]);

            parent[n] = result;
            return result;
        }
    }

    public boolean valid(int first, int second){
        if (find(first)== find(second)) {
            return true;
        }else{
            return false;
        }
    }

}

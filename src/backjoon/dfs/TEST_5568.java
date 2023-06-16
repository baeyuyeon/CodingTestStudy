package backjoon.dfs;

import java.util.Scanner;
import java.util.*;
public class TEST_5568 {

    static int findCnt = 0;
    static Set<String> set = new HashSet<>();
    static int[] initArr;
    static boolean[] visited ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        findCnt= sc.nextInt();
        visited = new boolean[n];
        initArr = new int[n];
        for(int i =0; i<n; i++){
            initArr[i] = sc.nextInt();
        }
        System.out.println(solution());
    }

    private static int solution() {

        for (int i = 0; i < initArr.length; i++) {
            visited[i] = true;
            dfs(Integer.toString(initArr[i]), 1);
            visited[i] =false;
        }
        System.out.println("set = " + set);
        return set.size();
    }
    private static void dfs(String str, int cnt){

        if (cnt == findCnt) {
            set.add(str);
            return;
        }
        for(int i=0; i<initArr.length; i++){
            if(!visited[i]){
                String newStr = str+Integer.toString(initArr[i]);
                visited[i] =true;
                dfs(newStr, ++cnt);
                cnt--;
                visited[i] =false;
            }
        }
    }


}

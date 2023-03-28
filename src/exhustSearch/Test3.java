package exhustSearch;

import java.util.*;
class Test3 {

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(    test3.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));

    }
    boolean[] visited;
    Stack<int[]> result;
    int count = 0;
    public int solution(int k, int[][] dungeons) {

        int sum = k;
        visited = new boolean[dungeons.length];
        result = new Stack<>();
        makePerm(k, dungeons);
        return count;
    }
    public void makePerm(int k, int[][] dungeons){
        boolean continueLogic = true;
        for(int i=0; i< dungeons.length; i++){
           if(!visited[i]){
               continueLogic = false;
               break;
           }
        }
        if(continueLogic){
            countMax(k);
            return;
        }else{
            for(int i=0; i<dungeons.length; i++){
                //아직 방문하지 않은 곳이면
                if(!visited[i]){
                    visited[i]=true;
                    result.push(new int[]{dungeons[i][0], dungeons[i][1]});
                    makePerm(k, dungeons);
                    visited[i]=false;
                    result.pop();
                }
            }
        }
    }
    public void countMax(int k){
        int tmpCnt = 0;
        Stack<int[]> stack = (Stack<int[]>) result.clone();
        while (!stack.isEmpty()){
            int[] tmp = stack.pop();
            if(k>=tmp[0]){
                tmpCnt++;
                k=k-tmp[1];

            }else{
                break;
            }
        }
        count = Math.max(tmpCnt, count);
    }

}
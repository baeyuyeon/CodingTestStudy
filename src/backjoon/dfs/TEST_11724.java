package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//연결요소의 개수
public class TEST_11724 {

    //방문여부
    boolean visit[];
    //연결리스트
    List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        TEST_11724 test = new TEST_11724();

        /*n */
        /*int[][] input = {
                {6, 8}
                ,{1, 2}
                ,{2, 5}
                ,{5, 1}
                ,{3, 4}
                ,{4, 6}
                ,{5, 4}
                ,{2, 4}
                ,{2, 3}
        };*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] input = new int[m+1][2];
        input[0][0]= n;
        input[0][1]= m;
        for(int i=1; i<=m; i++){
            st =new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            input[i][0]=s;
            input[i][1]=e;
        }
        System.out.println(test.solution(input));
    }
    public int solution(int[][] input) {
        int result=0;
        int nodeCount = input[0][0];
        visit = new boolean[nodeCount+1];
        list = new ArrayList[nodeCount+1];

        for(int i=0; i<nodeCount+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<input.length; i++){
            int node = input[i][0];
            int nextNode = input[i][1];

            list[node].add(nextNode);
            list[nextNode].add(node);
        }

        for(int i=1; i< list.length; i++){
            if(!visit[i]){
                result++;
                DFS(i);
            }
        }

        return result;
    }

    private void DFS(int value) {
        if(visit[value]){
            return;
        }
        visit[value]=true;
        List<Integer> temp = list[value];
        for(int i=0; i<temp.size(); i++){
            DFS(temp.get(i));
        }
    }

}

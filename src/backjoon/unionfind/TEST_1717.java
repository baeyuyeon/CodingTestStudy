package backjoon.unionfind;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//1717 집합의 표현 문제
public class TEST_1717 {
    Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        TEST_1717 test = new TEST_1717();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        test.init(n);
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<m; i++){
            st =new StringTokenizer(br.readLine());
            int flagNum = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(flagNum==0){
                test.union(first,second);
            }else{
                System.out.println(test.getResult(first,second));
            }

        }
    }
    //초기화
    public void init(int n){
        for(int i=0; i<=n; i++){
            map.put(i,i);
        }
    }
    //union
    public void union(int first, int second){
        map.put(first,find(Math.min(first, second)));
        map.put(second,find(Math.min(first, second)));
    }
    //find
    public int find(int num){

        if(map.get(num)==num){
            return num;
        }
        int result = find(map.get(num));
        map.put(num, result);
        return result;
    }


    public String getResult(int first, int second) {
        if (find(first) == find(second)) {
            return "YES";
        }
        return "NO";
    }

}

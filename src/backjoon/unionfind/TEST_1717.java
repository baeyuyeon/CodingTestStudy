package backjoon.unionfind;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//1717 집합의 표현 문제
public class TEST_1717 {
    //Map<Integer,Integer> map = new HashMap<>();
    static int parent[] = null;

    public static void main(String[] args) throws IOException {

        TEST_1717 test = new TEST_1717();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        test.init(n);
        int m = sc.nextInt();

        for(int i=0; i<m; i++){
            int flagNum =  sc.nextInt();
            int first =sc.nextInt();
            int second = sc.nextInt();
            if(flagNum==0){
                test.union(first,second);
            }else{
                if(test.getResult(first,second)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }
    //초기화
    public void init(int n){
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            //map.put(i,i);
            parent[i]=i;
        }
    }
    //union
    public void union(int first, int second){
        /*if (first < second) {
            //map.put(second,find(first));
            parent[second] =find(first);
        }else{
            //map.put(first,find(second));
            parent[first] =find(second);
        }*/
        first = find(first);
        second = find(second);
        if (first < second) {
            //map.put(second,find(first));
            parent[second] =find(first);
        }else{
            //map.put(first,find(second));
            parent[first] =find(second);
        }

    }
    //find
    public int find(int num){

        //if(map.get(num)==num){
        if(parent[num]==num){
            return num;
        }
        /*int result = find(map.get(num));
        map.put(num, result);*/
        int result = find(parent[num]);
        parent[num] = result;

        return result;
    }


    public boolean getResult(int first, int second) {
        if (find(first) == find(second)) {
            return true;
        }
        return false;
    }

}

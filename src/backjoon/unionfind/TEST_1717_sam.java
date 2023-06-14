package backjoon.unionfind;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TEST_1717_sam {
    static int parent[] = null;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n+1];
        int m = sc.nextInt();
        for(int i=0; i<n+1; i++){
            parent[i]=i;
        }

        for(int i=0; i<m; i++){
            int flagNum =  sc.nextInt();
            int first =  sc.nextInt();
            int second =  sc.nextInt();

            if(flagNum==0){
                union(first,second);
            }else{
                if(getResult(first,second)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }

    //union
    public static void union(int first, int second){
        first = find(first);
        second = find(second);
        if (first != second) {
            parent[second] = first;
        }
        System.out.println("parent = " + Arrays.toString(parent));
    }
    //find
    public static int find(int num){
        if(num == parent[num]) return num;
        else{
            return parent[num] = find(parent[num]);
        }

    }


    public static boolean getResult(int first, int second) {
        if (find(first) == find(second)) {
            return true;
        }
        return false;
    }

}

package backjoon.unionfind;

import java.util.Arrays;
import java.util.Scanner;

//가장 가까운 공통 조상
public class TEST_3584 {
    static int parent[]=null;
    static boolean[] firstParentArr=null;
    public static void main(String[] args) {
        TEST_3584 test = new TEST_3584();
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();
        for(int i=0; i<testCnt; i++){
            int nodeCnt = sc.nextInt();
            parent = new int[nodeCnt+1];
            //초기화
            for(int j=0; j<nodeCnt; j++){
                parent[j] = j;
            }
            for(int j=0; j<nodeCnt-1; j++){
                int first = sc.nextInt(); //부모
                int second = sc.nextInt();// 기준노드
                parent[second]=first;
            }
            int solFirst = sc.nextInt();
            int solSecond = sc.nextInt();

            int result = test.solution(solFirst, solSecond);
            System.out.println(result);

            parent=null;
            firstParentArr =null;
        }
    }
    public int solution( int solFirst, int solSecond){
        firstParentArr = new boolean[parent.length];
        firstParentArr[solFirst] = true; //자기자신도 부모로 체크해줘야함.
        checkFirstParent(solFirst);
        return find(solSecond);
    }
    public int checkFirstParent(int num){
        if(num == parent[num]){
            return 0;
        }else{
            firstParentArr[parent[num]] = true;
            return checkFirstParent(parent[num]);
        }
    }
    public int find(int num){
        if(firstParentArr[num]){
            return num;
        }else{
            return find(parent[num]);
        }
    }
}

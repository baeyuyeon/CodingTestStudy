package programmers.unionfind;

import java.util.*;
public class Solution {
    int[] parent ;

    public static void main(String[] args) {
        /*int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};*/
        int n = 4;
        int[][] computers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
        Solution solution = new Solution();
        System.out.println(solution.solution(n, computers));

    }
    public int solution(int n, int[][] computers) {
        parent = new int[computers.length+1];
        for(int i=1; i<computers.length+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<computers.length; i++){
            union((i+1), computers[i]);
        }

        Set<Integer> set = new HashSet<>();
        System.out.println("parent = " + Arrays.toString(parent));
        for(int i=1; i<parent.length; i++){
            set.add(parent[i]);
        }
        return set.size();

    }
    public void union(int point, int[] arr){
        for(int i=0; i<arr.length; i++){
            if((i+1) != point && arr[i] == 1){
                int first = find(i+1);
                int second = find(point);
                if(first != second){
                    if(first > second) parent[first] = second;
                    if(second > first) parent[second] = first;
                }
            }
        }
    }
    public int find(int data){
        if(parent[data] == data){
            return data;
        }else{
            int findData = find(parent[data]);
            parent[data] = findData;
            return findData;
        }
    }
}
package sort;

import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        int[] numbers = {22, 20, 200,22};
        System.out.println(solution(numbers));
    }
    public static String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strArr[i]= Integer.toString(numbers[i]);
        }
        Arrays.sort(strArr,(a,b)->{
            int first = Integer.parseInt(a+b);
            int second =  Integer.parseInt(b+a);
            if(second > first){
                return 1;
            }else{
                return -1;
            }
        });
        //System.out.println(Arrays.toString(strArr));
        /*for(int i=0; i<strArr.length-1; i++){
            if(strArr.length>1 && strArr[i].charAt(0)==strArr[i+1].charAt(0)){
                int first = Integer.parseInt(strArr[i]+strArr[i+1]);
                int second = Integer.parseInt(strArr[i+1]+strArr[i]);
                System.out.println("first  "+i+" : "+first);
                System.out.println("second  "+i+ " : "+second);

                if(second > first){
                    String temp = strArr[i];
                    strArr[i]=strArr[i+1];
                    strArr[i+1]=temp;
                }

            }
        }*/
        for(String str : strArr){
            answer += str;
        }
        if(answer.startsWith("0")){
            answer="0";
        }
        return answer;
    }
}
package programmers.string;
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        String s ="abcabcabcabcdededededede";
        int solution = solution(s);
        System.out.println("solution = " + solution);
    }
    public static int solution(String s) {

        String strAnswer = s;
        for(int cnt=1; cnt<=s.length(); cnt++){

            String completeStr = "";
            String previous="";
            int previousCnt = 0;
            for(int j=0; j<s.length(); j = j+cnt){
                String temp = "";
                if(j+cnt <=s.length()){
                    temp = s.substring(j, j+cnt);
                }else{
                    temp = s.substring(j, s.length());
                }
                //System.out.println("temp = " + temp);
                if(previousCnt==0){
                    previous=temp;
                    previousCnt++;
                }else{
                    if(previous.equals(temp)){
                        previousCnt++;
                    }else{
                        if(previousCnt>0){
                            if(previousCnt == 1){
                                completeStr+=previous;
                            }else{
                                completeStr+=(previousCnt+previous);
                            }
                            previousCnt=0;
                            previous="";
                        }
                        //completeStr+=temp;
                        previous=temp;
                        previousCnt++;
                    }
                }
            }
            if(previousCnt>0) {
                if (previousCnt == 1) {
                    completeStr += previous;
                } else {
                    completeStr += (previousCnt + previous);
                }
            }
            System.out.println("completeStr (cnt)"+cnt+" = " + completeStr);
            if(completeStr.length() < strAnswer.length()){
                strAnswer = completeStr;
            }
        }

        return strAnswer.length();
    }
}

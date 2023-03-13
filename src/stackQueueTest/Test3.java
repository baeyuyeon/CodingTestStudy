package stackQueueTest;

public class Test3 {
    boolean solution(String s) {
        boolean answer = true;
        int start=0;
        int end=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                start++;
            }else{
                end++;
                if(start<end){
                    answer=false;
                    break;
                }
            }
        }
        if(start !=end){
            answer=false;
        }



        return answer;

    }
}

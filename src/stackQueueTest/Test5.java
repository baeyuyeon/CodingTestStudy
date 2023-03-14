package stackQueueTest;

import java.util.Arrays;

public class Test5 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cnt=0;
        boolean chk=false;
        for(int i=0; i<prices.length; i++){
            cnt=0;

            for(int j=i+1; j<prices.length; j++){

                cnt++;
                answer[i]=cnt;
                if(prices[i]>prices[j]){

                    chk=true;
                    break;

                }

            }
            if(!chk){
                answer[i]=prices.length-(i+1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Test5 test = new Test5();
        System.out.println(Arrays.toString(test.solution(new int[]{1, 2, 3, 2, 3})));
    }
}

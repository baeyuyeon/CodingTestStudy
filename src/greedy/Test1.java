package greedy;
import java.util.*;
//조이스틱문제
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        //System.out.println(test1.solution("AAAAAABA"));
        System.out.println(test1.solution("ABAAAAAAAAABB"));
        //System.out.println(test1.solution("JEROEN"));

    }
    public int solution(String name) {
        int answer = 0;
        Deque<Check> deque = new ArrayDeque<>();

        for(int i=0; i<name.length(); i++){
            deque.add(new Check(i,name.charAt(i)));
        }

        int moveACount = 0;
        boolean move = true; //순방향
        while (!deque.isEmpty()) {
            Check check =null;
            if(move){
                check = deque.pollFirst();
            }else{
                check = deque.pollLast();
            }
            if(check.word == 'A'){
                moveACount++;
            }else{
                int tailCount = name.length()- check.index;
                if(moveACount>tailCount){//역순으로 가는게 더좋음.
                    int originPosition = check.index-moveACount-1;
                    if(originPosition <=0){
                        originPosition=0;
                    }
                    System.out.println("originPosition = " + originPosition);
                    answer = answer + originPosition;
                    move=false;
                    deque.addFirst(check);
                }else{
                    int temp=0;
                    if(check.word >='A' && check.word<='M'){
                        temp += check.word-'A';
                    }else{
                        temp += 'Z'-check.word+1;
                    }
                    //움직인거 더해주기.
                    if(check.index!=0)
                        temp++;

                    answer = answer+temp+moveACount;
                    System.out.println("answer = " + answer);
                }
                moveACount=0;
            }

        }

        return answer;
    }
    public int solution3(String name) {
        int answer = 0;
        int aCount =0;
        int minVal1 = 0;
        int minVal2 = 0;
        //순차검색
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i)=='A'){
                aCount++;
            }else{
                char thisChar = name.charAt(i);
                if(name.charAt(i) >='A' && name.charAt(i)<='M'){
                    minVal1 += thisChar-'A';
                }else{
                    minVal1 += 'Z'-thisChar+1;
                }
                if(i !=0){
                    minVal1=minVal1+1+aCount;
                }
            }
        }
        aCount =0; //초기화
        for(int i=name.length()-1; i>=0; i--){
            if(name.charAt(i)=='A'){
                aCount++;
            }else{
                char thisChar = name.charAt(i);
                if(name.charAt(i) >='A' && name.charAt(i)<='M'){
                    minVal2 += thisChar-'A';
                }else{
                    minVal2 += 'Z'-thisChar+1;
                }
                if(i !=0){
                    minVal2=minVal2+1+aCount;
                }
            }
        }
        answer = Math.min(minVal1, minVal2);
        return answer;
    }
    /*public int solution2(String name) {
        int answer = 0;
        List<Check> list = new ArrayList<>(name.length());
        for (int i = 0; i < name.length(); i++) {
            list.add(new Check(i, false));
        }


        int useCount=0;

        while(useCount<=name.length()){
            Queue<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < name.length(); i++) {
                tempList.add(i);
            }

            int index=0;
            int min=0;
            boolean first=false;
            while(!tempList.isEmpty()){
                Integer temp =  tempList.poll();
                //if(!list.get(i).useYn){
                if(!list.get(temp).useYn){
                    char thisChar = name.charAt(temp);
                    int move = 0;
                    if(thisChar >='A' && thisChar<='M'){
                        move = thisChar-'A'+(temp-index);
                    }else{
                        move = thisChar-'A'+1+(temp-index);
                    }
                    if(!first){
                        min=move;
                        index=temp;
                    }else{
                        if(move<min){
                            index=temp;
                            min=move;
                        }
                    }
                    first=true;
                }
            }
            answer+=min;
            Check check = list.get(index);
            check.useYn =true;
            //System.out.println(list);
            useCount++;

        }
        return answer;
    }*/
    class Check{
        int index;
        //boolean useYn;
        char word;
        Check(int index, char word){
            this.index = index;
            this.word =word;
        }

        @Override
        public String toString() {
            return "Check{" +
                    "index=" + index +
                    ", word=" + word +
                    '}';
        }
    }
}

package greedy;

import java.util.*;
//큰 수 만들기
class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.solution2("4177252841", 4));
    }

    //이게 되는 풀이
    public String solution2(String number, int k){
        int start = 0;
        int end = k;
        String answer="";
        while (answer.length() < number.length()-k){
            int maxIndex = maxFind(start, end, number);
            answer += number.substring(maxIndex, maxIndex+1);
            start=maxIndex+1;
            if(end<number.length()-1){
                end++;
            }
        }
        return answer;
    }
    public int maxFind(int start, int end, String number){
        int index=start;
        int max = Integer.parseInt(number.substring(start,start+1));
        for(int i=start;i<=end; i++){
            int present =  Integer.parseInt(number.substring(i,i+1));
            if(max<present){
                max = present;
                index=i;
            }
            if(max == 9){
                break;
            }
        }
        return index;
    }



    public String solution(String number, int k) {
        String answer = "";
        Queue<Position> queue = new PriorityQueue<>((a,b)->{
            if(a.value > b.value){
                return -1;
            }else if(a.value == b.value){
                if(a.position<b.position){
                    return -1;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        });

        Queue<Position> tempQueue = new LinkedList<>();

        for(int i=0; i<number.length(); i++){
            queue.offer(new Position(i, Integer.parseInt(number.substring(i, i+1))));
        }
        int useCount = number.length()-k; // 사용해야할 문자 개수
        int presentPosition=0;
        while(!queue.isEmpty()){
            Position temp = queue.poll();
            if(presentPosition>temp.position){
                continue;
            }
            //뒤에 사용할 수 있는 개수가 useCount 보다 크거나 같으면 이 수 써도됨.
            System.out.println(temp);
            System.out.println("number length() : "+number.length());
            System.out.println("temp.position : "+temp.position);
            System.out.println("useCount : "+useCount);

            if(number.length()-temp.position >= useCount){
                answer += Integer.toString(temp.value);
                useCount--;
                presentPosition=temp.position;

                while(!tempQueue.isEmpty()){
                    queue.offer(tempQueue.poll());
                }


            }else{
                tempQueue.offer(temp);
            }

            if(answer.length() == number.length()-k)
                break;
            System.out.println(tempQueue);
            System.out.println("=====================================");
        }

        return answer;
    }
    class Position{
        int position;
        int value;
        Position(int position, int value){
            this.position = position;
            this.value = value;
        }
        public String toString(){
            return "{ position="+position+", value="+value+"}";
        }
    }
}
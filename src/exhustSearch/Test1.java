package exhustSearch;

import java.util.*;
class Test1 {
    Stack<String> stack;
    Set<Integer> set =new HashSet<>();
    boolean[] visited;
    int answer = 0;

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.solution("011"));
    }
    public int solution(String numbers) {

        for(int i=1; i<=numbers.length(); i++){
            stack = new Stack<>();
            visited = new boolean[numbers.length()];
            makeNum(i, numbers);
        }

        System.out.println("set = " + set);
        for(int num : set){
            if(sosuYn(num)){
                answer++;
            }
        }

        return answer;
    }
    public boolean sosuYn(int x){
        boolean result = true;
        if(x==0 || x==1) return false;
        if(x==2) return true;
        for(int i=2; i<=Math.sqrt(x); i++){
            if(x%i==0){
                result = false;
                break;
            }
        }
        return result;
    }
    //r:  자리수, number 숫자
    public void makeNum(int r,  String number){
        if(stack.size() == r){

            //System.out.println(stack.toString());
            List<String> copyStack = (List) stack.clone();
            String num = "";
            for(String data : copyStack){
                num += data;
            }
            //System.out.println(Integer.parseInt(num));
            /*if(sosuYn(Integer.parseInt(num))){
                answer++;
            }*/
            set.add(Integer.parseInt(num));
        }else{
            for(int i=0; i<number.length(); i++){
                if(visited[i]) continue;
                stack.push(number.charAt(i)+"");
                visited[i]=true;
                makeNum(r, number);
                visited[i]=false;
                stack.pop();
            }
        }
    }

}
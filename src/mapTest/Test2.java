package mapTest;

import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        String[] phone_book = {"3","112","1117","111","213","123456789"};
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));
    }
    //내풀이
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++){
            String strI = phone_book[i];
            String strJ = phone_book[i+1];

            if(strJ.startsWith(strI)){
                answer=false;
                break;
            }

        }
        return answer;
    }
}
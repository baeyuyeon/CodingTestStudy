package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

//문자해독
public class TEST_1593 {

    static int chkCount=0;
    static Map<String,Integer> map = new HashMap();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String nStr = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String mStr = st.nextToken();
        System.out.println(solution2(n, m, nStr, mStr));
    }

    //첫번째 솔루션. 메모리 초과
    private static int solution(int n, int m, String nStr, String mStr) {
        int result = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nStr.substring(i, i + 1));

        }
        for (int i = 0; i < m - n; i++) {
            boolean chk = true;
            for (int j = i; j < i + n; j++) {
                if (!set.contains(mStr.substring(j, j + 1))) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                result++;
            }
        }

        return result;
    }
    //두번째 솔루션.
    private static int solution2(int n, int m, String nStr, String mStr) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            map.put(nStr.substring(i, i + 1), 0);
        }

        for (int i = 0; i < n; i++) {
            String temp = mStr.substring(i, i + 1);
            if (map.containsKey(temp)) {
                if(map.get(temp)==0){
                    chkCount++;
                }
                int value = map.get(temp);

                map.put(temp, ++value);
            }
        }
        if (chkCount == n) {
            result++;
        }

        for (int i = n; i < m ; i++) {
            int start = i - n;
            String temp = mStr.substring(start, start + 1);
            if (map.containsKey(temp)) {
                int value = map.get(temp);
                map.put(temp, --value);
                if(value==0){
                    chkCount--;
                }
            }

            String lastTemp = mStr.substring(i, i + 1);
            if (map.containsKey(lastTemp)) {
                if(map.get(lastTemp)==0){
                    chkCount++;
                }
                int value = map.get(lastTemp);
                map.put(lastTemp, ++value);
            }
            if (chkCount == n) {
                result++;
            }
        }
        return result;
    }

}

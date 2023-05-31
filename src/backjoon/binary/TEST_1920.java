package backjoon.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//수 찾기 문제(메모리 초과남)
public class TEST_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arrN = new int[N];
        for (int i = 0; i < N; i++) {
            String line = st.nextToken();
            arrN[i] = Integer.parseInt(line);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) {
            String line = st.nextToken();
            arrM[i] = Integer.parseInt(line);
        }

        System.out.println("arrM ::: " + Arrays.toString(arrM));

        TEST_1920 test = new TEST_1920();

        int[] result = test.my_solution(N, arrN, M, arrM);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] my_solution(int N, int[] arrN, int M, int[] arrM) {
        int[] result = new int[M];
        Arrays.sort(arrN);
        for (int i = 0; i < arrM.length; i++) {
            int startIndex = 0;
            int endIndex = arrN.length - 1;
            boolean find = false;
            while (startIndex <= endIndex) {
                int middleIndex = (startIndex + endIndex) / 2;
                if (arrM[i] < arrN[middleIndex]) {
                    endIndex = middleIndex - 1;
                } else if (arrM[i] > arrN[middleIndex]) {
                    startIndex = middleIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }
            result[i] = find == true ? 1 : 0;
        }
        return result;
    }









        public int[] solution_teacher(int N, int[] arrN, int M, int[] arrM) {
        Arrays.sort(arrN);
        int result[] = new int[M];
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = arrM[i];
            int start = 0;
            int end = arrN.length-1;
            while (start <= end) {
                int mid_index = (start + end) / 2;
                int mid_value = arrN[mid_index];
                if (mid_value > target) {
                    end = mid_index - 1;
                } else if (mid_value < target) {
                    start = mid_index + 1;
                }else{
                    find = true;
                    break;
                }
            }
            result[i] = (find == true) ? 1 : 0;
        }
        return result;

    }


}

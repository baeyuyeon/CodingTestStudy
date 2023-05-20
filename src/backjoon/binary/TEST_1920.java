package backjoon.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int[] result = test.solution(N, arrN, M, arrM);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] solution(int N, int[] arrN, int M, int[] arrM) {
        int result[] = new int[M];

        Arrays.sort(arrN);

        for (int i = 0; i < M; i++) {
            result[i] = find(arrN, arrM[i]);
        }

        return result;
    }

    public int find(int[] tempArr, int findData) {

        int result = 0;

        if (tempArr.length <= 1) {
            if (tempArr[0] == findData) {
                return 1;
            } else {
                return 0;
            }
        }
        int middle = tempArr.length / 2;
        if (findData < tempArr[middle]) {
            int[] downArr = new int[middle];
            for (int i = 0; i <= middle - 1; i++) {
                downArr[i] = tempArr[i];
            }
            return find(downArr, findData);
        } else if (findData > tempArr[middle]) {
            int[] upArr = new int[middle];
            for (int i = middle+1; i < tempArr.length; i++) {
                upArr[i-(middle + 1)] = tempArr[i];
            }
            return find(upArr, findData);
        } else if (findData == tempArr[middle]) {
            result = 1;
        }

        return result;
    }
}

import java.util.*;

//1번 문제
public class Test_1020_3 {

    String[] markFirst = new String[3];
    String[] markLast = new String[3];
    HashMap<String, Integer>[] maps = new HashMap[3];

    public static void main(String[] args) {
        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] words = {"GPQM", "GPMZ", "EFU", "MMNA"};
        Test_1020_3 test_1020_3 = new Test_1020_3();
        String[] solution = test_1020_3.solution(card, words);
        System.out.println(Arrays.toString(solution));
    }

    public String[] solution(String[] card, String[] words) {

        ArrayList<String> answerList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < card.length; i++) {
            char[] charArr = card[i].toCharArray();
            Arrays.sort(charArr);
            String sortData = String.valueOf(charArr);
            for (int j = 0; j < sortData.length(); j++) {
                String data = String.valueOf(sortData.charAt(j));
                maps[i].put(data, maps[i].getOrDefault(data, 0) + 1);
            }
            markFirst[i] = sortData.substring(0, 1);
            markLast[i] = sortData.substring(sortData.length() - 1, sortData.length());
        }

        for (String word : words) {
            HashMap<String, Integer>[] copyMaps = new HashMap[3];
            for (int i = 0; i < copyMaps.length; i++) {
                copyMaps[i] = new HashMap<>();
                copyMaps[i].putAll(maps[i]);
            }
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            boolean findCheck = true;
            boolean[] useCheck = new boolean[3];
            String sortData = String.valueOf(charArr);
            for (int j = 0; j < sortData.length(); j++) {
                String data = String.valueOf(sortData.charAt(j));

                for (int k = 0; k < 3; k++) {
                    boolean find = findWord(k, data, copyMaps);
                    if (find) {
                        useCheck[k] = true;
                        findCheck = true;
                        break;
                    } else {
                        findCheck = false;
                    }
                }
                if (!findCheck) {
                    break;
                }

            }
            if (findCheck) {
                boolean finChk = true;
                for (int i = 0; i < 3; i++) {
                    if (!useCheck[i]) {
                        finChk = false;
                        break;

                    }
                }
                if (finChk) {
                    answerList.add(word);
                }
            }
        }
        if (answerList.size() > 0) {
            String[] answer = answerList.toArray(new String[answerList.size()]);
            Arrays.sort(answer);
            return answer;
        } else {
            String[] answer = {"-1"};
            return answer;
        }
    }

    public boolean findWord(int i, String data, HashMap<String, Integer>[] copyMaps) {

        char charData = data.charAt(0);

        if (markFirst[i].charAt(0) <= charData && markLast[i].charAt(0) >= charData) {
            if (copyMaps[i].get(data) == null || copyMaps[i].get(data) < 1) {
                return false;
            }
            int value = copyMaps[i].get(data);
            --value;
            copyMaps[i].put(data, value);
            return true;
            //useCheck[0] = true;
        } else {
            return false;
        }
    }
}

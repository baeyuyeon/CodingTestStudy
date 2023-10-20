import java.util.*;

//2번문제
public class Test_1020 {

    public static void main(String[] args) {
        String[][] fr = {{"david", "demi"},
                {"frank", "demi"},
                {"demi", "james"}};
        String user_id = "frank";
        Test_1020 test_1020 = new Test_1020();
        String[] solution = test_1020.solution(fr, user_id);
        System.out.println(Arrays.toString(solution));
    }

    public String[] solution(String[][] friends, String user_id) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            String key = friends[i][0];
            String value = friends[i][1];
            if (map.get(key) != null) {
                ArrayList<String> temp = map.get(key);
                temp.add(value);
                map.put(key, temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(value);
                map.put(key, temp);
            }

            if (map.get(value) != null) {
                ArrayList<String> temp = map.get(value);
                temp.add(key);
                map.put(value, temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(key);
                map.put(value, temp);
            }
        }

        ArrayList<String> findList = map.get(user_id);
        HashMap<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < findList.size(); i++) {
            ArrayList<String> frdList = map.get(findList.get(i));
            for (int j = 0; j < frdList.size(); j++) {
                String name = frdList.get(j);
                if (name.equals(user_id)) {
                    continue;
                }
                countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            }
        }
        int cnt = 0;
        ArrayList<String> people = new ArrayList<>();
        for (String key : countMap.keySet()) {
            int value = countMap.get(key);
            if (value > cnt) {
                people.clear();
                people.add(key);
                cnt = value;
            } else if (value == cnt) {
                people.add(key);
            }
        }

        String[] answer = people.toArray(new String[people.size()]);

        Arrays.sort(answer);
        return answer;
    }
}

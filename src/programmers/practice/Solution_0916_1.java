package programmers.practice;

//타겟 넘버
public class Solution_0916_1 {

    int TARGET;
    int[] NUMBERS;
    int result = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        TARGET = target;
        NUMBERS = numbers;
        recurcive(0, 0);
        return result;
    }

    public void recurcive(int sum, int index) {

        if (index >= NUMBERS.length) {
            if (sum == TARGET) {
                result++;
            }
            return;
        }
        int minusValue = -NUMBERS[index];
        int plusValue = NUMBERS[index];

        index++;
        recurcive(sum + minusValue, index);
        recurcive(sum + plusValue, index);

    }
}

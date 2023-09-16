package programmers.practice;

public class Solution_0908_1 {

    static int serviceChicken = 0;
    static int coupon = 0;
    static int sum = 0;

    public static void main(String[] args) {
        int chicken = 1999;
        System.out.println(solution(chicken));

    }

    public static int solution(int chicken) {
        calculate(chicken);
        return sum;
    }

    private static void calculate(int chicken) {
        coupon += (chicken % 10);
        if (coupon >= 10) {
            sum += (coupon / 10);
            coupon = coupon % 10;
        }

        if (chicken < 10) {
            return;
        }
        serviceChicken = (chicken) / 10;
        sum += serviceChicken;

        calculate(serviceChicken);
    }

}

package programmers.stackQueue;
import java.util.*;
//다리를 지나는 트럭
public class Solution_0901 {
    static int sum = 0;
    static int index = 0;
    public static void main(String[] args) {
        /*int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};*/
        /*int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};*/
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        /*int bridge_length = 10;
        int weight = 12;
        int[] truck_weights = {4,4,4,2,2,1,1,1,1};*/

        System.out.println("result ::: "+ solution2(bridge_length, weight, truck_weights));
    }


    public static int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> list = new LinkedList<>();
        Deque<Truck> pass_trucks = new ArrayDeque<>();
        for(int i = 0; i < truck_weights.length; i++){
            list.offer(truck_weights[i]);
        }

        index = pass_trucks.size()+1;
        while (!list.isEmpty()){
            int data = list.poll();
            //System.out.println("data = " + data);
            sum += data;
            //System.out.println("sum : " + sum);
            if (sum > weight) {
                Truck pollTruck = pass_trucks.poll();
                index = pollTruck.end + 1;
                pass_trucks.add(new Truck(data, index , index+ bridge_length-1));
                sum = sum - pollTruck.gram ;
                index++;
            }else{
                //System.out.println("index::::::::: = " + index);
                pass_trucks.add(new Truck(data, index , index+ bridge_length-1));
                index++;
            }

            chkPassTruck(pass_trucks, index);
            //System.out.println("after   sum = " + sum);
            //System.out.println("pass_trucks = " + pass_trucks);

            //System.out.println("==========================================");

        }
        answer = pass_trucks.getLast().end + 1;
        return answer;
    }
    public static Deque<Truck> chkPassTruck(Deque<Truck> passTruck, int index){
        //System.out.println("passTruck = " + passTruck);
        //System.out.println("index = " + index);
        while (!passTruck.isEmpty()) {
            Truck truck = passTruck.getFirst();
            if(truck.end<index){
                passTruck.removeFirst();
                sum = sum - truck.gram ;
                //index = truck.end + 1;
            }else{
                break;
            }
        }
        return  passTruck;
    }
}

class Truck{
    int gram;
    int start;
    int end;

    public Truck(int gram, int start, int end) {
        this.gram = gram;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "gram=" + gram +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

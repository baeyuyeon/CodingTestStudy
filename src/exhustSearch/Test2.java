package exhustSearch;

class Test2 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        final int moseri = 4; // 갈색이 채워질 수
        for(int i=1; i<=yellow; i++){// i를 세로로 둠.
            if(yellow%i ==0){
                int x = yellow/i; // x:가로

                if(i*2+x*2+moseri == brown){
                    answer[0] = x+2;
                    answer[1] = i+2;
                    break;
                }
            }

        }
        return answer;
    }
}
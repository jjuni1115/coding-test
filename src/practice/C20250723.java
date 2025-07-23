package practice;

public class C20250723 {

    public static void main(String[] args) {

        /**
         * 슈퍼 마리오 앞에 10개의 버섯이 일렬로 놓여져 있다. 이 버섯을 먹으면 점수를 받는다.
         *
         * 슈퍼 마리오는 버섯을 처음부터 나온 순서대로 집으려고 한다. 하지만, 모든 버섯을 집을 필요는 없고 중간에 중단할 수 있다. 중간에 버섯을 먹는 것을 중단했다면, 그 이후에 나온 버섯은 모두 먹을 수 없다. 따라서 첫 버섯을 먹지 않았다면, 그 이후 버섯도 모두 먹을 수 없다.
         *
         * 마리오는 받은 점수의 합을 최대한 100에 가깝게 만들려고 한다.
         *
         * 버섯의 점수가 주어졌을 때, 마리오가 받는 점수를 출력하는 프로그램을 작성하시오.
         *
         */

        int[] mushroom = new int[]{1
                , 2
                , 3
                , 5
                , 8
                , 13
                , 21
                , 34
                , 55
                , 89};

        System.out.println(solution(mushroom));

    }

    public static int solution(int[] mushroom) {


        int[] sum = new int[mushroom.length+1];
        sum[0] = mushroom[0];

        for(int i=1; i<mushroom.length; i++){

            sum[i] = sum[i-1] + mushroom[i];

            if(sum[i] >= 100){

                if(Math.abs(100-sum[i]) > Math.abs(100-sum[i-1] )) {
                    return sum[i - 1];

                }else{
                    return sum[i];
                }

            }

        }

        return sum[mushroom.length];


    }

}

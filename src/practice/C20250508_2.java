package practice;

import java.util.HashMap;

public class C20250508_2 {

    public static void main(String[] args) {

        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));

    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> clothesList = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            clothesList.put(clothes[i][1],clothesList.getOrDefault(clothes[i][1],0)+1);
        }


        if(clothesList.size()>1) {
            for (String i : clothesList.keySet()) {
                answer = answer * (clothesList.get(i) + 1);
            }
            return answer-1;
        }else{
            return clothes.length;
        }
    }

}

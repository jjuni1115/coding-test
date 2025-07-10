package practice;

import java.util.ArrayList;
import java.util.List;

public class C20250509_1 {

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,3,3,0,1,1};
        solution(arr);

    }

    public static int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);

        int temp = arr[0];

        for (int i : arr){
            if(temp == i){
                continue;
            }else{
                answer.add(i);
                temp=i;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }



}

package practice;

import java.util.Arrays;

public class C20250429 {


    public static void main(String[] args){

        int[] numbers = new int[]{6,10,2};

        System.out.println(solution(numbers));

    }


    public static String solution(int[] numbers) {
        String answer = "";

        String[] numberList = new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            numberList[i] = String.valueOf(numbers[i]);
        }


        Arrays.sort(numberList,(a,b)->(b+a).compareTo(a+b));



        for(String i: numberList){
            answer+=i;
        }

        if(numberList[0].equals("0")){
            return "0";
        }

        return answer;
    }


}

package practice;

import java.util.*;

public class C20250509_2 {

    public static void main(String[] args) {

        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        int[] answer = solution(progresses,speeds);

        for(int i: answer){
            System.out.println(i);
        }

    }

    public static int[] solution(int[] progresses, int[] speeds) {
       // int[] answer = {};

        List<Integer> answer = new ArrayList<>();

        //List<Integer> workDayList = new ArrayList<>();
        int[] workDayList = new int[progresses.length];



        for(int i=0;i<progresses.length;i++){
            int workDay = 0;
            if((100-progresses[i])%speeds[i] == 0){
                workDay = (100 - progresses[i]) / speeds[i];
            }else{
                workDay = (100 - progresses[i]) / speeds[i] + 1;
            }

            workDayList[i] = workDay;



        }

        for(int i = 0; i< workDayList.length ;  i++){

            if(workDayList[i] == -1){
                continue;
            }

            int count = 0;
            int temp = workDayList[i];
            for(int j=0; j<workDayList.length;j++){
                if(workDayList[j] == -1){
                    continue;
                }

                if(temp >= workDayList[j]){
                    workDayList[j]=-1;
                    count++;
                }else {
                    break;
                }
            }


            answer.add(count);

        }





        return answer.stream().mapToInt(Integer::intValue).toArray();
    }



}

import java.util.Arrays;

public class C20250616 {

    public static void main(String[] args) {

        int[][] scores = new int[][]{{2,2},{1,4},{3,2},{3,2},{2,1}};

        System.out.println(solution(scores));
    }

    public static int solution(int[][] scores) {
        int answer = 0;

        int[] user_score = scores[0];

        Arrays.sort(scores,(a,b) -> (b[1]+b[0]) - (a[0]+a[1]));



        /*for(int i = 0; i<scores.length; i++){

            int[] target_score = scores[i];
            if(target_score[0] > user_score[0] && target_score[1]>user_score[1]){
                return -1;
            }else{

                if(target_score[0]+target_score[1] == user_score[0]+user_score[1] ){
                    answer++;
                    return answer;
                }

                for(int j = i+1; j<scores.length;j++){
                    if(scores[j][0]>target_score[0] && scores[j][1] > target_score[1]){
                        answer--;
                        break;
                    }
                }
                answer++;
            }




        }
*/

        int[][] filtered = Arrays.stream(scores)
                .filter(arr -> arr[0]+arr[1] >= user_score[0]+user_score[1])
                .toArray(int[][]::new);

        for(int[] i : filtered){

            if(i[0] > user_score[0] && i[1] > user_score[1]){
                return -1;
            }else{
                for(int[] j : filtered){
                    if(j[0] > i[0] && j[1] > i[1]){
                        answer--;
                        break;
                    }
                }
                answer++;
            }

            if(i[0]+i[1] == user_score[0]+user_score[1]){
                return answer;
            }

        }



        return answer;
    }

}

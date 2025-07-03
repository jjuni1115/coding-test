import java.util.ArrayList;
import java.util.List;

public class C20250703 {

    public static void main(String[] args) {

        int n =2;
        int s = 9;


        solution(n,s);

    }

    public static int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(s/n == 0){
            return new int[]{-1};
        }

        int k = s/n;
        int m = s%n;

        for(int i=0; i<n; i++){

            if(i < n-m){
                answer[i] = k;

            }else{
                answer[i] = k+1;
            }

        }





        return answer;
    }

}

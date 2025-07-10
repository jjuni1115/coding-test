package practice;

import java.util.Arrays;

public class C20250430_1 {

    public static void main(String[] args) {

        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{1, 3, 5};

        System.out.println(solution(n, lost, reserve));

    }

    public static int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n - lost.length;

        for (int i = 0; i < lost.length; i++) {


            if (lost[i] != -1) {
                for (int j = 0; j < reserve.length; j++) {

                    if (reserve[j] != -1) {
                        if (lost[i] == reserve[j]) {


                            answer++;
                            reserve[j] = -1;
                            lost[i] = -1;
                            break;
                        }
                    }
                }
            }
        }


        for (int i : lost) {

            if (i != -1) {
                for (int j = 0; j < reserve.length; j++) {


                    if (reserve[j] != -1) {

                        if (reserve[j] == i - 1 || reserve[j] == i + 1) {
                            answer++;
                            reserve[j] = -1;
                            break;
                        }
                    }
                }


            }
        }
        return answer;

    }

}

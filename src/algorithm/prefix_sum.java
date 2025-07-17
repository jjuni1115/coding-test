package algorithm;

import java.util.Random;

public class prefix_sum {

    public static void main(String[] args) {

        int[] nums = new int[]{5,4,3,2,1};

        int[][] nums2 = new int[][]{{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};

        System.out.println(sum(nums));
        System.out.println(sum(nums2));

    }



    public static int sum(int[] nums){

        int[] sum = new int[nums.length+1];

        sum[0] = nums[0];

        for(int i = 1; i<nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }

        return sum[4]-sum[1];
    }

    public static int sum(int[][] nums){

        int[][] sum = new int[nums.length+1][nums[0].length+1];


        for(int i=1; i<nums.length; i++){
            for(int j=1;j<nums[0].length;j++){

                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + nums[i-1][j-1];



            }
        }


        return sum[3][3] - sum[1][3] - sum[3][1] + sum[1][1];
    }

}

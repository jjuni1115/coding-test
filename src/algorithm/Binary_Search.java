package algorithm;

import java.util.Arrays;
import java.util.Random;

public class Binary_Search {


    public static void main(String[] args) {


        int[] nums = new int[1_000_000_00];
        Random rand = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(1000000); // 0~999 사이의 무작위 값
        }


        Arrays.sort(nums);

        long start = System.currentTimeMillis();
        System.out.println(binary_search(nums, 24158));
        long end = System.currentTimeMillis();
        System.out.println((end - start )/ 1000.);

        long start1 = System.currentTimeMillis();
        System.out.println(search(nums, 51651));
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1)/ 1000.);


    }


    public static int binary_search(int[] nums, int target) {


        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }


        }

        return 0;

    }

    public static int search(int[] nums, int target) {

        for(int i=0; i<nums.length; i++){

            if(nums[i] == target){
                return i;
            }


        }


        return 0;
    }


}

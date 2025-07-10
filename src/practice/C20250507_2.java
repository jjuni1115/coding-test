package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class C20250507_2 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,3,2,2,4};

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        List<Integer> numList = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));

        HashSet<Integer> hashSet = new HashSet<>(numList);

        return Math.min(hashSet.size(), numList.size() / 2);
    }

}

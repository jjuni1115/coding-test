import java.util.ArrayDeque;

import java.util.*;
public class C20250526 {

    /**
     * 카카오 초등학교의 "니니즈 친구들"이 "라이언" 선생님과 함께 가을 소풍을 가는 중에 징검다리가 있는 개울을 만나서 건너편으로 건너려고 합니다. "라이언" 선생님은 "니니즈 친구들"이 무사히 징검다리를 건널 수 있도록 다음과 같이 규칙을 만들었습니다.
     *
     * 징검다리는 일렬로 놓여 있고 각 징검다리의 디딤돌에는 모두 숫자가 적혀 있으며 디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어듭니다.
     * 디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며 이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있습니다.
     * 단, 다음으로 밟을 수 있는 디딤돌이 여러 개인 경우 무조건 가장 가까운 디딤돌로만 건너뛸 수 있습니다.
     * "니니즈 친구들"은 개울의 왼쪽에 있으며, 개울의 오른쪽 건너편에 도착해야 징검다리를 건넌 것으로 인정합니다.
     * "니니즈 친구들"은 한 번에 한 명씩 징검다리를 건너야 하며, 한 친구가 징검다리를 모두 건넌 후에 그 다음 친구가 건너기 시작합니다.
     *
     * 디딤돌에 적힌 숫자가 순서대로 담긴 배열 stones와 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 k가 매개변수로 주어질 때, 최대 몇 명까지 징검다리를 건널 수 있는지 return 하도록 solution 함수를 완성해주세요.
     *
     * [제한사항]
     * 징검다리를 건너야 하는 니니즈 친구들의 수는 무제한 이라고 간주합니다.
     * stones 배열의 크기는 1 이상 200,000 이하입니다.
     * stones 배열 각 원소들의 값은 1 이상 200,000,000 이하인 자연수입니다.
     * k는 1 이상 stones의 길이 이하인 자연수입니다.
     */

    public static void main(String[] args) {

        int[] stones = new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        solution(stones,k);

    }


    public static int solution(int[] stones, int k) {
        /*int answer = 0;
        int initial = stones[0];

        Deque<Integer> queue = new ArrayDeque<>();

        int idx = 0;

        while (true) {

            if(stones[idx] <1){
                stones[idx]--;
                queue.add(stones[idx]);
            }else{
                stones[idx]--;
                queue.clear();


            }

            if(queue.size()>=k){
                break;
            }
            if(idx==stones.length-1){
                idx=0;
                queue.clear();
            }else {
                idx++;
            }

        }

        return initial - stones[0] - 1;*/
        int answer = 0;

        int start = 0;
        int end = 200000000;

        while(start<=end){

            int mid = (start+end)/2;

            if(check(mid,stones,k)){
                answer=mid;
                start = mid+1;
            }else{
                end = mid-1;
            }

        }



        return answer;


    }

    public static boolean check(int people, int[] stones, int k){
        int count=0;
        for(int stone : stones){

            if(stone - people<0)
            {
                count++;
                if(count >=k){
                    return false;
                }
            }else{
                count=0;
            }
        }
        return true;
    }

}

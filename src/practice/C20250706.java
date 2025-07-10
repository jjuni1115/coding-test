package practice;

import java.util.*;

public class C20250706 {

    /**
     * 개발자 출신으로 세계 최고의 갑부가 된 어피치는 스트레스를 받을 때면 이를 풀기 위해 오프라인 매장에 쇼핑을 하러 가곤 합니다.
     * 어피치는 쇼핑을 할 때면 매장 진열대의 특정 범위의 물건들을 모두 싹쓸이 구매하는 습관이 있습니다.
     * 어느 날 스트레스를 풀기 위해 보석 매장에 쇼핑을 하러 간 어피치는 이전처럼 진열대의 특정 범위의 보석을 모두 구매하되 특별히 아래 목적을 달성하고 싶었습니다.
     * 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
     * <p>
     * 예를 들어 아래 진열대는 4종류의 보석(RUBY, DIA, EMERALD, SAPPHIRE) 8개가 진열된 예시입니다.
     * <p>
     * 진열대 번호	1	2	3	4	5	6	7	8
     * 보석 이름	DIA	RUBY	RUBY	DIA	DIA	EMERALD	SAPPHIRE	DIA
     * 진열대의 3번부터 7번까지 5개의 보석을 구매하면 모든 종류의 보석을 적어도 하나 이상씩 포함하게 됩니다.
     * <p>
     * 진열대의 3, 4, 6, 7번의 보석만 구매하는 것은 중간에 특정 구간(5번)이 빠지게 되므로 어피치의 쇼핑 습관에 맞지 않습니다.
     * <p>
     * 진열대 번호 순서대로 보석들의 이름이 저장된 배열 gems가 매개변수로 주어집니다. 이때 모든 보석을 하나 이상 포함하는 가장 짧은 구간을 찾아서 return 하도록 solution 함수를 완성해주세요.
     * 가장 짧은 구간의 시작 진열대 번호와 끝 진열대 번호를 차례대로 배열에 담아서 return 하도록 하며, 만약 가장 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간을 return 합니다.
     * <p>
     * [제한사항]
     * gems 배열의 크기는 1 이상 100,000 이하입니다.
     * gems 배열의 각 원소는 진열대에 나열된 보석을 나타냅니다.
     * gems 배열에는 1번 진열대부터 진열대 번호 순서대로 보석이름이 차례대로 저장되어 있습니다.
     * gems 배열의 각 원소는 길이가 1 이상 10 이하인 알파벳 대문자로만 구성된 문자열입니다.
     */

    public static void main(String[] args) {

        String[] gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};


        solution(gems);

    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemSet = new HashSet<>(List.of(gems));

        if (gemSet.size() == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }

        Set<String> currentSet = new HashSet<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int sizeA = a[1] - a[0];
            int sizeB = b[1] - b[0];
            if (sizeA != sizeB) {
                return Integer.compare(sizeA, sizeB);
            }
            return Integer.compare(a[0], b[0]);

        });

        int aIdx = 0;
        int bIdx = 0;

        int count = 0;

/*        while (aIdx < gems.length && bIdx < gems.length) {

            if (aIdx > gems.length - gemSet.size()) {
                break;
            }

            if (currentSet.contains(gems[bIdx])) {
                bIdx++;
                continue;
            } else {
                currentSet.add(gems[bIdx]);
                bIdx++;
            }


            if (currentSet.size() == gemSet.size()) {

                queue.add(new int[]{aIdx + 1, bIdx});
                aIdx++;
                bIdx = aIdx;
                currentSet.clear();
            }


        }*/

        /*int start=0;
        int end=gemSet.size()-1;
        int size = gemSet.size()-1;

        while(end<gems.length){


            String[] currGems = Arrays.copyOfRange(gems,start,end+1);
            Set<String> currSet = new HashSet<>(List.of(currGems));

            if(gemSet.size() == currSet.size()){
                answer[0] = start+1;
                answer[1] = end+1;
                return answer;
            }

            start++;
            end++;

            if(end>=gems.length){
                start=0;
                size++;
                end=size;
                continue;
            }





        }*/

        int start=0;
        int end=0;
        int min = Integer.MAX_VALUE;
        HashMap<String,Integer> gemMap = new HashMap<>();

        while(end<gems.length){
            gemMap.put(gems[end],gemMap.getOrDefault(gems[end],0)+1);
            end++;


            while(gemMap.size() == gemSet.size()){

                if(end-start < min){
                    answer[0] = start+1;
                    answer[1] = end;
                    min = end-start;
                }

                gemMap.put(gems[start],gemMap.get(gems[start])-1);
                if(gemMap.get(gems[start])==0){
                    gemMap.remove(gems[start]);
                }
                start++;







            }





        }




        return answer;
    }


}

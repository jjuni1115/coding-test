package practice;

import java.util.*;

public class C20250520 {

    public static void main(String[] args) {

        int n = 6;
        int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        solution(n,edge);

    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[] visited = new boolean[n+1];
        int[] cost = new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);


        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{1,0});


        while(!queue.isEmpty()){

            int[] node = queue.poll();
            if(visited[node[0]]){
                continue;
            }

            visited[node[0]]=true;
            cost[node[0]] = Math.min(cost[node[0]],node[1]);

            for(int[] vertex : edge){

                if(vertex[0] == node[0]){
                    queue.add(new int[]{vertex[1],node[1]+1});
                }
                if(vertex[1] == node[0]){
                    queue.add(new int[]{vertex[0],node[1]+1});
                }

            }



        }

        Arrays.sort(cost);

        for(int i = n-1; i>0;i--){
            if(cost[i] == cost[n-1]){
                answer++;
            }
        }

        return answer;

    }

}

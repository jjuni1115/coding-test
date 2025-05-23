import java.util.*;

public class C20250522 {

    public static void main(String[] args) {

        int n = 5;
        int[][] roads = new int[][]	{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = new int[]{1,3,5};
        int destination = 1;

        solution(n,roads,sources,destination);

    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];


        int[] cost = new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);


        for(int i =0; i<sources.length; i++){
            boolean[] visited = new boolean[n+1];
            answer[i] = bfs(i,1,roads, visited);
        }



        return answer;

    }

    public static int bfs(int start, int target, int[][] roads, boolean[] visited){

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start,0});

        while(!queue.isEmpty()){

            int[] node = queue.poll();
            if(node[0] == target){
                return node[1];
            }

            for(int[] road : roads){

                if(road[0] == node[0]){
                    queue.add(new int[]{road[1],node[1]+1});
                }
                if(road[1] == node[0]){
                    queue.add(new int[]{road[0],node[1]+1});
                }

            }



        }



        return -1;
    }

}

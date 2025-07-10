package practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class C20250422 {

    public static void main(String[] args){

        int n = 5;
        int[][] computers = {
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 1, 1, 1}
        };

        solution(n, computers);


    }

    public static void solution(int n, int[][] computers){


        Deque<Integer> queue = new ArrayDeque<>();

        boolean[] visited = new boolean[n];

        int answer = 0;

        for(int k =0; k<n; k++){

            if(visited[k]){
                continue;
            }

            queue.add(k);
            visited[k] = true;

            bfs(queue, computers, visited, n);
            answer++;

        }


        //int answer = bfs(queue, computers, visited, n);

        //queue.add(2);
        //visited[2] = true;
        //int answer2 = bfs(queue, computers, visited, n);

        System.out.println("visited = " + visited[0]);



    }

    public static int bfs(Deque<Integer> queue, int[][] computers, boolean[] visited, int n){

        int count = 0;


        while (!queue.isEmpty()){

            int i = queue.poll();

            for(int j=0; j<n; j++){

                if(i==j){
                    continue;
                }

                if(computers[i][j] == 1 && !visited[j]){
                    visited[j] = true;
                    queue.add(j);
                    count++;
                }

            }


        }

        return count;


    }


}

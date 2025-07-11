package algorithm;

import java.util.*;

public class Djikstra {

    static class Node{
        int vertex;
        int cost;

        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost= cost;
        }


    }


    public static void main(String[] args) {

        int[][] edges = new int[][] {
            {1, 2, 10},
            {1, 3, 3},
            {2, 3, 1},
            {2, 4, 2},
            {3, 2, 4},
            {3, 4, 8},
            {3, 5, 2},
            {4, 5, 7},
            {5, 4, 9}
        };

        int n=5;
        int start=1;
        int end = 4;
        dijkstra(edges,n,start,end);
        floyd_warshall(edges,n,start,end);


    }

    public static int dijkstra(int[][] edges,int n, int start, int end){


        HashMap<Integer, List<Node>> graph = new HashMap<>();

        for(int[] edge : edges){

            graph.computeIfAbsent(edge[0],k-> new ArrayList<>()).add(new Node(edge[1],edge[2]));




        }

        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);

        pq.add(new Node(start,0));
        cost[start-1] = 0;


        while(!pq.isEmpty()){


            Node currNode = pq.poll();

            if(cost[currNode.vertex-1] < currNode.cost){
                continue;
            }

            for(Node nextNode : graph.get(currNode.vertex)){

                if(cost[nextNode.vertex-1] > nextNode.cost + currNode.cost){
                    cost[nextNode.vertex-1] = nextNode.cost + currNode.cost;
                    pq.add(new Node(nextNode.vertex,nextNode.cost+currNode.cost));
                }



            }





        }


        return cost[end-1];




    }

    public static int floyd_warshall(int[][] edges, int n, int start, int end){



        int[][] graph = new int[n][n];

        for(int [] i : graph){
            Arrays.fill(i,Integer.MAX_VALUE/2);
        }

        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }



        for(int[] edge : edges){

            graph[edge[0]-1][edge[1]-1] = edge[2];

        }


        for(int k=0; k<n; k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }


                }
            }


        }

        return graph[start-1][end-1];






    }




}

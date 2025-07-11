package algorithm;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MST {

    public static void main(String[] args) {

        int[][] edges = new int[][]{{1,2,6},{1,3,3},{2,3,2},{2,4,5},{3,4,3},{3,5,4}, {4,5,2},{4,6,3},{5,6,5}};
        int n = 6;
        prim(edges,1,n);
        kruskal(edges,1,n);

    }




    public static int prim(int[][] edges, int start, int n){

        int cost=0;

        HashMap<Integer, List<Node>> graph = new HashMap<>();

        for(int[] i : edges){

            graph.computeIfAbsent(i[0],k -> new ArrayList<>()).add(new Node(i[0],i[1],i[2]));
            graph.computeIfAbsent(i[1],k -> new ArrayList<>()).add(new Node(i[1],i[0],i[2]));

        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
        boolean[] visited = new boolean[n];

        for(Node i : graph.get(start)){
            pq.add(new Node(i.start,i.end,i.cost));
        }

        int count=0;

        while(count<n-1){

            Node currNode = pq.poll();

            if(visited[currNode.end-1]){
                continue;
            }

            cost += currNode.cost;
            count++;
            visited[currNode.end-1]=true;

            for(Node nextNode : graph.get(currNode.end)){

                pq.add(new Node(nextNode.start,nextNode.end,nextNode.cost));


            }



        }



        return cost;

    }

    public static int kruskal(int[][] edges, int start, int n){

        int cost=0;

        PriorityQueue<Node>pq = new PriorityQueue<>((o1,o2) -> o1.cost-o2.cost);

        for(int[] i : edges){

            pq.add(new Node(i[0],i[1],i[2]));

        }



        int count=0;
        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i+1;
        }

        while(count<n-1){

            Node currNode = pq.poll();

            if(find(parent,currNode.start)!=find(parent,currNode.end)){


                cost+=currNode.cost;
                union(parent,currNode.start, currNode.end);
                count++;


            }else{
                continue;
            }



        }
        return cost;



    }


    static class Node{

        int start;
        int end;

        int cost;

        public Node(int start, int end, int cost){
            this.start=start;
            this.end=end;
            this.cost=cost;
        }



    }

    public static int find(int[] parent, int v){

        if(parent[v-1] == v){
            return v;
        }

        parent[v-1] = find(parent,parent[v-1]);
        return parent[v-1];


    }

    public static void union(int[] parent, int v1, int v2){
        if(parent[v1-1] > parent[v2-1]){
            parent[v1-1] = parent[v2-1];
        }else{
            parent[v2-1] = parent[v1-1];
        }
    }

}

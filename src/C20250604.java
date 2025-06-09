import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class C20250604 {

    /**
     * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
     *
     * 다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
     *
     * 제한사항
     *
     * 섬의 개수 n은 1 이상 100 이하입니다.
     * costs의 길이는 ((n-1) * n) / 2이하입니다.
     * 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
     * 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
     * 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
     * 연결할 수 없는 섬은 주어지지 않습니다.
     */


    public static void main(String[] args) {

        int n = 4;
        int[][] costs = new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(kruskal(n,costs));

    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;


        HashMap<Integer,List<node>> graph = new HashMap<>();
        for(int[] cost : costs){
            graph.computeIfAbsent(cost[0],k -> new ArrayList<>()).add(new node(cost[1],cost[2]));
            graph.computeIfAbsent(cost[1],k-> new ArrayList<>()).add(new node(cost[0],cost[2]));
        }

        boolean[] visited = new boolean[n];

        PriorityQueue<node> pq = new PriorityQueue<>((o1,o2) -> o1.cost-o2.cost);

        for(node i : graph.get(0)){
            pq.add(i);
        }

        visited[0]=true;

        int count = 0;

        while(count<n-1){

            node i = pq.poll();
            if(visited[i.target]){
                continue;
            }

            answer+=i.cost;
            count++;
            visited[i.target] = true;
            for(node t : graph.get(i.target)){
                pq.add(t);
            }

        }


        return answer;
    }

    static class node{
        int start;
        int target;
        int cost;

        public node(int start,int target,int cost){
            this.start=start;
            this.target=target;
            this.cost=cost;
        }
        public node(int target,int cost){
            this.target=target;
            this.cost=cost;
        }
    }

    public static int kruskal(int n, int[][] costs){
        int answer = 0;

        PriorityQueue<node> pq = new PriorityQueue<>((o1,o2) ->o1.cost-o2.cost);

        for(int[] cost :  costs){
            pq.add(new node(cost[0],cost[1],cost[2]));


        }

        boolean[] visited = new boolean[n];
        node k = pq.poll();
        visited[k.start]=true;
        visited[k.target]=true;
        answer+=k.cost;


        int count=0;
        while(count<n-2){

            node i = pq.poll();

            if(visited[i.target] && visited[i.start] ){
                continue;
            }

            visited[i.target]=true;
            visited[i.start]=true;
            answer+=i.cost;
            count++;



        }


        return answer;

    }

}

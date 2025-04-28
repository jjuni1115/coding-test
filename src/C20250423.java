import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class C20250423 {

    public static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {



        String[][] tickets = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };
// 예상 결과: ["ICN", "LAX", "SEA", "DFW", "NRT", "SEA"]
        solution(tickets);
    }

    public static String[] solution(String[][] tickets) {


        List<String> a = new ArrayList<>();


        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            if (ticket[0].equals("ICN")) {

                boolean[] visited = new boolean[tickets.length];
                List<String> path = new ArrayList<>();

                path.add(ticket[0]);
                path.add(ticket[1]);

                dfs(visited,tickets,ticket,path);
                if(a.size()==0 || compare(a,path)>0){
                    a=path;
                }

                System.out.println("");

            }


        }

        return answer.toArray(new String[0]);

    }

    public static void dfs(boolean[] visited,String[][] tickets,String[] startTicket, List<String> path){


        for(int i=0; i<tickets.length; i++){

            if(path.size() == tickets.length+1){
                answer = path;
                return;
            }

            if(tickets[i][0].equals(startTicket[1]) && !visited[i]){
                visited[i]=true;
                System.out.println(tickets[i][1]);
                path.add(tickets[i][1]);
                dfs(visited,tickets,tickets[i],path);
                if(answer!=null) return;
                visited[i]=false;
                path.remove(path.size()-1);
            }
        }


    }



    public static int compare(List<String> a, List<String> b){

        int minSize = Math.min(a.size(),b.size());

        for(int i=0; i<minSize; i++){
            int cmp = a.get(i).compareTo(b.get(i));
            if(cmp!=0){
                return cmp;
            }
        }

        return Integer.compare(a.size(), b.size());

    }




}

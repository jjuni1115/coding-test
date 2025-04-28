import java.util.ArrayDeque;
import java.util.Deque;

public class C20250428 {

    private static int[] dx = new int[]{1,0,-1,0};
    private static int[] dy = new int[]{0,1,-1,0};

    public static void main(String[] args){




        int[][] gameboard = new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};

        int[][] table = new int[][]{{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        solution(gameboard, table);

    }


    public static void solution(int[][] game_board, int[][] table) {

        boolean[][] visited = new boolean[table.length][table[0].length];

        for(int i=0; i<table.length;i++){
            for (int j = 0; j<table[0].length; j++){
                if(table[j][i]==1 && !visited[j][i]){
                    int temp = bfs(visited, new int[]{i,j}, table);
                    System.out.println(temp);
                }
            }
        }

    }


    public static int bfs(boolean[][] visited,int[] start, int[][] board){

        int dist = 0;

        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{start[0],start[1]});

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            visited[node[1]][node[0]]=true;
            dist++;
            for(int i=0;i<4;i++){

                int x = node[0]+dx[i];
                int y = node[1]+dy[i];

                if(x<visited.length && y<visited.length && x>=0 && y>=0 && board[y][x] == 1 && !visited[y][x]){

                    queue.add(new int[]{x,y});

                }

            }

        }
        return dist;

    }


}

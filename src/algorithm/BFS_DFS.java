package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS_DFS {

    static final int[] dx = new int[]{1,0,-1,0};
    static final int[] dy = new int[]{0,1,0,-1};


    public static void main(String[] args) {

        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        };

        System.out.println(find_piece(grid));


    }


    public static int find_piece(int[][] grid){
        int count = 0;


        boolean[][] visited = new boolean[grid.length][grid[0].length];


        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j] == 1 && !visited[i][j]){


                    dfs(grid,visited,i,j);
                    count++;

                }


            }
        }

        return count;

    }


    public static void bfs(int[][] grid, boolean[][] visited, int x, int y){


        int count = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        count++;

        while(!queue.isEmpty()){

            int[] currNode = queue.poll();
            visited[currNode[0]][currNode[1]]=true;
            count++;
            for(int i=0; i<4; i++){
                int nx = currNode[0] + dx[i];
                int ny = currNode[1] + dy[i];

                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && !visited[nx][ny] && grid[nx][ny] == 1){
                    queue.add(new int[]{nx,ny});
                }



            }


        }





    }

    public static void dfs(int[][] grid, boolean[][] visited, int x, int y){


        visited[x][y] = true;
        for(int i=0; i<4; i++){

            int nx = x+dx[i];
            int ny = y+ dy[i];

            if(nx>=0 && nx<grid.length && ny >=0 && ny<grid[0].length && !visited[nx][ny] && grid[nx][ny] ==1 ){
                dfs(grid,visited,nx,ny);
            }



        }

    }

}

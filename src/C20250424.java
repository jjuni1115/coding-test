import javax.swing.plaf.IconUIResource;
import java.util.ArrayDeque;
import java.util.Deque;

public class C20250424 {

    private static int answer=0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args){


        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        solution(rectangle,characterX,characterY,itemX,itemY);

    }


    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {


        int answer = 0;

        boolean[][] map = new boolean[102][102];
        boolean[][] visited = new boolean[102][102];

        for(int[] r : rectangle){

            int x1 = r[0]*2;
            int x2 = r[2]*2;
            int y1 = r[1]*2;
            int y2 = r[3]*2;

            for(int i= x1; i<=x2; i++){
                map[y1][i]=true;
                map[y2][i]=true;
            }

            for(int i=y1; i<=y2; i++){
                map[i][x1]=true;
                map[i][x2]=true;
            }

        }


        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int x2 = r[2]*2;
            int y1 = r[1]*2;
            int y2 = r[3]*2;

            for(int i=x1+1; i<x2; i++){
                for(int j= y1+1; j<y2; j++){
                    if(map[j][i]){
                        map[j][i]=false;
                    }
                }
            }




        }





        return bfs(visited,map,new int[]{itemX*2,itemY*2}, new int[]{characterX*2,characterY*2});
    }

    public static int bfs(boolean[][] visited, boolean[][] map, int[] start, int[] target){



        int dist = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{start[0],start[1],dist});

        while (!queue.isEmpty()){

            int[] node = queue.poll();
            visited[node[1]][node[0]]=true;


            if(node[0] == target[0] && node[1]==target[1]){
                return node[2]/2;
            }

            for(int i=0; i<4; i++){
                int x = node[0]+dy[i];
                int y = node[1]+dx[i];
                if(x<102 && x>=0 && y<102 && y>=0 && map[y][x] && !visited[y][x]){

                    queue.add(new int[]{x,y,node[2]+1});
                }
            }


        }

        return 0;

    }



}

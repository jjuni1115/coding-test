import java.util.ArrayDeque;
import java.util.Deque;

public class C20250428 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {


        int[][] gameboard = new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};

        int[][] table = new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};

        //int[][] gameboard = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};

        //int[][] table = new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};




        System.out.println(solution(gameboard, table));

    }


    public static int solution(int[][] game_board, int[][] table) {


        int answer = 0;

        boolean[][] visited = new boolean[table.length][table[0].length];

        List<Diagram> boardList = new ArrayList<>();
        List<Diagram> tableList = new ArrayList<>();


        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[j][i] == 1 && !visited[j][i]) {
                    tableList.add(bfs(visited, new int[]{i, j}, table, 1));
                }
            }
        }

        visited = new boolean[game_board.length][game_board[0].length];

        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (game_board[j][i] == 0 && !visited[j][i]) {

                    boardList.add(bfs(visited, new int[]{i, j}, game_board, 0));


                }
            }
        }

        for(Diagram board : boardList) {


            for (Diagram tableDiagram : tableList) {

                if(board.useYn){
                    break;
                }

                if (tableDiagram.useYn) {
                    continue;
                }

                if (tableDiagram.size == board.size) {
                    for (int i = 0; i < 4; i++) {
                        tableDiagram.piece = rotate(tableDiagram.piece);
                        int temp = compare(board.piece, tableDiagram.piece, board.size);
                        if (temp == board.size) {
                            board.useYn = true;
                            tableDiagram.useYn = true;
                            answer+=temp;
                            break;
                        }
                    }
                }


            }
        }





        return answer;

    }


    public static Diagram bfs(boolean[][] visited, int[] start, int[][] board, int target) {

        int dist = 0;

        List<int[]> corList = new ArrayList<>();

        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{start[0], start[1]});

        corList.add(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            dist++;
            for (int i = 0; i < 4; i++) {

                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x < visited.length && y < visited.length && x >= 0 && y >= 0 && board[y][x] == target && !visited[y][x]) {

                    queue.add(new int[]{x, y});
                    visited[y][x]=true;
                    corList.add(new int[]{x, y});

                }

            }

        }

        Diagram diagram = new Diagram(dist,normalization(corList));



        return diagram;

    }

    public static int compare(int[][] board, int[][] table, int size){

        if(board.length != table.length || board[0].length != table[0].length){
            return 0;
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != table[i][j]){
                    return 0;
                }
            }
        }

        return size;


        /*Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int dist = 0;


        int[] start = new int[2];

        for(int i=0;i<board.length;i++){
                if(board[i][0] == 1){
                    start[0]=0;
                    start[1]=i;
                    break;
                }
        }

        if(table[start[1]][start[0]]==0){
            return 0;
        }

        queue.add(start);

        while (!queue.isEmpty()){

            int[] node = queue.poll();
            visited[node[1]][node[0]]=true;
            dist++;

            for(int i=0;i<4;i++){
                int x = node[0]+dx[i];
                int y = node[1]+dy[i];

                if(x>=0 && x<board[0].length && y>=0 && y< board.length && board[y][x]==1 && !visited[y][x]){

                    if(x>=table[0].length || y>=table.length || table[y][x]!=1){
                        dist=0;
                        return dist;
                    }

                    queue.add(new int[]{x,y});
                }

            }

        }

        return dist;*/


    }


    public static int[][] rotate(int[][] matrix) {
        int[][] rotateMatrix = new int[matrix[0].length][matrix.length];

        List<int[]> cordList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotateMatrix[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(rotateMatrix[j][i]==1){
                    cordList.add(new int[]{i,j});
                }
            }
        }




        return normalization(cordList);
    }

    public static int[][] normalization(List<int[]> corList){

        Integer minX = Integer.MAX_VALUE;
        Integer minY = Integer.MAX_VALUE;
        Integer maxX = Integer.MIN_VALUE;
        Integer maxY = Integer.MIN_VALUE;

        for(int[] cor : corList){
            minX = Math.min(minX,cor[0]);
            minY = Math.min(minY,cor[1]);
            maxX = Math.max(maxX,cor[0]);
            maxY = Math.max(maxY,cor[1]);
        }


        int[][] diagram = new int[maxY-minY+1][maxX-minX+1];

        for (int[] cor : corList){
            diagram[cor[1] - minY][cor[0]-minX] = 1;
        }


        return diagram;




    }


    public static class Diagram {
        public int size;
        public int[][] piece;
        public boolean useYn;

        public Diagram(int size, int[][] piece){
            this.size = size;
            this.piece = piece;
            this.useYn=false;
        }

    }


}

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

        int[][] new_game_board = new int[game_board.length][game_board[0].length];

        for(int i=0; i<game_board.length; i++){
            for (int j =0; j<game_board[0].length; j++){
                if(game_board[i][j]==1){
                    new_game_board[i][j]=0;
                }else{
                    new_game_board[i][j]=1;
                }
            }
        }


        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[j][i] == 1 && !visited[j][i]) {
                    bfs(visited, new int[]{i, j}, table, 1);
                }
            }
        }

        visited = new boolean[game_board.length][game_board[0].length];

        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (new_game_board[j][i] == 1 && !visited[j][i]) {

                    bfs(visited, new int[]{i, j}, new_game_board, 1);


                }
            }
        }


        for(int i=0; i< table.length; i++){
            for (int j=0; j<table[0].length; j++){
                if(new_game_board[j][i]>0){

                    for(int k=0; k<3; k++) {

                        boolean[][] board_visited = new boolean[new_game_board.length][new_game_board[0].length];

                        int size = compare(new_game_board, rotate(table), new int[]{i, j}, new_game_board[j][i], board_visited);
                        if(size>0){
                            answer+=size;
                            break;
                        }
                    }
                }
            }
        }


        return answer;

    }


    public static int bfs(boolean[][] visited, int[] start, int[][] board, int target) {

        int dist = 0;

        List<int[]> corList = new ArrayList<>();

        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{start[0], start[1]});

        corList.add(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            visited[node[1]][node[0]] = true;
            dist++;
            for (int i = 0; i < 4; i++) {

                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x < visited.length && y < visited.length && x >= 0 && y >= 0 && board[y][x] == target && !visited[y][x]) {

                    queue.add(new int[]{x, y});
                    corList.add(new int[]{x, y});

                }

            }

        }

        int finalDist = dist;
        corList.forEach(cor -> {
            board[cor[1]][cor[0]] = finalDist;
        });

        return dist;

    }


    public static int compare(int[][] gameBoard, int[][] table, int[] start1, int size,boolean[][] visited) {


        Deque<int[]> queue1 = new ArrayDeque<>();

        Deque<int[]> queue2 = new ArrayDeque<>();

        List<int[]> corList = new ArrayList<>();


        int score =0;

        for(int i=0; i< table.length; i++){
            for (int j=0; j<table[0].length; j++){
                if(table[j][i]== size){
                    queue2.add(new int[]{i,j});
                    break;
                }
            }
        }


        queue1.add(new int[]{start1[0], start1[1]});

        while (!queue1.isEmpty() && !queue2.isEmpty()) {


            int[] node1 = queue1.poll();

            visited[node1[0]][node1[1]]=true;

            score++;

            int[] node2 = queue2.poll();

            for (int k = 0; k < 3; k++) {
                int x1 = node1[0] + dx[k];
                int y1 = node1[1] + dy[k];

                int x2 = node2[0] + dx[k];
                int y2 = node2[1] + dy[k];

                if (x1 >= 0 && x1 < gameBoard.length && y1 >= 0 && y1 < gameBoard.length && gameBoard[y1][x1] == size && !visited[y1][x1]) {


                    if (x2 < 0 || x2 >= table.length || y2 < 0 || y2 >= table.length || table[y2][x2] != size) {
                        return 0;
                    }
                    queue1.add(new int[]{x1,y1});
                    queue2.add(new int[]{x2,y2});
                    corList.add(new int[]{x2,y2});

                }


            }


        }


        for (int[] ints : corList) {
            table[ints[1]][ints[0]]=-1;
        }

        return score;


    }

    public static int[][] rotate(int[][] matrix) {
        int[][] rotateMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotateMatrix[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }


        return rotateMatrix;
    }


}

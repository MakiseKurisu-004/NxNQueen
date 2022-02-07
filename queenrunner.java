public class queenrunner {
    public static void reset(int [][] b){
        for(int r=0; r<b.length; r++){
            for(int c=0; c<b[r].length; c++){
                b[r][c] = 0;
            }
        }
    }

    public static void display(int [][] b){
        for(int r=0; r < b.length; r++){
            for(int c=0; c < b[r].length; c++){
                System.out.print(b[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static boolean is_safe(int [][] board, int current_row, int current_col){
        for(int c = current_col; c>=0;c--){
            if(board[current_row][c]==1){
                return false;
            }
        }
        for(int c = current_col, r = current_row; c>=0 && r>=0;c--,r--) {
            if (board[r][c] == 1) {
                return false;
            }
        }
        for(int c = current_col, r = current_row; c>=0 && r<board.length;c--,r++){
            if(board[r][c]==1)
                return false;
        }
        return true;
    }

    public static boolean placeQueen(int [][]board, int n){
        if(n >= board[0].length){
            printSolution(board);
        }
        else{
            for(int r = 0; r <board.length; r++){
                if(is_safe(board,r,n)){
                    board[r][n] =1;
                    if(placeQueen(board, n+1)) {
                        return true;
                    }
                    else{
                        board[r][n] = 0;
                    }
                }
            }
        }
        return false;
    }

    public static void printSolution(int[][] board){
        System.out.print("[ ");
        for(int c=0; c<board[0].length; c++){
            for(int r=0; r<board.length;r++){
                if(board[r][c] == 1){
                    System.out.print(r + " ");
                }
            }
        }
        System.out.println("]");

    }

    public static int [] saveSolution(int [][]board, int dimension){
        int []solution = new int [dimension];
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 0; r < board.length; r++) {
                if(board[r][c]==1){
                    solution[c] = r;
                }
            }
        }
        return solution;
    }

    public static void main(String [] args){
        int dimension = 5;
        int [][] board = new int [dimension][dimension];
        reset(board);
        placeQueen(board,0);
    }
}

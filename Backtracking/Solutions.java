// Online Java Compiler (Editor)
// Write and run Java online using this editor.

class Main {
    public static void main(String[] args) {
        System.out.println("Solution start");
        
        // printPermutation("abcd","");
        
        // printSubset("abc", "", 0);
        
        // NQueen.nQueen(new int[5][5], 0);
        // System.out.println("Total Solution:" + NQueen.totalSolution);
        
        // GridWay.gridWays(new int[3][3], 0, 0);
        // System.out.println("Total Solution:" + GridWay.totalGridWays);
        
        System.out.println("Solution end");
        
    }

    // Grid ways
    class GridWay{
        public static int totalGridWays = 0;
        public static void gridWays(int[][] grid, int i, int j){
            int n = grid.length;
            if(i == n-1 && j == n-1){
                grid[i][j] =1;
                print2D(grid);
                totalGridWays++;
                return;
            }
            
            // Right Move
            if(j+1 < n)
            {
                grid[i][j+1] = 1;
                gridWays(grid, i, j+1);
                grid[i][j+1] = 0;
            }

            // Down Move
            if(i+1 < n){
                grid[i+1][j] = 1;
                gridWays(grid, i+1, j);
                grid[i+1][j] = 0;
            }
        }
    }

    
    // N Queen
    class NQueen{
        public static int totalSolution = 0;
        public static void nQueen(int[][] board, int i){
            int n = board.length;
            if(i >= n){
                totalSolution++;
                print2D(board);
                return;
            }
            for(int j=0;j<n;j++){
                if(isSafe(board,i,j)){
                    board[i][j] = 1;
                    nQueen(board, i+1);
                    board[i][j] = 0;
                }
            }
        }

        public static boolean isSafe(int[][] board, int i, int j){
            int n = board.length;
            int count = 1;
            // diagonal check
            while(i-1 >= 0){
                // left diadonal
                if(j-count>=0 && board[i-1][j-count] == 1){
                    return false;
                }
    
                // right diagonal
                if(j+count<n && board[i-1][j+count] == 1){
                    return false;
                }
    
                // vertical
                if(board[i-1][j] == 1){
                    return false;
                }
    
                i--;
                count++;
            }
    
            return true;
        }
    }

    // Print 2D Array
    public static void print2D(int[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            
            System.out.println();
        }
        System.out.println();
    }
    
    // Find Permutation
    public static void printPermutation(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i<str.length(); i++){
            String newStr = str.substring(0, i)+str.substring(i+1, str.length());
            printPermutation(newStr, ans+str.charAt(i));
        }
    }

    // Find Subset
    public static void printSubset(String str, String newStr, int i){
        if(str.length() <= i){
            if (newStr == ""){
                newStr="null";
            }
            System.out.println(newStr);
            return;
        }
        
        String aunga = newStr+str.charAt(i);
        printSubset(str, aunga, i+1);
        String nhiAunga = newStr;
        printSubset(str, nhiAunga, i+1);
    }

}

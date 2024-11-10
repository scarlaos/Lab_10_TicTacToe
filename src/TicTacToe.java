import  java.util.Scanner;
public class TicTacToe {
    private static final int ROWS =3;
    private static final int COLS = 3;
    private static String board[][] = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        clearBoard();
        while (!done)
        {
            clearBoard();
            int playerNow = 0;
            boolean gameOver = false;
            while (!gameOver) {
                display();
                int move = SafeInput.getRangedInt(in, "Player " + (playerNow == 0 ? "X" : "O") + " make your move, ", 1, 9);

                boolean isMoveValid = movePlace(move, playerNow == 0 ? "X" : "O");
                if (!isMoveValid) {
                    System.out.println("This spot has already been taken! ");
                    continue;
                }
                if (isWin(playerNow == 0 ? "X" : "O")) {
                    display();
                    System.out.println("Player " + (playerNow == 0 ? "X" : "O") + " Wins!");
                    break;
                }
                if (isTie()) {
                    display();
                    System.out.println("The game is a tie! ");
                    break;
                }
                playerNow = (playerNow + 1) % 2;

            }
            boolean repeat = SafeInput.getYN(in, "Would you like to continue? (Y/N)");

            if (!repeat) {
                done = true;
            }
        }
    }
    private static void display(){
        for(int e = 0; e < ROWS; e++){
            for (int i = 0; i < COLS; i++){
                if(board[e][i] == null){
                    board[e][i] = " ";
                }
            }
        }

        for(int e = 0; e < ROWS; e++)
        {
            for(int i = 0; i < COLS; i++)
            {
                System.out.print(board[e][i]);
                if(i<COLS - 1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(e<ROWS - 1){
                System.out.println("---------");
            }

        }
    }
    private static boolean movePlace(int move, String player)
    {
        int row = (move - 1) / COLS;
        int col = (move - 1) % COLS;

        if(board[row][col].equals(" ")){
            board[row][col] = player;
            return true;
        }
        return false;
    }
    private static void clearBoard(){
        for(int i = 0; i < ROWS; i++){
            for(int e = 0; e < COLS; e++){
                board[i][e] = " ";
            }
        }
    }
    private static boolean isWin(String player){
        for(int e = 0; e < ROWS; e++) { // rows
            if (board[e][0].equals(player) && board[e][1].equals(player) && board[e][2].equals(player)) {
                return true;
            }
        }
        for(int e = 0; e < COLS; e++){ // cols
            if(board[0][e].equals(player) && board[1][e].equals(player) && board[2][e].equals(player)){
                return true;
            }
        } // diagonal
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
    private static boolean fullBoard(){
        for(int e = 0; e < ROWS; e ++){
            for(int i = 0; i < COLS; i++){
                if(board[e][i].equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isTie(){
        return fullBoard() && !isWin("X") && !isWin("O");
    }
}

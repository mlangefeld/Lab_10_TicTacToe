import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String currentPlayer;
        boolean playAgain = false;
        int git;


        do {

            clearBoard();
            display();
            currentPlayer = "X";

            while (true){

                System.out.println("Player " + currentPlayer + ", enter your move");

                int row = SafeInput.getRangedInt(in, "Enter your row move", 1, 3);
                int col = SafeInput.getRangedInt(in, "Enter your colum move", 1, 3);

                row--;
                col--;

                if (isValidMove(row , col )){
                    board[row][col] = currentPlayer;
                    display();

                    if (isWin(currentPlayer)){
                        System.out.println("Congratulations! " + currentPlayer + " wins!");
                        break;

                    } else if (isTie()) {
                        System.out.println("Its a tie!");
                        break;

                    }

                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                }else {
                    System.out.println("Invalid move");
                }

            }


            playAgain = SafeInput.getYNConfirm(in, "Would you like to play again? [Y,N]: ");

        }while (playAgain);

    }

    private static void clearBoard(){
        for (int x = 0; x < ROW; x++){

            for (int y = 0; y < COL; y++){

                board[x][y] = " ";
            }
        }

    }

    private static void display(){

        System.out.println("-------------");
        for (int x = 0; x < ROW; x++){

            for (int y = 0; y < COL; y++){

                System.out.print("| " + board[x][y] + " ");
            }

            System.out.println("|");

            System.out.println("-------------");
        }

    }

    private static boolean isValidMove(int row, int col) {
        if (row >= 0 && row < ROW && col >= 0 && col < COL) {

            return board[row][col].equals(" ");
        }
        return false;
    }

    private static boolean isWin(String player){

        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);

    }

    private static boolean isColWin(String player){

        for (int x = 0; x < COL; x++){

            if (board[0][x].equals(player) && board[1][x].equals(player) && board[2][x].equals(player)){

                return true;
            }
        }

        return false;

    }

    private static boolean isRowWin(String player){

        for (int x = 0; x < ROW; x++){

            if (board[x][0].equals(player) && board[x][1].equals(player) && board[x][2].equals(player)){

                return true;
            }
        }

        return false;

    }

    private static boolean isDiagonalWin(String player){

        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));

    }

    private static boolean isTie(){

        for(int x = 0; x < ROW; x++){

            for (int y = 0; y < COL; y++){

                if (board[x][y].equals(" ")){

                    return false;
                }
            }
        }

        return true;

    }
}

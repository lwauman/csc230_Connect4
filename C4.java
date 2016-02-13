/*
 * Author: Lucas Auman
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

public class C4 extends Game{
    private int[][] board;
    private final int COLS, ROWS;
    private boolean allowNextTurn = true; //used to control if nextTurn() is allowed. See playPiece()
    
    //Constructor. Initializes variables and sets up 2d array
    public C4(){
        super("Connect Four", 2);
        COLS = 7;
        ROWS = 6;
        board = new int[ROWS][COLS];
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                board[i][j] = 0;
            }
        }
    }
    //sets all values of the array to 0
    private void clearBoard(){
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                board[i][j] = 0;
            }
        }
    }
    //returns 1, 2, or 0 from the array at the parameter location
    public int getPiece(int row, int col){
        return board[row][col];
    }
    //returns 1 or 2 which indicates which player's turn it is
    public int getTurn(){
        return super.currentTurn();
    }
    //checks to see if row 0 of the parameter column contains 1 or 2. If so returns true
    public boolean isColFull(int col){
        return board[0][col] != 0;
    }
    //breaks the board up into 4 quadrants and check for diagnal win conditions
    private boolean isDiagWinner(){
        for(int col=0; col<7; col++){
            //I increment the rows first as a matter of preference
            for(int row=0; row<6; row++){
                //upper left quadrant
                if(row<3 && col<4){
                    if(board[row][col] == super.currentTurn() 
                        && board[row+1][col+1] == super.currentTurn()
                        && board[row+2][col+2] == super.currentTurn() 
                        && board[row+3][col+3] == super.currentTurn())
                        return true;
                }
                //upper right quadrant
                else if(row<3 && col>=4){
                    if(board[row][col] == super.currentTurn() 
                        && board[row+1][col-1] == super.currentTurn()
                        && board[row+2][col-2] == super.currentTurn() 
                        && board[row+3][col-3] == super.currentTurn())
                        return true;
                }
                //bottom left quadrant
                else if (row>=3 && col<4){
                    if(board[row][col] == super.currentTurn() 
                        && board[row-1][col+1] == super.currentTurn()
                        && board[row-2][col+2] == super.currentTurn() 
                        && board[row-3][col+3] == super.currentTurn())
                        return true;
                }
                //bottom right quadrant
                else{
                    if(board[row][col] == super.currentTurn() 
                        && board[row-1][col-1] == super.currentTurn()
                        && board[row-2][col-2] == super.currentTurn() 
                        && board[row-3][col-3] == super.currentTurn())
                        return true;
                }
                
            }
        }
        return false;
    }
   //checks if there are any 0s in on the board. If so returns false
    public boolean isFull(){
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(board[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
    //checks for any horizontal win conditions
    private boolean isHorizWinner(){
        //col stops <4 due to the fact that 3 is added to it. This avoids
        //out of bound errors
        for(int col=0; col<4; col++){
            for(int row=0; row<6; row++){
                if(board[row][col] == super.currentTurn()
                        && board[row][col+1] == super.currentTurn()
                        && board[row][col+2] == super.currentTurn()
                        && board[row][col+3] == super.currentTurn())
                    return true;
            }
        }
        return false;
    }
    //checks for any vertical win conditions
    private boolean isVertWinner(){
        for(int col=0; col<7; col++){
            //row stops at < 3 due to the fact that 3 is added to it. This avoids
            //out of bound errors
            for(int row=0; row<3; row++){
                if(board[row][col] == super.currentTurn()
                        && board[row+1][col] == super.currentTurn()
                        && board[row+2][col] == super.currentTurn()
                        && board[row+3][col] == super.currentTurn())
                    return true;
            }
        }
        return false;
    }
    /*
    This checks for all winning conditions. If any are true it displays 
    winner message, clears the board in preperation for another game
    are returns control to MyGame class in order to see if players want another game
    */
    public boolean isWinner(){
        if(isDiagWinner()){
            printBoard();
            super.winner();
            clearBoard();
            return true;
        }
        else if(isHorizWinner()){
            printBoard();
            super.winner();
            clearBoard();
            return true;
        }
        else if(isVertWinner()){
            printBoard();
            super.winner();
            clearBoard();
            return true;
        }
        else if(isFull()){
            printBoard();
            System.out.println("After " +super.getTries()+" the game ended "
                    + "in a draw.");
            clearBoard();
            return true;
        }
        else{
            return false;
        }
    }
    //switched turns if allowNextTurn is true. allowNextTurn is false if something
    //went wrong during playPiece() in order to avoid players having their turns
    //skipped
    public void nextTurn(){
        if(allowNextTurn)
            super.next();
    }
    //this method plays a piece in the column provided by user. First it checks
    //if that column is full. If not plays the piece and if it is it asks for another
    //column and sets allowNextTurn to false to avoid switching to the next player.
    public void playPiece(int col){
        if(isColFull(col)){
            System.out.println("That column is full. Please choose another column.");
            allowNextTurn = false;
        }
        else{
            allowNextTurn = true;
            for(int i=5; i>=0; i--){
                if(board[i][col] == 0){
                    board[i][col] = getTurn();
                    break;
                }
            }
        }
    }
    //This metod simply prints the 2d array with a fram around it
    public void printBoard(){
        System.out.println(" ---------------");
        for (int i = 0; i < ROWS; i++) {
            System.out.print("| ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println(" ---------------");
    }
    //this method is used at the end of the game. It resolves the issue of player2
    //being the first player of a new game if player 1 was the last to play a piece.
    public void setToPlayer1(){
        if(super.currentTurn() == 2)
            nextTurn();
    }
    
}   

    

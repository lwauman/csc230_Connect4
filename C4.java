/*
 * Author: Lucas Auman
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

public class C4 extends Game{
    private int[][] board;
    private final int COLS, ROWS;
    
    public C4(){
        super("Connect4", 2);
        COLS = 7;
        ROWS = 6;
        board = new int[ROWS][COLS];
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                board[i][j] = 0;
            }
        }
    }
    
    private void clearBoard(){
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                board[i][j] = 0;
            }
        }
    }
    
    public int getPiece(int row, int col){
        return board[row][col];
    }
    
    public int getTurn(){
        return super.currentTurn();
    }
    
    public boolean isColFull(int col){
        if(board[0][col] != 0){
            return true;
        }
        else
            return false;
    }
    
    private boolean isDiagWinner(){
        for(int col=0; col<7; col++){
            for(int row=0; row<6; row++){
                if(row<3 && col<4){
                    if(board[row][col] == super.currentTurn() 
                        && board[row+1][col+1] == super.currentTurn()
                        && board[row+2][col+2] == super.currentTurn() 
                        && board[row+3][col+3] == super.currentTurn())
                        return true;
                }
                else if(row<3 && col>=4){
                    if(board[row][col] == super.currentTurn() 
                        && board[row+1][col-1] == super.currentTurn()
                        && board[row+2][col-2] == super.currentTurn() 
                        && board[row+3][col-3] == super.currentTurn())
                        return true;
                }
                else if (row>=3 && col<4){
                    if(board[row][col] == super.currentTurn() 
                        && board[row-1][col+1] == super.currentTurn()
                        && board[row-2][col+2] == super.currentTurn() 
                        && board[row-3][col+3] == super.currentTurn())
                        return true;
                }
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
    
    private boolean isHorizWinner(){
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
    
    private boolean isVertWinner(){
        for(int col=0; col<7; col++){
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
    
    public void nextTurn(){
        super.next();
    }
    
    public void playPiece(int col){
        if(isColFull(col)){
            System.out.println("That column is full. Please choose another column.");
        }
        else{
            for(int i=5; i>=0; i--){
                if(board[i][col] == 0){
                    board[i][col] = getTurn();
                    nextTurn();
                    break;
                }
            }
        }
    }
    
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
    
}    
        
    

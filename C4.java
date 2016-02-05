/*
 * Author: 
 * Program 1 - MyString
 * CSC230-02 Spring 2016
 */

public class C4 extends Game{
    private int[][] board;
    final int COLS, ROWS;
    
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
        
    }
    public void playPiece(int col){
        if(isColFull(col)){
            System.out.println("That column is full. Please choose another column.");
        }
        else{
            for(int i=5; i>=0; i--){
                if(board[i][col] == 0){
                    board[i][col] = getTurn();
                    break;
                }
            }
        }
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
    
    public void nextTurn(){
        super.next();
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
        
    

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Author: Lucas Auman
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */


public class MyGame {

    public static void main(String[] args) {
        C4 c4 = new C4();
        Scanner kb = new Scanner(System.in);
        char response = 'y'; //used to check if another game should be played
        boolean isWinner = false; //used to loop until a winner is found
        
        //this while loop keeps the game going until no is entered in 
        //response to being asked if they would like to play again
        while(response == 'y'){
            //while(!isWinner) keeps the turns switching until a win condition
            //is met
            while(!isWinner){
                //sucessPlayPiece is used to monitor if playPiece() was sucessful
                boolean sucessPlayPiece = false;
                c4.printBoard();
                System.out.print("Player " + c4.getTurn() +", please enter the "
                        + "column number (1-7) you would like to "
                        + "place your piece in: ");
                //this while loop continues until a piece is sucessfully played
                while(!sucessPlayPiece){
                    try{
                        //nextInt()-1 so that players don't have to think about
                        //array indexes
                        c4.playPiece(kb.nextInt()-1);
                        sucessPlayPiece = true;
                    }
                    //InputMismatch is used when something other than a number 
                    //is entered
                    catch(InputMismatchException e){
                        //clears the last endofline
                        kb.nextLine();
                        System.out.print("Invalid column. Please enter the "
                            + "column number (1-7) you would like to "
                            + "place your piece in: ");
                    }
                    //this is used when a number that isn't 1-7 is entered
                    catch(IndexOutOfBoundsException e){
                        System.out.print("Invalid column. Please enter the "
                            + "column number (1-7) you would like to "
                            + "place your piece in: ");
                    }
                    
                }
                //checks to see if there is a winner. also keeps the game looping
                //if false
                isWinner = c4.isWinner();
                c4.nextTurn();
            }//end while(!isWinner)
            
            //The code below is executed after a win condition is met
            System.out.print("Would you like to play again(y/n)? ");
            response = kb.next().toLowerCase().charAt(0);
            kb.nextLine();
            if(response == 'y'){
                //reset so while(!isWinner) on line 24 loop works
                isWinner=false; 
                //Line 71 fixes an issue where player 2 started first if player 1 
                //had the last move
                if(c4.getTurn()==2) 
                    c4.nextTurn();  
            }
            else if(response == 'n')
                System.exit(0);
            //the below else block is used when something other than y or n
            //was entered
            else{
                boolean stopLooping = false;
                //loops until a proper answer is given
                while(!stopLooping){
                    System.out.print("Would you like to play again(y/n)? ");
                    response = kb.next().toLowerCase().charAt(0);
                    kb.nextLine();
                    if(response == 'y' || response == 'n'){
                        stopLooping = true;
                        if(response == 'y'){
                            isWinner = false;
                            if(c4.getTurn()==2)
                                c4.nextTurn(); 
                        }
                        else
                            System.exit(0);
                    }   
                }
            }
        }
    } 
}

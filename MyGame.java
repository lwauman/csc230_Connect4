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
        char response = 'y';
        boolean isWinner = false;
        boolean controlFlow =false;
        
        //this while loop keeps the game going until no is entered in 
        //response to being asked if they would like to play again
        while(response == 'y'){
            //while(!isWinner) keeps the turn switching until a win condition
            //is met
            while(!isWinner){
                //sucessPlayPiece is used to monitor if playPiece() was sucessful
                boolean sucessPlayPiece = false;
                c4.printBoard();
                System.out.print("Player " + c4.getTurn() +", please enter the column number (1-7) you would like to "
                        + "place your piece in: ");
                while(!sucessPlayPiece){
                    try{
                        c4.playPiece(kb.nextInt()-1);
                        sucessPlayPiece = true;
                    }
                    catch(InputMismatchException e){
                        kb.nextLine();
                        System.out.print("Invalid column. Please enter the column number (1-7) you would like to "
                            + "place your piece in: ");
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.print("Invalid column. Please enter the column number (1-7) you would like to "
                            + "place your piece in: ");
                    }
                    
                }
                isWinner = c4.isWinner();
                c4.nextTurn();
            }
            System.out.print("Would you like to play again(y/n)? ");
            response = kb.next().toLowerCase().charAt(0);
                if(response == 'y'){
                    isWinner=false;
                    if(c4.getTurn()==2)
                        c4.nextTurn();
                }
            }
        } 
    }


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
        while(response == 'y'){
            do{
                c4.printBoard();
                System.out.print("Player " + c4.getTurn() +", please enter the column number you would like to "
                        + "place your piece in: ");
                c4.playPiece(kb.nextInt()-1);
        }while (c4.isWinner() == false);
        System.out.print("Would you like to play again(y/n)? ");
        response = kb.next().toLowerCase().charAt(0);
        }
        
        
        
    }
    
}

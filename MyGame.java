
import java.util.Scanner;

/*
 * Author: 
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */


public class MyGame {

    public static void main(String[] args) {
        C4 c4 = new C4();
        c4.printBoard();
        Scanner kb = new Scanner(System.in);
        do{
            System.out.print("Player " + c4.getTurn() +", please enter the column number you would like to "
                    + "place your piece in: ");
            c4.playPiece(kb.nextInt()-1);
            c4.printBoard();
        }while (c4.isWinner() == false);
        
    }
    
}

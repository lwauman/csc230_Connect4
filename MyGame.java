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
        while(response == 'y'){
            while(!isWinner){
                c4.printBoard();
                System.out.print("Player " + c4.getTurn() +", please enter the column number you would like to "
                        + "place your piece in: ");
                c4.playPiece(kb.nextInt()-1);
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
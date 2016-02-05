public class Game
{
  private String gameName;
  private int numPlayers;
  private int currPlayer;
  private int tries;
  
  public Game(String name, int players)
  {
    gameName = name;
    numPlayers = players;
    currPlayer = 1;
    tries = 0;
  }
  
  public String getName() { return gameName; }
  public int currentTurn() { return currPlayer; }
  
  public void next() {
    if (currPlayer == 1)
    {
      currPlayer = 2;
    }
    else
    {
      currPlayer = 1;
    }
    
    tries += 1;
  }
  
  public void winner() {
    System.out.println("Player " + currPlayer + " has won " + gameName + "!!!");
    System.out.println("The game took " + getTries() + " to finish.");
  }
  
  public int getTries()
  {
    return tries;
  }
}
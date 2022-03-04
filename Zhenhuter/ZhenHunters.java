import java.util.Scanner;

public class ZhenHunters
{
    public static void main(String[] args)
    {

        // Welcome the user to game
        System.out.println("Welcome to the Zhen Hunters game. ");
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Would you like to play the game type y for yes and n for no");
        if(myScanner.next().charAt(0) ==  'y')
        {

            // Created object of GameGrid
            GameGrid game = new GameGrid();
            game.setupGrid();
            game.displayGrid();

        }

    }

}//ZhenHunters

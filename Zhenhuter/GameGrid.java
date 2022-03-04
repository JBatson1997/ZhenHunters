import java.util.Scanner;

public class GameGrid
{
    // Field Member for GameGrid
    private int numRows;    // Number of rows on grid. Default size is 8.
    private int numCols;    //Number of columns on grid. Default size is 8.
    private GamePiece[][] grid;     //2-d array holding GamePiece objects. Size is numRows x numCols.
    private Player player1,player2;         //Player objects.
    private int numZhens;       //Number of zhens selected for play. Valid values: 16, 18, or 20 only.
    private int[] hunter1Coord;     //Current position of Hunter 1 on grid.
    private int[] hunter2Coord;     //Current position of Hunter 2 on grid.
    private int numHunters;         //Contains the number of Hunters still in play.



    public void setNumCols(int numCols)
    {
        this.numCols = numCols;
    }//Mutator

    public void setNumRows(int numRows)
    {
        this.numRows = numRows;
    }//Mutator

    public void setNumZhens(int numZhens)
    {
        this.numZhens = numZhens;
    }//Mutator

    public void setHunter1Coord(int[] hunter1Coord)
    {
        this.hunter1Coord = hunter1Coord;
    }//Mutator

    public void setHunter2Coord(int[] hunter2Coord)
    {
        this.hunter2Coord = hunter2Coord;
    }//Mutator

    public void setNumHunters(int numHunters)
    {
        this.numHunters = numHunters;
    }//Mutator

    public void setGrid(int r, int c,GamePiece g) {         //Mutator
        this.grid[r][c] = g;
    }

    public GamePiece getGrid(int r, int c) {
        return grid[r][c];
    }

    public int getNumCols() {return numCols; }              //Accessor
    public int getNumRows() {return numRows;}               //Accessor
    public int getNumZhens() {return numZhens;}             //Accessor
    public int getNumHunters() {return numHunters;}
    public int[] getHunter1Coord() {return hunter1Coord;}       //Accessor
    public int[] getHunter2Coord() {return hunter2Coord;}       //Accessor






    public GameGrid()
    {

        setNumRows(8);
        setNumCols(8);
        setNumHunters(2);
        setNumZhens(20);
        grid = new GamePiece[8][8];

    }// GameGrid constructor


    public boolean addGamePiece(GamePiece piece, int row, int col)
    {

        if (grid[row][col].getType().equals("?"))
        {
            setGrid(row,col,piece);

            return true;
        }
        return false;
    }// addGame Piece Method


    public void setupGrid()
    {

        player1 = new Player();
        player2 = new Player();
        // Prompt Player one to enter their name
        System.out.println("Enter player one name");
        Scanner myScanner = new Scanner(System.in);
        String hold = myScanner.nextLine();
        player1.setName(hold);


        System.out.println("Enter player two name");
        player2.setName(myScanner.nextLine());
        // Prompt Player two to enter their name

        System.out.println("Enter number of Zhen to play with");
        setNumZhens(myScanner.nextInt());
        // Prompt the player to enter the number of zhen they want to play with either 16,18,20.

        for (int i = 0; i < getNumRows(); i++)
        {
            for (int j = 0; j < getNumCols(); j++)
            {
                setGrid(i,j,new GamePiece());
            }
        }

        for (int i = 0; i < getNumRows(); i++)
        {
            for (int j = 0; j < getNumCols(); j++)
            {
                if ((i < 2 || i > 5) && (j < 2 || j > 5))
                {
                    grid[i][j] = new Bramble();
                }
            }
        }// Adding Brambles to the grid



        int zhenCounter = 0;
        for(int i= 0; i < getNumRows() && zhenCounter < 16; i++)
        {
            for (int a = 0; a < getNumCols() && zhenCounter < 16; a++)
            {
                if (getGrid(i,a).getSymbol() == '?')
                {
                    setGrid(i,a,new Zhen());
                    zhenCounter++;
                }
            }
        }

        if (numZhens >= 18)
        {
            addGamePiece(new Zhen(),3,0);
            addGamePiece(new Zhen(), 3,7);
        }

        if (numZhens >= 20)
        {
            addGamePiece(new Zhen(),4,0);
            addGamePiece(new Zhen(),4,7);
        } //Adding Zhen to the grid
        /*
        int[] h1Coord = {4,3};
        int[] h2Coord = {4,4};
        setHunter1Coord(h1Coord);
        setHunter2Coord(h2Coord);

        System.out.println("Player 1 enter the Symbol for your hunter piece");
        String huntSym = myScanner.next();
        char h = huntSym.charAt(0);
        Hunter h1 = (Hunter) getGrid(getHunter1Coord()[0],getHunter1Coord()[1]);
        h1.setSymbol(h);

        System.out.println("Player 2 enter the Symbol for your hunter piece");
        huntSym = myScanner.next();
        h = huntSym.charAt(0);
        Hunter h2 = (Hunter) getGrid(getHunter2Coord()[0],getHunter2Coord()[1]);
        h2.setSymbol(h);*/


        Hunter h1 = new Hunter();
        Hunter h2 = new Hunter();
        if(addGamePiece(h1,4,3))
        {
            int p[] = {4,3};
            setHunter1Coord(p);
            h1.setEnergyLevel(4);
        }
        if(addGamePiece(h2,4,4))
        {
            int p[] = {4,4};
            setHunter2Coord(p);
            h2.setEnergyLevel(4);
        } // Adding hunters to the grid

        System.out.println("Player 1 enter the Symbol for your hunter piece");
        String huntSym = myScanner.next();
        char h = huntSym.charAt(0);
        h1.setSymbol(h);

        System.out.println("Player 2 enter the Symbol for your hunter piece");
        huntSym = myScanner.next();
        h = huntSym.charAt(0);
        h2.setSymbol(h);
        // Asking the Players to enter the symbol for the hunter piece

    }// SetupGrid Method

    public void displayGrid()
    {
        System.out.println(" ... ... ... ... ... ... ... ...");
        for(int i = 0; i < 8; i++)
        {
            for (int a = 0; a < 8; a++)
            {
                if (a == 0)
                {
                    System.out.print("|");
                }
                if(getGrid(i,a).getSymbol() == '?')
                {
                    System.out.print("   |");
                }
                else
                    {
                    System.out.print(" " + getGrid(i,a).getSymbol() + " |");
                }
                if (a == getNumCols()-1)
                {
                    System.out.println();
                    System.out.println(" ... ... ... ... ... ... ... ...");
                }
            }
        }


        int e1 = -1;
        int e2 = -1;
        if (getGrid(getHunter1Coord()[0],getHunter1Coord()[1]) instanceof Hunter )
        {
             e1 = ((Hunter) getGrid(getHunter1Coord()[0],getHunter1Coord()[1])).getEnergyLevel();
        }
        if (getGrid(getHunter2Coord()[0],getHunter2Coord()[1]) instanceof Hunter )
        {
            e2 = ((Hunter) getGrid(getHunter2Coord()[0], getHunter2Coord()[1])).getEnergyLevel();
        }
        System.out.println();
        System.out.println("Hunter "+ getGrid(getHunter1Coord()[0],getHunter1Coord()[1]).getSymbol() +" energy: "+ e1);
        System.out.println("Hunter "+ getGrid(getHunter2Coord()[0],getHunter2Coord()[1]).getSymbol() +" energy: " + e2);
        System.out.println("Number of Zhen: "+ numZhens);
        // output for the Hunter1,Hunter2 and Num of Zhens

    }// DisplayGrid method

    public void displayMovementOptions(int player)
    {
        if(player == 1)
        {
            System.out.println("You are a hunter and these are your movement options");
            System.out.println("1 - North       2 - South       3 - East        4 - West");
            System.out.println("5 - NorthWest       6 - SouthWest       7 - SouthEast        8 - NorthEast");
            System.out.println("9 - eatNorth       10 - eatWest       11 - eatSouth      12 - eatEast");
        }
        else
        {
            if(player == 2)
            {
                System.out.println("You are a Zhen and these are your movement options");
                System.out.println("1 - North       2 - South       3 - East        4 - West");
            }
        }

    }

    boolean validateMove(int row, int col) throws EdgeException, CrowdingException
    {
        if(row > 7 || row < 0 || col > 7 || col < 0)
        {
            throw new EdgeException();
        }
        else
            if ( grid[row][col] != null)
            {
                throw new CrowdingException();
            }
            return true;
    }

    boolean isZhenPosition(int rowPos, int colPos)
    {
        if ((grid[rowPos][colPos]) instanceof Zhen)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    boolean removePiece(int rowPos, int colPos)
    {
        if(grid[rowPos][colPos] instanceof Zhen)
        {
            grid[rowPos][colPos] = null;
            return true;
        }
        else
        {
            return false;
        }
    }

    


}//GameGrid

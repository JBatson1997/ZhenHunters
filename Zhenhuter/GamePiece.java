public class GamePiece
{
    private String type;   //Contains the type of the game piece. The descriptor will be a word.
    private char symbol;   //Contains the character which will be used to represent the game piece on the grid.
    private int rowPos;     //Contains row in which game piece is positioned
    private int colPos;     //Contains column in which game piece is positioned.


    public GamePiece()  //Constructor used to initialize type to “?” and symbol to ‘?’.
    {
        type = "?";
        symbol = '?';
    }//GamePiece Constructor

    public void setType(String t){
        type = t;
    }           //Mutator

    public void setSymbol(char s){
        symbol = s;
    }          //Mutator

    public void setRowPos(int r)
    {
        rowPos = r;
    }//Mutator

    public void setColPos(int c)
    {
        colPos = c;
    }//Mutator

    public String getType(){return type;}               //Accessor
    public char getSymbol(){return symbol;}             //Accessor
    public int getRowPos(){return rowPos;}              //Accessor
    public int getColPos(){return colPos;}             //Accessor


}//GamePiece

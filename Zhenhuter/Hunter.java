public class Hunter extends GamePiece implements ControlActions, EatingActions
{
    private int energyLevel;
    private final int MAXENERGY = 6;
    private char hName;
    private int findNewPos[];
    int timesNotEaten;


    public Hunter()             //Constructor used to initialize type to “hunter” and symbol to ‘H’.
    {

        setType("Hunter");
        setSymbol('H');
        findNewPos = new int[2];
    }//Hunter Constructor

    public void setHName(char n){
        hName = n;
    }       //Mutator
    public char getHName(){return hName;}             //Accessor

    public void setEnergyLevel(int e){
        energyLevel = e;
    }       // Mutator

    public int getEnergyLevel(){return energyLevel;}            //Accessor

    public void setFindNewPos(int x,int y)
    {
        findNewPos[0] = getFindNewPos()[0] +x;
        findNewPos[1] = getFindNewPos()[1] +y;
    }

    public int[] getFindNewPos()
    {
        return findNewPos;
    }



    public int[] findNewPos(int direction)
    {
        final int North = 1;
        final int South = 2;
        final int East = 3;
        final int West = 4;
        final int NorthWest = 5;
        final int SouthWest = 6;
        final int SouthEast = 7;
        final int NorthEast = 8;
        final int eatNorth = 9;
        final int eatWest = 10;
        final int eatSouth = 11;
        final int eatEast = 12;



        if(direction == North)
        {
            setFindNewPos(0,-1);
            return getFindNewPos();
        }
        if(direction == South)
        {
            setFindNewPos(0,+1);
            return getFindNewPos();
        }
        if(direction == East)
        {
            setFindNewPos(+1,0);
            return getFindNewPos();
        }
        if(direction == West)
        {
            setFindNewPos(-1,0);
            return getFindNewPos();
        }
        if(direction == NorthWest)
        {
            setFindNewPos(-1,-1);
            return getFindNewPos();
        }
        if(direction == SouthWest)
        {
            setFindNewPos(-1,+1);
            return getFindNewPos();
        }
        if(direction == SouthEast)
        {
            setFindNewPos(+1,+1);
            return getFindNewPos();
        }
        if(direction == NorthEast)
        {
            setFindNewPos(+1,-1);
            return getFindNewPos();
        }
        if (direction == eatNorth)
        {
            setFindNewPos(0,-1);
            return getFindNewPos();
        }
        if (direction == eatWest)
        {
            setFindNewPos(-1,0);
            return getFindNewPos();
        }
        if (direction == eatSouth)
        {
            setFindNewPos(0,+1);
            return getFindNewPos();
        }
        if (direction == eatEast)
        {
            setFindNewPos(+1,0);
            return getFindNewPos();
        }


        return getFindNewPos();
    }


    public void moveToNewPos(int direction)
    {
        int[] prevPos = {getRowPos(),getColPos()};

        setRowPos(findNewPos(direction)[0]);
        setColPos(findNewPos(direction)[1]);
    }


    @Override
    public void eatWest() {

    }

    @Override
    public void eatEast() {

    }

    @Override
    public void eatNorth() {

    }

    @Override
    public void eatSouth() {

    }
}//Hunter

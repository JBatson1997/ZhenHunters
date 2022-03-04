public class Zhen extends GamePiece implements ControlActions{

   private int[] findNewPos;


    public Zhen()
    {
        setType("zhen");
        setSymbol('Z');
        findNewPos = new int[2];
    }//Constructor used to initialize type to "bramble" and symbol to '*'.


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

       return getFindNewPos();
    }


    public void moveToNewPos(int direction)
    {
        int[] prevPos = {getRowPos(),getColPos()};

        setRowPos(findNewPos(direction)[0]);
        setColPos(findNewPos(direction)[1]);


    }

}//Zhen
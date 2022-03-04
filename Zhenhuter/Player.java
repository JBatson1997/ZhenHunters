public class Player
{
    private  String name;           //Contains the name of the player.


    public Player()
    {
        setName(" ");
    }//Constructor Player

    public void setName(String n) {     //Mutator
        name = n;
    }   //Mutator

    public String getName() {
        return name;
    }       //Accessor
}//Player

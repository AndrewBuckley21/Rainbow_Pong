import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pong1 extends Counter
{
    public int y = 275;
    public int color1;
    public Pong1()
    {
        setImage( new GreenfootImage( "whitePong.png" ) );//sets the original color of the first player to be white
    }
    public void act() 
    {
       player1();
       changeColor();
    }
    
    //controls the movement of player 1
    public void player1() 
    {
        //moves player 1 upward if the "w" key is pressed
        if ( Greenfoot.isKeyDown( "w" ) )
        {
            y = getY() - 3;
        }
        //moves player 2 downward if the "ws key is pressed
        if ( Greenfoot.isKeyDown( "s" ) )
        {
            y = getY() + 3;
        }
        setLocation( getX(), y );
    }
    
    //changes the color of the player
    public void changeColor()
    {
        color1 = Greenfoot.getRandomNumber( 9 );
        switch ( color1 )
        {
            case 0:
                setImage( "blackPong.png" );
                break;
            case 1:
                setImage( "whitePong.png" );
                break;
            case 2:
                setImage( "yellowPong.png" );
                break;
            case 3:
                setImage( "redPong.png" );
                break;
            case 4:
                setImage( "bluePong.png" );
                break;    
            case 5:
                setImage( "lightBluePong.png" );
                break;    
            case 6:
                setImage( "purplePong.png" );
                break;    
            case 7:
                setImage( "orangePong.png" );
                break;    
            case 8:
                setImage( "greenPong.png" );
                break;       
        }
    }
}

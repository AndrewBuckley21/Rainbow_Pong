import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Pong2 extends Counter
{
    public int y = 275;
    public int color2;
    public Pong2()
    {
        setImage( new GreenfootImage( "whitePong.png" ) );
    }
    public void act() 
    {
        player2();
        changeColor();
    }
    
    //controls the movement of player 1
    public void player2() 
    {
        //moves player 2 upward if the up arrow is pressed
        if ( Greenfoot.isKeyDown( "up" ) )
        {
            y = getY() - 3;
        }
        //moves player 2 downward if the down arrow is pressed
        if ( Greenfoot.isKeyDown( "down" ) )
        {
            y = getY() + 3;
        }
        setLocation( getX(), y );
    }
    public void changeColor()
    {
        color2 = Greenfoot.getRandomNumber( 9 );
        switch ( color2 )
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


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
public class PongWorld extends World
{
    public PongWorld()
    {    
        super(550, 550, 1);
        populate();
        
        //Sets thw world color to black
        GreenfootImage background = getBackground();
        background.setColor( Color.BLACK );
        background.fill();
    }
    
    //When a player reaches 5 points, a winner message is displayed
    public void act()
    {
        if ( Score1.score1 >= 5 )
        {
            addObject( new Winner1(), 275, 275 );
            addObject( new Close1(), 275, 320 );
        }
        if ( Score2.score2 >= 5 )
        {
            addObject( new Winner2(), 275, 275 );
            addObject( new Close2(), 275, 320 );
        }
    }
        
    //adds all of the components to the world
    public void populate()
    {
        addObject( new Pong1(), 50, 275 );
        addObject( new Pong2(), 500, 275 );
        addObject( new Score1(), 40, 20 );
        addObject( new Score2(), 510, 20 );
        addObject( new Ball(), 275, 275 );
    }
}

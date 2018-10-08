import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Movement extends Counter
{
    public void act() 
    {
        
    }
    
    //Tests to see if the ball is in contact with either the TOP or BOTTOM edge of the world
    public boolean atWorldTopOrBottom()
    {
        if( (getY() <= 10) || (getY() >= 540 ) )
            return true;
        else
            return false;
    }
    
    //Tests to see if the ball is in contact with the LEFT edge of the world    
    public boolean atLeftEdge()
    {
        if( getX() <= 10 )
            return true;
        else
            return false;
    }
    
    //Tests to see if the ball is in contact with the Right edge of the world        
    public boolean atRightEdge()
    {
        if( getX() >= 540 ) 
            return true;
        else
            return false;
    }
    
    //Tests to see if the ball is in contact with a specific object        
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;       
    }
    
    
    public void reset()
    {
        
    }
}

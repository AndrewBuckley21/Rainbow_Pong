import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ball extends Movement
{
    public double speed = 5;///ball speed
    public double angle;
    public  int rotation;
    public int count1;//player 1's score
    public int count2;//player 2's score
    public GreenfootImage whiteBall, blackBall, redBall, blueBall, lightBlueBall, purpleBall, orangeBall, yellowBall, greenBall;
    public GreenfootImage color = new GreenfootImage( "whiteBall.png" );
    public int random;
    
    public Ball()
    {
        setImage( color );//sets the ball's color to initially be white
        
        //randommly selects the initial direction of the ball: left or right
        rotation = Greenfoot.getRandomNumber( 2 );
        if ( rotation == 0 )
        {
            setRotation( 0 );
        }
        if ( rotation == 1 )
        {
            setRotation( 180 );
        }
    }
    public void act() 
    {
        move();
        changeBall();
        bounce();
        atLeftEdge();
        atRightEdge();
        score1();
        score2();
        sound();
    }
    
    //moves the ball in a straight line at any angle with a specific speed
    public void move()
    {
        angle = Math.toRadians( getRotation() );//converts the angle to radians so that trig functions may be performed
        int x = (int) Math.round(getX() + Math.cos(angle) * speed );
        int y = (int) Math.round(getY() + Math.sin(angle) * speed );
        
        setLocation(x, y);
    }
    
    //bounces the ball when it is in contact with a player or the top/bottom of the world
    public void bounce()
    {
        int angleValue = Math.abs( (int)Math.toDegrees( angle ) );//converts the angle from radians to degrees
        
        //redirects the ball off of the TOP or BOTTOM eedges of the world with true redirection angles
        if ( atWorldTopOrBottom() == true )
        {
            setRotation( 360 - angleValue );
        }
        
        //redirects the ball in a possible range of 120 degrees when it bounces off of a player
        if ( canSee( Pong1.class ) == true )
        {
            setRotation( Greenfoot.getRandomNumber( 60 ) - Greenfoot.getRandomNumber( 60 ) );
        }
        if ( canSee( Pong2.class ) == true ) 
        {
            setRotation( 180 + ( Greenfoot.getRandomNumber( 60 ) - Greenfoot.getRandomNumber( 60 ) ) );
        }
    }
    
    //keeps score for player 1
    public void score1()
    {
        if ( (atRightEdge() == true) || (Greenfoot.isKeyDown( "`" ) == true))
        {
            count1++;
            Score1.score1 += count1;//increases player 1's score when the ball goes past the other player
            Greenfoot.setWorld( new PongWorld2() );//creates a new world so that scoreing variables are not reset
            Greenfoot.delay( 50 );//automatically restarts the game with a delay when someone scores
        }
        if ( Greenfoot.isKeyDown( "`" ) == true )//automatically wins game
        {
            count1 = 5;
            Score1.score1 = count1;
            Greenfoot.setWorld( new PongWorld2() );//creates a new world so that scoreing variables are not reset
        }
    }
    
    //keeeps scoree for player 2
    public void score2()
    {
        if ( (atLeftEdge() == true) || (Greenfoot.isKeyDown( "=" ) == true) )
        {
            count2++;
            Score2.score2 += count2;//increases player 2's score when the ball goes past the other player
            Greenfoot.setWorld( new PongWorld2() );//creates a new world so that scoreing variables are not reset
            Greenfoot.delay( 50 );//automatically restarts the game with a delay when someone scores
        }
        if ( Greenfoot.isKeyDown( "=" ) == true )//automatically wins game
        {
            count2++;
            Score2.score2 = count2;
            Greenfoot.setWorld( new PongWorld2() );//creates a new world so that scoreing variables are not reset
        }
    }
    
    //changes the color of the ball
    public void changeBall()
    {
        random = Greenfoot.getRandomNumber( 9 );
        switch ( random )
        {
            case 0:
                setImage( "whiteBall.png" );
                break;
            case 1:
                setImage( "blackBall.png" );
                break;
            case 2:
                setImage( "redBall.png" );
                break;
            case 3:
                setImage( "blueBall.png" );
                break;
            case 4:
                setImage( "lightBlueBall.png" );
                break;    
            case 5:
                setImage( "yellowBall.png" );
                break;    
            case 6:
                setImage( "orangeBall.png" );
                break;    
            case 7:
                setImage( "greenBall.png" );
                break;    
            case 8:
                setImage( "purpleBall.png" );
                break;       
        }
    }
    
    //makes a sound whenever the ball bounces off of a player
    public void sound()
    {
        if ( canSee( Pong1.class ) == true || canSee( Pong2.class ) == true )
        {
            Greenfoot.playSound( "slurp.wav" );
        }
    }
}

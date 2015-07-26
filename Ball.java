import java.awt.*;
public class Ball extends Polkadot
   {
      private double dx;       // pixels to move each time step() is called.
      private double dy;
      private double lscore;
      private double rscore;
      private Rectangle rb;
      private final static int topscore = 10;
    // constructors
       public Ball()         //default constructor
      {
         super(200, 200, 50, Color.RED);
         dx = Math.random() * 12 - 6;          // to move vertically
         dy = Math.random() * 12 - 6;          // to move sideways
      }
       public Ball(double x, double y, double dia, Color c)
      {
         super(x, y, dia, c);
         dx = Math.random()* 12 - 6;
         dy = Math.random() * 12 - 6;
         rb = new Rectangle((int)getX(),(int)getY(),(int)getDiameter(),(int)getDiameter());
      }
      
     //modifier methods 
       public void setdx(double x)        
      {
         dx = x;
      }
       public void setdy(double y)
      {
         dy = y;
      }
      
      //accessor methods
       public double getdx()             
      {
         return dx;
      }
       public double getdy()
      {
         return dy;
      }
      
      public double getLscore()
      {
         return lscore;
      }
      public double getRscore()
      {
         return rscore;
      }
     //instance methods
       public void move(double rightEdge, double bottomEdge, Rectangle rlp, Rectangle rrp)
      {
        setX(getX()+ dx);                  // move horizontally
        setY(getY()+ dy);                  // move vertically
        rb.setLocation((int)getX(),(int)getY());
        if (rb.intersects(rlp))
        {
            setX(getX()+rlp.getX());
            setdx(dx*-1);
        }
        if (rb.intersects(rrp))
        {
            setX(getX()-rrp.getWidth());
            setdx(dx*-1);
        }
                
         if(getX() >= rightEdge - getRadius())  //hit right edge
         {
            setX(rightEdge - getRadius());
            setdx(dx * -1);
            lscore++; 
         }
        /* more code goes here  */
        else if (getX() < 0 + getRadius()) //hit left edge
        {
            setX(0+getRadius());
            setdx(dx * -1);
            rscore++;
        }

        if(getY() >= bottomEdge - getRadius())
        {
            setY(bottomEdge-getRadius());
            setdy(dy * -1);
        }
        
        else if (getY() < 0 + getRadius())
        {
            setY(0+getRadius());
            setdy(dy*-1);
        }
      }
      public char checkWinner()
      {
         if(lscore >= topscore)
         {
            return 'l';
         }
         else if (rscore >= topscore)
         {
            return 'r';
         }
         else
         {
            return ' ';
         }
      }
   }
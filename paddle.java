import java.awt.*;
public class paddle
{
   private int x;
   private int y;
   private int height;
   private int width;
   private Color color;
   
   public int getHeight()
   {
      return height;
   }
   public int getWidth()
   {
      return width;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public void setX(int nx)
   {
      x = nx;
   }
   public void setY(int ny)
   {
      y = ny;
   }
   public paddle(int initx,int inity)
   {
      x = initx;
      y = inity;
      height = 150;
      width = 25;
      color = Color.BLACK;
   }
   
   public void draw(Graphics g)
   {
      g.setColor(color);
      g.fillRect(x,y,width,height);
   }
}
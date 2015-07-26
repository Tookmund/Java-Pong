   //Torbert, e-mail: smtorbert@fcps.edu
	//version 6.17.2003
	//Billington, version 7.25.2007

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   public class PinballPanel extends JPanel
   {
      // Make sure to keep these in sync with main
      private static final int HEIGHT = 400;
      private static final int WIDTH  = 600; 
      private static final Color BACKGROUND = new Color(204, 204, 204);
   
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Ball ball;
      private paddle lp;
      private paddle rp;
      private Rectangle rlp;
      private Rectangle rrp;
      private Timer t;
      private JLabel scores;
      private char w;
      
      public PinballPanel()
      {
         myImage =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, WIDTH,HEIGHT);
         int xPos = (int)(Math.random()*(WIDTH-100) + 50);
         int yPos = (int)(Math.random()*(HEIGHT-100)+ 50);
         ball = new Ball(xPos, yPos, 25, Color.RED);
         lp = new paddle(10,10);
         rlp = new Rectangle(10,10,lp.getWidth(),lp.getHeight());
         rp = new paddle(WIDTH-10-lp.getWidth(),HEIGHT-10-lp.getHeight());
         rrp = new Rectangle(10,10,rp.getWidth(),rp.getHeight());
         scores = new JLabel();
         scores.setFont(new Font(scores.getFont().getName(),Font.PLAIN,20));
         add(scores);
         addKeyListener(new keyer());
         setFocusable(true);
         requestFocusInWindow();
         t = new Timer(5,new Listener());
         t.start();
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
               myBuffer.setColor(BACKGROUND);    //cover the 
               myBuffer.fillRect(0,0,WIDTH,HEIGHT);   //old ball
               lp.draw(myBuffer);
               rp.draw(myBuffer);
               rlp.setLocation(lp.getX(),lp.getY());
               rrp.setLocation(rp.getX(),rp.getY());
               ball.move(WIDTH,HEIGHT,rlp,rrp);
               ball.draw(myBuffer);
               w = ball.checkWinner();
               if(w == 'l')
               {
                  scores.setText("Left Player Wins!");
               }
               else if (w == 'r')
               {
                  scores.setText("Right Player Wins!");
               }
               else
               {
                  scores.setText(String.valueOf(ball.getLscore())+" "+String.valueOf(ball.getRscore()));
                  repaint();
               }
         }
      }
      private class keyer implements KeyListener
      {
         private char c;
         private int move = 5;
         @Override
         public void keyTyped(KeyEvent e)
         {
            c = e.getKeyChar();
            switch(c)
            {
               case 'w':
                  lp.setY(lp.getY()-move);
                  break;
               case 's':
                  lp.setY(lp.getY()+move);
                  break;
               case 'i':
                  rp.setY(rp.getY()-move);
                  break;
               case 'k':
                  rp.setY(rp.getY()+move);
            }
         }
          @Override
          public void keyReleased(KeyEvent e) 
          {
          }
          
          @Override
          public void keyPressed(KeyEvent e) 
          {
            //System.out.println("Pressed " + e.getKeyChar());
          }
      }
   }
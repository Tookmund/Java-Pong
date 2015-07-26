import javax.swing.JFrame;
public class gui 
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Pong");
      frame.setSize(600,400);
      frame.setLocation(100,50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PinballPanel());
      frame.setVisible(true);
   }
}

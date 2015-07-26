public class main
{
   public static void main(String[] args)
   {
      System.out.println("PONG");
      System.out.println("Would you like to play pong in a console or in a GUI? [g/c]");
      int inp = 0;
      try
      {
         inp = System.in.read();
         if (inp == 'g' || inp == 'G')
         {
            System.out.println("Launching GUI...");
            gui.main(args);
         }
         else if (inp == 'c' || inp == 'C')
         {
            System.out.println("Launching CLI...");
            cli.main(args);
         }
      }
      catch(Exception e)
      {
         System.out.println("Assuming GUI...");
         gui.main(args);
      }
   }
}
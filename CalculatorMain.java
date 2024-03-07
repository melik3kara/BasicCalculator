import java.awt.Color;
import javax.swing.JFrame;
public class CalculatorMain
{  
   public static void main(String[] args)
   {  
      JFrame frame = new Calculator();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("MelCalc");
      frame.setBackground(Color.PINK);
      frame.setVisible(true);
   }
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Melike
 * This is a basic calculator.
 * It can do adding, substraction, dividing and multuplication.
 * If user clicks C button it will delete anything in the text.
 * It is works for only integers. 
 * If any result become a double, it will print a integer still.
*/
public class Calculator extends JFrame
{  
   private JTextField display;

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 300;
   private String opBut = "";
   private String num1 = "0";
   private String num2 = "0";

   public Calculator(){
      display = new JTextField("");
      display.setEditable(false);           
      add(display, BorderLayout.NORTH);
      createButtonPanel();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      setForeground(Color.PINK);
      setBackground(Color.BLUE);
   }
      
   /**
      Creates the button panel.
   */
   private void createButtonPanel(){      
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(4, 4));

      buttonPanel.add(makeDigitButton("7"));
      buttonPanel.add(makeDigitButton("8"));
      buttonPanel.add(makeDigitButton("9"));
      buttonPanel.add(makeOperatorButton("/"));
      buttonPanel.add(makeDigitButton("4"));
      buttonPanel.add(makeDigitButton("5"));
      buttonPanel.add(makeDigitButton("6"));
      buttonPanel.add(makeOperatorButton("*"));
      buttonPanel.add(makeDigitButton("1"));
      buttonPanel.add(makeDigitButton("2"));
      buttonPanel.add(makeDigitButton("3"));
      buttonPanel.add(makeOperatorButton("-"));
      buttonPanel.add(makeDigitButton("0"));
      buttonPanel.add(makeOperatorButton("C"));
      buttonPanel.add(makeOperatorButton("="));
      buttonPanel.add(makeOperatorButton("+"));

      add(buttonPanel, BorderLayout.CENTER);
   }
   
   class DigitButtonListener implements ActionListener{
      private String digit;
      
      /**
         Constructs a listener whose actionPerformed method adds a digit
         to the display.
         @param aDigit the digit to add
      */
      public DigitButtonListener(String aDigit){
         digit = aDigit;
      }
      
      @Override
      public void actionPerformed(ActionEvent event){  
         display.setText(display.getText() + digit);
      }        
   }

   class OperatorButtonListener implements ActionListener{
      private String opButton;

      /**
       * Constructs a listener whose actionPerformed method adds a digit
       * to the display.
       * @param aOperator the operator that user click
       */

      public OperatorButtonListener(String aOperator)
      {
         opButton = aOperator;
      }
      
      @Override
      public void actionPerformed(ActionEvent event) 
      {
         if(opButton.equals("C")){
            display.setText("");
         }
         else if(opButton.equals("+") || opButton.equals("-") || opButton.equals("/" ) || opButton.equals("*")){
            num1 = display.getText();
            num1 = num1.substring(0,num1.length());
            display.setText(display.getText() + opButton);
            opBut = opButton;

         }
         else if(opButton.equals("=")){
            num2 = display.getText();
            int i = num1.length();
            num2 = num2.substring(i+1);

            if(opBut.equals("+")){display.setText(String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2)));}
            
            if(opBut.equals("-")){display.setText(String.valueOf(Integer.valueOf(num1) - Integer.valueOf(num2)));}
            
            if(opBut.equals("/")){display.setText(String.valueOf(Integer.valueOf(num1) / Integer.valueOf(num2)));}
            
            if(opBut.equals("*")){display.setText(String.valueOf(Integer.valueOf(num1) * Integer.valueOf(num2)));}
            num1 = "0";
            num2 = "0";
            opBut = "";
         }
      }
   }

   /**
      Makes a button representing a digit of a calculator.
      @param digit the digit of the calculator
      @return the button of the calculator
   */
   public JButton makeDigitButton(String digit){
      JButton button = new JButton(digit);
      
      ActionListener listener = new DigitButtonListener(digit);
      button.addActionListener(listener);  
      return button;    
   } 

   /**
      Makes a button representing an operator of a calculator.
      @param op the operator of the calculator
      @return button the button of the calcalator
   */
   public JButton makeOperatorButton(String op){
      JButton button = new JButton(op);
      ActionListener listener = new OperatorButtonListener(op);
      button.addActionListener(listener);
      button.setForeground(Color.BLUE);
      return button;    
   } 
}

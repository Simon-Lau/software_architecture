import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

//public class AntelopeGUI extends JFrame implements Observer
public class CelsiusGUI extends JFrame implements Observer
{
   private JLabel stateLabel;
   private JTextArea actionText;
   private String grassState="";

   public CelsiusGUI() throws Exception{
      super("Antelope GUI - Observer 1");

      JPanel buttonPanel = new JPanel();
      stateLabel = new JLabel("Grass state");
      actionText = new JTextArea(4, 20);
      buttonPanel.add(stateLabel);
      buttonPanel.add(actionText);

      Container contentPane = getContentPane();
      JPanel imgPanel=new ImagePanel("Antelope.jpg");
      contentPane.add(buttonPanel, BorderLayout.CENTER);
      contentPane.add(imgPanel, BorderLayout.EAST);

      setSize(400, 150);
      setVisible(true);
   }

   public void update(Observable subject, Object arg) {

      String t = (String) arg;
      stateLabel.setText("Boiler Temperature - ");

      //if (plainColor.compareTo("Green")== 0 ){
	  actionText.setBackground(Color.green);
	  actionText.setText("Boiler Temperature: "+ t);
	  //}
	 // else if (plainColor.compareTo("Yellow")== 0 ){
     //    actionText.setBackground(Color.yellow);
     //    actionText.setText("Antelopes are leaving the plain.");
     // }
   }
}


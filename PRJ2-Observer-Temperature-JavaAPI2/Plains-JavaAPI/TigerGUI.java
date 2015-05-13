import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

//public class TigerGUI extends JFrame implements Observer
public class Fahrenheit extends JFrame implements Observer
{
   private JLabel stateLabel;
   private JTextArea actionText;
   private String grassState="";

   public TigerGUI() throws Exception {
      super("Tiger GUI- Observer 2");

      JPanel buttonPanel = new JPanel();
      stateLabel = new JLabel("Grass state");
      actionText = new JTextArea(4, 20);
      buttonPanel.add(stateLabel);
      buttonPanel.add(actionText);

      Container contentPane = getContentPane();
      JPanel imgPanel=new ImagePanel("Tiger.jpg");
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
   }
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.sun.java.swing.plaf.windows.*;
import java.util.Observable;
import java.util.Observer;

public class TemperatureGUI extends Observable{
   private JFrame frame= new JFrame("TemperatureGUI - Observable");
   private JComboBox stateCmBox;
   private Vector observersList;
   private String grassState;
   private JTextField boilerTem;
   private String bTem;
   public static final String SUBMIT = "Submit";
   public static final String EXIT = "Exit";

   public TemperatureGUI() throws Exception{
      observersList = new Vector();

      JLabel lblState = new JLabel("Select Grass State:");
      stateCmBox = new JComboBox();
      stateCmBox.addItem("Green");
      stateCmBox.addItem("Yellow");

      JButton btnOK = new JButton(SUBMIT);
      btnOK.addActionListener(new ButtonHandler());

      JPanel btnPanel = new JPanel();
      GridBagLayout gridbag = new GridBagLayout();
      btnPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      JLabel lblTemperature = new JLabel("Enter Boiler Temperature: ");
      boilerTem = new JTextField(15);

      btnPanel.add(lblTemperature);
      btnPanel.add(boilerTem);
      btnPanel.add(btnOK);

      gbc.gridx = 0;
	  gbc.gridy = 0;
	  gridbag.setConstraints(lblTemperature, gbc);
	  gbc.gridx = 1;
	  gbc.gridy = 0;
      gridbag.setConstraints(boilerTem, gbc);

      gbc.insets.top = 50;
      gbc.gridx = 1;
      gbc.gridy = 3;
      gridbag.setConstraints(btnOK, gbc);

      Container contentPane = frame.getContentPane();

      contentPane.add(btnPanel, BorderLayout.CENTER);
      try {
         UIManager.setLookAndFeel(new WindowsLookAndFeel());
         SwingUtilities.updateComponentTreeUI(frame);
      }
      catch (Exception ex) {
         System.out.println(ex);
      }

      frame.setSize(300, 150);
      frame.setVisible(true);
   }

   //public void setGrassState(String st){
   //   grassState = st;
   //}

   public void setTemperature(String tem){
         bTem = tem;
   }

   class ButtonHandler implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if (e.getActionCommand().equals(SUBMIT)){
            //String state = (String)stateCmBox.getSelectedItem();
            String tem = boilerTem.getText();

            System.out.println("Temperature" + tem);
            setTemperature(tem);
            setChanged();
            notifyObservers(bTem);
      }
    }
  }
}// end of class


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener {
  private Container pane;
  private JCheckBox toggle;
  private JLabel instructions;
  private JLabel instructions2;
  private JTextField input;
  private JButton go;
  private JTextField output;

  public TemperatureWindow(){
    this.setTitle("TemperatureWindow");
    this.setSize(1920, 1080);
    // this.setLocation(300,300);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());

    toggle = new JCheckBox("Convert to Farenheit?");
    instructions = new JLabel("Temperature Input");
    instructions2 = new JLabel("Temperature Output");
    input = new JTextField(20);
    output = new JTextField(20);
    output.setLocation(500,900);
    output.setBounds(900,900, 20,50);
    go = new JButton("Submit");
    go.addActionListener(this);

    //  pane.setLocationByPlatform(true);
    pane.add(instructions);
    pane.add(input);
    pane.add(toggle);
    pane.add(go);
    pane.add(instructions2);
    pane.add(output);


  }

  public void actionPerformed(ActionEvent e){
    String event = e.getActionCommand();
    try{
      if (event.equals("Submit")){
        double temperature = Double.parseDouble(input.getText());
        if(toggle.isSelected()){
          output.setText("" + Temperature.CToF(temperature));

        }
        else{
          output.setText("" + Temperature.FToC(temperature));

        }
      }
    }
    catch (Exception a){
      output.setText("i need numbers!!");
    }
  }

  public static void main(String[] args) {
    TemperatureWindow g = new TemperatureWindow();
    g.setVisible(true);
  }
}

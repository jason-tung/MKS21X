import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Temperature extends JFrame implements ActionListener {
    private JCheckBox toggle;
    private JLabel instructions;
    private JTextField input;
    private JButton go;

    public TemperatureWindow(){
	this.setTitle("TemperatureWindow");
	this.setSize(1920/2, 1080/2);
	//this.setLocation(300,300);
	this.setDefaultCloserOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	toggle = new JCheckBox("to U.S. temperature units?");

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window2 extends JFrame implements ActionListener {
    private Container pane;
    private JButton buTTON;
    private JLabel labelerino;
    private JTextField text;
    private JCheckBox checkboxerino;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Window2() {
        this.setTitle("My first GUI");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
	buTTON = new JButton("Do SOMETHING!!!!");
	buTTON.addActionListener(this);
	labelerino = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
	text = new JTextField(12);
	checkboxerino = new JCheckBox("Overclock!!!");
	pane.add(buTTON);
	pane.add(labelerino);
	pane.add(text);
	pane.add(checkboxerino);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if (event.equals("Do SOMETHING!!!!") && checkboxerino.isSelected()){
	    System.out.println("doafodasofd");
	    text.setText("AHHHH");
	}
	else{
	    System.out.println("wow that wasnt the button lol");
	}
    }
     

    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Window2 g = new Window2();
	g.setVisible(true);
    }
}

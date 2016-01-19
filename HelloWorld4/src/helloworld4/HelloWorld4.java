package helloworld4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloWorld4 {
	public static void main(String[] args)
	{
		//create new JFrame and add the Component
		JFrame frame = new JFrame("Hello World");
		frame.getContentPane().add( new HelloComponent4("Hello Java!!"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);		
	}
}

@SuppressWarnings("serial")
class HelloComponent4 extends JComponent
implements MouseMotionListener, ActionListener, Runnable{

	//variables declared for message and location
	String theMessage;
	int messageX = 110, messageY = 110;
	
	JButton theButton;
	
	boolean blinkState;
	
	//list of colours
	int colorIndex;
	static Color[] someColors = {Color.black, Color.red, Color.blue, Color.magenta};
	
	//allows movement on the message
	public HelloComponent4(String message) {
		theMessage = message;
		theButton = new JButton("Change Color");
		setLayout(new FlowLayout());
		add(theButton);
		theButton.addActionListener(this);
		addMouseMotionListener(this);
		Thread t = new Thread(this);
		t.start();
	}
	
	//draw the message on the coordinates defined in the variables
	public void paintComponent(Graphics g)
	{
		g.setColor(blinkState ? getBackground() : currentColor());
		g.drawString(theMessage, messageX, messageY);
	}
	
	//gets coordinates of drag event and adds the message to this new location
	public void mouseDragged(MouseEvent e) {
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}

	//nothing implemented for mouseMove
	public void mouseMoved(MouseEvent e) {}

	public void actionPerformed(ActionEvent e) {
		//check if someone presses the button
		if(e.getSource() == theButton)
			changeColor();	
	}
	
	//method for changing colour of foreground
	synchronized private void changeColor()
	{
		//basic change colour method, should be improved.
		if(++colorIndex == someColors.length)
			colorIndex = 0;
		setForeground(currentColor());
		repaint();
	}
	
	//method to return the colour based on index.
	synchronized private Color currentColor()
	{
		//get colours index
		return someColors[colorIndex];
	}

	//runnable method for thread
	public void run() {
		try{
			while(true){
				blinkState = !blinkState;
				repaint();
				Thread.sleep(300);
			}
		}catch(InterruptedException ie){ie.printStackTrace();}	
	}
	
}

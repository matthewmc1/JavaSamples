package helloworld2;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class HelloWorld2 {
	public static void main(String[] args)
	{
		//create new JFrame and add the Component
		JFrame frame = new JFrame("Hello World");
		frame.getContentPane().add( new HelloComponent2("Hello Java!!"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);		
	}
}

@SuppressWarnings("serial")
class HelloComponent2 extends JComponent
implements MouseMotionListener{

	//variables declared for message and location
	String theMessage;
	int messageX = 110, messageY = 110;
	
	//allows movement on the message
	public HelloComponent2(String message) {
		theMessage = message;
		addMouseMotionListener(this);
	}
	
	//draw the message on the co-ordinates defined in the variables
	public void paintComponent(Graphics g)
	{
		g.drawString(theMessage, messageX, messageY);
	}
	
	//gets co-ordinates of drag event and adds the message to this new location
	public void mouseDragged(MouseEvent e) {
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}

	//nothing implemented for mouseMove
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

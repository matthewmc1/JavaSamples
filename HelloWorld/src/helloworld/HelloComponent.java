package helloworld;

//import graphics and JComponent
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
//Extend HelloComponent class with the JComponent class defined in Swing interface.
public class HelloComponent extends JComponent {
	public void paintComponent(Graphics g)
	{
		//draw message on specific location 
		g.drawString("Hello World", 110, 110);
	}

}

package helloworld;

//import all javax swing methods
import javax.swing.*;

public class HelloWorld {

	public static void main(String[] args) {
		JFrame frame = new JFrame( "Hello World!" );
		//call HelloComponent.java file to display message
		frame.getContentPane().add(new HelloComponent());
		//set frame size and if visible
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

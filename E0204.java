import java.awt.*;
import javax.swing.*;
public class E0204 extends JFrame
{
	public E0204()
	{
		Container cnt = getContentPane();
		setSize(400,300);
		
		JButton b1 = new JButton("CENTER");
		JButton b2 = new JButton("EAST");
		JButton b3 = new JButton("WEST");
		JButton b4 = new JButton("SOUTH");
		JButton b5 = new JButton("NORTH");
		
		cnt.add(b1,BorderLayout.CENTER);
		cnt.add(b2,BorderLayout.EAST);
		cnt.add(b3,BorderLayout.WEST);
		cnt.add(b4,BorderLayout.SOUTH);
		cnt.add(b5,BorderLayout.NORTH);

		setVisible(true); 
	}
	
	public static void main(String args[])
	{
		E0204 frm = new E0204();
	}
}
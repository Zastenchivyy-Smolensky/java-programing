import java.awt.*;
import javax.swing.*;
public class E0202 extends JFrame
{
	public E0202()
	{
		Container cnt = getContentPane();
		setSize(400,300);
		JLabel lb1 = new JLabel("こんにちは");
		JButton bt1 = new JButton("挨拶");
		
		cnt.add(lb1,BorderLayout.CENTER);
		cnt.add(bt1,BorderLayout.SOUTH);
		setVisible(true); 
	}
	
	public static void main(String args[])
	{
		E0202 frm = new E0202();
	}
}
/*
 * 応用プログラミングⅡ　第２回，第３回　サンプル５
 */
import java.awt.*;
import javax.swing.*;
public class E0205 extends JFrame
{
	public E0205()
	{
		Container cnt = getContentPane();
		setSize(400,300);
		
		JButton b1 = new JButton("BT1");
		JButton b2 = new JButton("BT2");
		JButton b3 = new JButton("BT3");
		JButton b4 = new JButton("BT4");
		JButton b5 = new JButton("BT5");
		
		setLayout(new FlowLayout());
		
		cnt.add(b1);
		cnt.add(b2);
		cnt.add(b3);
		cnt.add(b4);
		cnt.add(b5);

		setVisible(true); 
	}
	
	public static void main(String args[])
	{
		E0205 frm = new E0205();
	}
}
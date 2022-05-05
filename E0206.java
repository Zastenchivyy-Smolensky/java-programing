/*
 * 応用プログラミングⅡ　第２回，第３回　サンプル６
 */
import java.awt.*;
import javax.swing.*;
public class E0206 extends JFrame
{
	JButton bt[] = new JButton[6];

	public E0206()
	{

		Container cnt = getContentPane();
		setSize(400,300);
		
		bt[0] = new JButton("BT1");
		bt[1] = new JButton("BT2");
		bt[2] = new JButton("BT3");
		bt[3] = new JButton("BT4");
		bt[4] = new JButton("BT5");
		bt[5] = new JButton("BT6");
		
//		setLayout(new GridLayout(2,3));
//		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		//レイマネージャを変えると論理的な形に並べてくれる
		
		for(int i=0; i<bt.length; i++) {
			cnt.add(bt[i]);
		}

		setVisible(true); 
	}
	
	public static void main(String args[])
	{
		E0206 frm = new E0206();
	}
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class E0203 extends JFrame {
	JLabel lb1;
	JButton bt1;
	Boolean flag;
	public E0203() {
		Container cnt = getContentPane();
		setSize(400,300);
		lb1 = new JLabel("こんにちは");
		bt1 = new JButton("挨拶");
		bt1.addActionListener(new MyActionListener2());
		flag = true;
		cnt.add(lb1,BorderLayout.CENTER);
		cnt.add(bt1, BorderLayout.SOUTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		E0203 frm = new E0203();
	}
	
	class MyActionListener1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(flag) {
				lb1.setText("さよなら");
				flag = false;
			}else {
				lb1.setText("こんにちは");
				flag= true;
			}
		}
	}
	class MyActionListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(flag) {
				lb1.setText("hello");
				flag = false;
			}else {
				lb1.setText("world");
				flag= true;
			}
		}
	}

}

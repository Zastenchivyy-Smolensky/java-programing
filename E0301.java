import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class E0301 extends JFrame {
	int count;
	JButton bt1, bt2;
	JLabel lb1;
	public E0301() {
		Container cnt = getContentPane();
		setSize(200,150);
		lb1 = new JLabel("0");
		lb1.setHorizontalAlignment(JLabel.CENTER);
		bt1 = new JButton(">>");
		bt1.addActionListener(new Up());
		bt2 = new JButton("<<");
		bt2.addActionListener(new Down());
		count = 0;
		cnt.add(lb1, BorderLayout.CENTER);
		cnt.add(bt1, BorderLayout.EAST);
		cnt.add(bt2, BorderLayout.WEST);
		cnt.add(new JLabel("課題1 練習1 s20c2007 影山亮太"),BorderLayout.NORTH);
		setVisible(true);
	}
	class Up implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			count++;
			lb1.setText(Integer.toString(count));
		}
	}
	class Down implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			count--;
			lb1.setText(Integer.toString(count));
		}
	}
	public static void main(String[] args) {
		E0301 frm = new E0301();

	}
}
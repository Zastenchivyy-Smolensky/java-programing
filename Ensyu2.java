import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ensyu2 extends JFrame implements ActionListener {
	JTextField tfX, tfY, tfZ;
	JLabel lb1;
	JButton bt1;
	Hikaku h1;
	Ensyu2(){
		h1 = new Hikaku(3);
		Container c = getContentPane();
		tfX = new JTextField(5);
		tfY = new JTextField(5);
		tfZ = new JTextField(5);
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("X="));
		p1.add(tfX);
		p1.add(new JLabel("Y="));
		p1.add(tfY);
		p1.add(new JLabel("Z="));
		p1.add(tfZ);
		
		JPanel p2 = new JPanel();
		bt1 = new JButton("比較");bt1.addActionListener(this); p2.add(bt1);
		lb1 = new JLabel("");
		p2.add(lb1);
		c.add(new JLabel("最大値と最小値を求めるアプリ(20c2007影山亮太)"),BorderLayout.NORTH);
		c.add(p1,BorderLayout.CENTER);
		c.add(p2,BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		h1.set_data(0, Integer.parseInt(tfX.getText()));
		h1.set_data(1, Integer.parseInt(tfY.getText()));
		h1.set_data(2, Integer.parseInt(tfZ.getText()));
		lb1.setText("最大値は"+h1.get_max()+"最小値"+h1.get_min());
	}
	public static void main(String[] args) {
		E0401 en =new E0401();
	}

}

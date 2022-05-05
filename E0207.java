import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class E0207 extends JFrame implements ActionListener  {

		JTextField tfX,tfY, tfAns;
		JButton bt1, bt2, bt3, bt4;
		int X, Y;
		E0207(){
			Container c = getContentPane();
			tfX = new JTextField(5);
			tfY = new JTextField(5);
			tfAns = new JTextField(5);
			
			JPanel p1 = new JPanel();
			p1.add(new Label("X="));
			p1.add(tfX);
			p1.add(new Label("Y="));
			p1.add(tfY);
			p1.add(new Label("Ans = "));
			p1.add(tfAns);
			
			JPanel p2 = new JPanel();
			bt1 = new JButton("+"); bt1.addActionListener(this); p2.add(bt1);
			bt2 = new JButton("-"); bt2.addActionListener(this); p2.add(bt2);
			bt3 = new JButton("*"); bt3.addActionListener(this); p2.add(bt3);
			bt4 = new JButton("/"); bt4.addActionListener(this); p2.add(bt4);
			c.add(new Label("簡易電卓(XとYに数値を入力して計算)"),BorderLayout.NORTH);
			c.add(p1, BorderLayout.CENTER);
			c.add(p2, BorderLayout.SOUTH);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			pack();
			setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e)
		{
			String cmd = e.getActionCommand();
			X = Integer.parseInt(tfX.getText());
			Y = Integer.parseInt(tfY.getText());
			
			if(cmd.equals("+")) {
				tfAns.setText(""+(X+Y));
			}
			else if(cmd.equals("-")) {
				tfAns.setText(""+(X-Y));
			}
			else if(cmd.equals("*")) {
				tfAns.setText(""+(X*Y));
			}
			else if(cmd.equals("/")) {
				tfAns.setText(""+((double)X/(double)Y));
			}else {
				tfAns.setText("ERROR");
			}
		}
		public static void main(String[] args) {
			E0207 en = new E0207();
		}
			
}

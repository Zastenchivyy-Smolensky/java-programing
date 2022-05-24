import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DentakuGUI1 extends JFrame {
	Dentaku dtk;
	JTextField tf;
	JPanel keypad;
	JButton bt1,bt0,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9, btPlus,btMinus,btCalc,btKake,btWaru,Btclear;
	public DentakuGUI1() {
		dtk = new Dentaku();
		Container cp = getContentPane();
		tf = new JTextField();
		tf.setHorizontalAlignment(SwingConstants.RIGHT);
		tf.setText(dtk.output());
		keypad = new JPanel();
		keypad.setLayout(new GridLayout(4,4));
		
		bt1 = new JButton("1");
		bt1.addActionListener(new Bt1());
		bt0 = new JButton("0");bt0.addActionListener(new Bt0());
		bt2 = new JButton("2");
		bt2.addActionListener(new Bt2());
		bt3 = new JButton("3");
		bt3.addActionListener(new Bt3());
		bt4 = new JButton("4");
		bt4.addActionListener(new Bt4());
		bt5 = new JButton("5");
		bt5.addActionListener(new Bt5());
		bt6 = new JButton("6");
		bt6.addActionListener(new Bt6());
		bt7 = new JButton("7");
		bt7.addActionListener(new Bt7());
		bt8 = new JButton("8");
		bt8.addActionListener(new Bt8());
		bt9 = new JButton("9");
		bt9.addActionListener(new Bt9());
		btPlus = new JButton("+");
		btPlus.addActionListener(new BtPlus());
		btCalc = new JButton("="); 
		btCalc.addActionListener(new BtCalc());
		btMinus = new JButton("="); 
		btMinus.addActionListener(new BtMinus());
		btKake = new JButton("*"); 
		btKake.addActionListener(new BtKake());
		btWaru = new JButton("/"); 
		btWaru.addActionListener(new BtWaru());

		keypad.add(bt7);
		keypad.add(bt8);
		keypad.add(bt9);
		keypad.add(btMinus);
		keypad.add(bt4);
		keypad.add(bt5);
		keypad.add(bt6);
		keypad.add(btPlus);
		keypad.add(bt1);
		keypad.add(bt2);
		keypad.add(bt3);
		keypad.add(btCalc);
		keypad.add(bt0);
		keypad.add(btKake);
		cp.add(tf,BorderLayout.NORTH);
		cp.add(keypad,BorderLayout.CENTER);
		cp.add(new JLabel("作成者 20c2007影山亮太"));
	}
	class Bt0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(0);
			tf.setText(dtk.output());
		}
	}
	
	class Bt1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(1);
			tf.setText(dtk.output());
		}
	}

	class Bt2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(2);
			tf.setText(dtk.output());
		}
	}
	class Bt3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(4);
			tf.setText(dtk.output());
		}
	}
	class Bt4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(4);
			tf.setText(dtk.output());
		}
	}
	class Bt5 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(5);
			tf.setText(dtk.output());
		}
	}
	class Bt6 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(6);
			tf.setText(dtk.output());
		}
	}
	class Bt7 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(7);
			tf.setText(dtk.output());
		}
	}
	class Bt8 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(8);
			tf.setText(dtk.output());
		}
	}
	class Bt9 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushNum(9);
			tf.setText(dtk.output());
		}
	}
	class BtPlus implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dtk.pushOp("+");
			tf.setText(dtk.output());
		}
	}
	class BtMinus implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dtk.pushOp("-");
			tf.setText(dtk.output());
		}
	}
	class BtKake implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dtk.pushOp("+");
			tf.setText(dtk.output());
		}
	}
	class BtWaru implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dtk.pushOp("+");
			tf.setText(dtk.output());
		}
	}
	class BtCalc implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushCalc();
			tf.setText(dtk.output());
		}
	}
	class BtClear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dtk.pushCalc();
			tf.setText(dtk.output());
		}
	}
	public static void main(String[] args) {
		DentakuGUI1 dtk_gui = new DentakuGUI1();

	}

}

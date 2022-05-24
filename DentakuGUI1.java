import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DentakuGUI1 extends JFrame implements ActionListener{
	Dentaku dtk;
	JTextField tf;
	JPanel keypad;
	JButton bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btPlus,btMin,btMul,btDiv,btCalc,btClear;

public  DentakuGUI1() {
	dtk = new Dentaku();
	
	
	Container cp = getContentPane();
	
	tf = new JTextField();
	tf.setHorizontalAlignment(SwingConstants.RIGHT);
	tf.setText(dtk.output());
	
	keypad = new JPanel();
	keypad.setLayout(new GridLayout(4,4));
	
	bt0 = new JButton("0");
	bt0.addActionListener(this);
	
	bt1 = new JButton("1");
	bt1.addActionListener(this);
	
	bt2 = new JButton("2");
	bt2.addActionListener(this);
	
	bt3 = new JButton("3");
	bt3.addActionListener(this);
	
	bt4 = new JButton("4");
	bt4.addActionListener(this);
	
	bt5 = new JButton("5");
	bt5.addActionListener(this);
	
	bt6 = new JButton("6");
	bt6.addActionListener(this);
	
	bt7 = new JButton("7");
	bt7.addActionListener(this);
	
	bt8 = new JButton("8");
	bt8.addActionListener(this);
	
	bt9 = new JButton("9");
	bt9.addActionListener(this);
	
	btPlus = new JButton("+");
	btPlus.addActionListener(this);
	
	btMin = new JButton("-");
	btMin.addActionListener(this);
	
	btMul = new JButton("*");
	btMul.addActionListener(this);
	
	btDiv = new JButton("/");
	btDiv.addActionListener(this);
	
	btCalc = new JButton("=");
	btCalc.addActionListener(this);
	
	btDiv = new JButton("/");
	btDiv.addActionListener(this);
	
	btClear = new JButton("");
	btClear.addActionListener(this);
	
	keypad.add(bt7);
	keypad.add(bt8);
	keypad.add(bt9);
	keypad.add(btMin);
	keypad.add(bt4);
	keypad.add(bt5);
	keypad.add(bt6);
	keypad.add(btPlus);
	keypad.add(bt1);
	keypad.add(bt2);
	keypad.add(bt3);
	keypad.add(btMul);
	keypad.add(btCalc);
	keypad.add(bt0);
	keypad.add(btClear);
	keypad.add(btDiv);
	
	cp.add(tf,BorderLayout.NORTH);
	cp.add(keypad,BorderLayout.CENTER);
	cp.add(new JLabel("20c2050 田口尚樹"),BorderLayout.SOUTH);
	pack();setVisible(true);
   }
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("C")){
			dtk.pushClear();
		}else if(cmd.equals("+")) {
			dtk.pushOp("+");
		}else if(cmd.equals("-")) {
			dtk.pushOp("-");
		}else if(cmd.equals("*")) {
			dtk.pushOp("*");
		}else if(cmd.equals("/")) {
			dtk.pushOp("/");
		}else if(cmd.equals("=")) {
			dtk.pushOp("=");
		}else if(cmd.equals("0")) {
			dtk.pushNum(0);
		}else if(cmd.equals("1")) {
			dtk.pushNum(1);
	    }else if(cmd.equals("2")) {
		    dtk.pushNum(2);
		}else if(cmd.equals("3")) {
			dtk.pushNum(3);
		}else if(cmd.equals("4")) {
		    dtk.pushNum(4);
		}else if(cmd.equals("5")) {
		    dtk.pushNum(5);
		}else if(cmd.equals("6")) {
		    dtk.pushNum(6);
		}else if(cmd.equals("7")) {
		    dtk.pushNum(7);
		}else if(cmd.equals("8")) {
		    dtk.pushNum(8);
		}else if(cmd.equals("9")) {
		    dtk.pushNum(9);
		}
	
	tf.setText(dtk.output());
	
}
	public static void main(String args[]) {
		DentakuGUI1 dtk_gui = new DentakuGUI1();
	}
}



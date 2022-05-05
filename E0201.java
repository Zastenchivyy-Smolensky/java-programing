import java.awt.*;
import javax.swing.*;
public class E0201 extends JFrame {

	public E0201(String name)
	{
		Container cnt = getContentPane();
		JLabel lb1 = new JLabel();
		lb1.setText("こんにちは"+ name +"です");
		JLabel lb2 = new JLabel();
		lb1.setText("ああ");
		cnt.add(lb1,BorderLayout.NORTH);
		cnt.add(lb2,BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		E0201 frmA = new E0201("A");//オブジェクトを指し示すための変数
		
	}
	

}

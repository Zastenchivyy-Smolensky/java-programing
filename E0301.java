import java.awt.*;//パッケージをインポートしている
import java.awt.event.*;//パッケージをインポートしている
import javax.swing.*;//パッケージをインポートしている
public class E0301 extends JFrame { //クラスを定義している
	int count;//int型を使ってcountを初期化している
	JButton bt1, bt2; //ボタンクラスから変数を初期化している
	JLabel lb1;//ラベルクラスから変数を初期化している
	public E0301() {//コンストラクタを定義している
		Container cnt = getContentPane(); //コンテンツペインの習得している
		setSize(200,150);//画面のサイズを指定している
		lb1 = new JLabel("0"); //ラベルを配置している
		lb1.setHorizontalAlignment(JLabel.CENTER);
		bt1 = new JButton(">>");
		bt1.addActionListener(new Up()); 
		bt2 = new JButton("<<");
		bt2.addActionListener(new Down());
		count = 0;//変数を初期化している
		cnt.add(lb1, BorderLayout.CENTER); //ラベルを中央に配置している
		cnt.add(bt1, BorderLayout.EAST);
		cnt.add(bt2, BorderLayout.WEST);
		cnt.add(new JLabel("課題1 練習1 s20c2007 影山亮太"),BorderLayout.NORTH);//学生番号と名前を配置している
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
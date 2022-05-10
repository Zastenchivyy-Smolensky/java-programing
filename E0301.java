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
		bt1 = new JButton(">>");//「>>」ボタンを作成している
		bt1.addActionListener(new Up()); //upクラスを呼び出している
		bt2 = new JButton("<<");//「>>」ボタンを作成している
		bt2.addActionListener(new Down());
		count = 0;//変数を初期化している
		cnt.add(lb1, BorderLayout.CENTER); //ラベルを中央に配置している
		cnt.add(bt1, BorderLayout.EAST);  //ボタンを左に配置している
		cnt.add(bt2, BorderLayout.WEST);  //ボタンを右に配置している 
		cnt.add(new JLabel("課題1 練習1 s20c2007 影山亮太"),BorderLayout.NORTH);//学生番号と名前を配置している
		setVisible(true);//ウィンドウを表示させる
	}
	class Up implements ActionListener{ //「>>」ボタンが押された時に,呼び出されるクラス
		public void actionPerformed(ActionEvent e) {
			count++; //countを1増やす
			lb1.setText(Integer.toString(count));//countに格納された整数型を文字列に変換してラベル設定
		}
	}
	class Down implements ActionListener{ //「<<」ボタンを押された時に呼び出されるクラス
		public void actionPerformed(ActionEvent e) { 
			count--;//countを1減らす
			lb1.setText(Integer.toString(count));//countに格納された整数型を文字列に変換してラベル設定
		}
	}
	public static void main(String[] args) {//mainクラスを定義している
		E0301 frm = new E0301();//E0301からインスタンスを作成している

	}
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DentakuGUI2 extends JFrame implements ActionListener {
	Dentaku dtk; //Dentakuクラスのオブジェクトを格納する変数
	JTextField tf;//結果を表示するためのテキストフィールド
	JPanel keypad;//ボタン配置用のパネル
	JButton bt0, bt1,bt2,bt3,bt4,bt5, bt6,bt7,bt8,bt9, btPlus,btMinus,btMui, btDiv,btClear,btCalc;//操作用のボタン配置のパネル
	public DentakuGUI2() {//DentakuGUI2クラスのコンストラクター
		dtk = new Dentaku();// Dentakuクラスのオブジェクトを作成
		Container cp = getContentPane();//コンテンツペインの習得
		tf = new JTextField();//結果表示用のテキストフィールド
		tf.setHorizontalAlignment(SwingConstants.RIGHT);//表示を右よせにする
		tf.setText(dtk.output());
		keypad = new JPanel();//JPanelクラスからインスタンスを作成
		keypad.setLayout(new GridLayout(4,4));//レチアウトマネージャの設定
		bt0 = new JButton("0");bt0.addActionListener(this);  bt1 = new JButton("1");bt1.addActionListener(this);//JButtonクラスからインスタンスを作成している
		bt2 = new JButton("2");bt2.addActionListener(this);bt3 = new JButton("3");bt3.addActionListener(this);;//JButtonクラスからインスタンスを作成している
		bt4 = new JButton("4");bt4.addActionListener(this);bt5 = new JButton("5");bt5.addActionListener(this);;//JButtonクラスからインスタンスを作成している
		bt6 = new JButton("6");bt6.addActionListener(this);bt7 = new JButton("7");bt7.addActionListener(this);;//JButtonクラスからインスタンスを作成している
		bt8 = new JButton("8");bt8.addActionListener(this);bt9 = new JButton("9");bt9.addActionListener(this);;//JButtonクラスからインスタンスを作成している
		btPlus = new JButton("+");btPlus.addActionListener(this);btMinus = new JButton("-");btMinus.addActionListener(this);;//JButtonクラスからインスタンスを作成している
		btMui = new JButton("*");btMui.addActionListener(this);btDiv = new JButton("/");btDiv.addActionListener(this);;//JButtonクラスからインスタンスを作成している
		btClear = new JButton("C");btClear.addActionListener(this);btCalc = new JButton("=");btCalc.addActionListener(this);;//JButtonクラスからインスタンスを作成している
		
		keypad.add(bt7);keypad.add(bt8);keypad.add(bt9);keypad.add(btMinus);//電卓のボタンを配置している
		keypad.add(bt4);keypad.add(bt5);keypad.add(bt6);keypad.add(btPlus);//電卓のボタンを配置している
		keypad.add(bt1);keypad.add(bt2);keypad.add(bt3);keypad.add(btMui);//電卓のボタンを配置している
		keypad.add(btCalc);keypad.add(bt0);keypad.add(btClear);keypad.add(btDiv);//電卓のボタンを配置している
		cp.add(tf, BorderLayout.NORTH);//計算結果の画面を配置してフレームを表示している
		cp.add(keypad, BorderLayout.CENTER);//ボタンを中央に配置してフレームを表示している
		cp.add(new JLabel("作成者 20c2007 影山亮太"),BorderLayout.SOUTH);//学籍番号と氏名を配置してフレームに表示している
		pack();setVisible(true);//フレームが表示されるようにしている.
	}
	//ボタンが押された時の処理
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();//押されたボタンのラベルを習得
		if(cmd.contentEquals("C")) {//Cが押された時の処理
			dtk.pushClear();//表示された数値をclearにする
		}
		else if(cmd.contentEquals("=")) {//「=」が押された時の処理
			dtk.pushCalc();//結果を表示してくれる
		}
		else if(cmd.contentEquals("+")) {//「+」が押された時の処理
			dtk.pushOp("+");//足し算の処理を行う
		}
		else if(cmd.contentEquals("-")) {//「-」が押された時の処理
			dtk.pushOp("-");//引き算の処理を行う
		}
		else if(cmd.contentEquals("*")) {//「*」が押された時の処理
			dtk.pushOp("*");//掛け算の処理を行う
		}
		else if(cmd.contentEquals("/")) {//「/」が押された時の処理
			dtk.pushOp("/");//割り算の処理を行う
		}
		else if(cmd.contentEquals("0")) {//「0」が押された時の処理
			dtk.pushNum(0);//数値表示欄に「0」を表示する
		}
		else if(cmd.contentEquals("1")) {//「1」が押された時の処理
			dtk.pushNum(1);//数値表示欄に「1」を表示する
		}
		else if(cmd.contentEquals("2")) {//「2」が押された時の処理
			dtk.pushNum(2);//数値表示欄に「2」を表示する
		}
		else if(cmd.contentEquals("3")) {//「3」が押された時の処理
			dtk.pushNum(3);//数値表示欄に「3」を表示する
		}
		else if(cmd.contentEquals("4")) {//「4」が押された時の処理
			dtk.pushNum(4);//数値表示欄に「4」を表示する
		}
		else if(cmd.contentEquals("5")) {//「5」が押された時の処理
			dtk.pushNum(5);//数値表示欄に「5」を表示する
		}
		else if(cmd.contentEquals("6")) {//「6」が押された時の処理
			dtk.pushNum(6);//数値表示欄に「6」を表示する
		}
		else if(cmd.contentEquals("7")) {//「7」が押された時の処理
			dtk.pushNum(7);//数値表示欄に「7」を表示する
		}
		else if(cmd.contentEquals("8")) {//「8」が押された時の処理
			dtk.pushNum(8);//数値表示欄に「8」を表示する
		}
		else if(cmd.contentEquals("9")) {//「9」が押された時の処理
			dtk.pushNum(9);//数値表示欄に「9」を表示する
		}
		tf.setText(dtk.output());//結果をテキストフィールドに設定
	}
	public static void main(String[] args) {
		DentakuGUI2 dtk_gui = new DentakuGUI2();
	}

}

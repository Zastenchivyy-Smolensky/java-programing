import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class E0401 extends JFrame implements ActionListener {
	JTextField tfX, tfY, tfZ; //JTextFieldクラスのメンバー変数として定義
	JLabel lb1;//JLabelクラスのメンバー変数として定義
	JButton bt1;//JButtonクラスのメンバー変数として定義
	Hikaku c1; //最大値,最小値計算用のCompareクラスの変数
	public E0401(){
		c1 = new Hikaku(3); //最大値,最小値計算用のCompareクラスのオブジェクトを作成指定h1に格納する
		//アプリケーションのViewの定義
		Container c = getContentPane(); //コンテントペインを習得している
		tfX = new JTextField(5); //1つ目のテキストフィールドを作成する
		tfY = new JTextField(5); //2つ目のテキストフィールドを作成する
		tfZ = new JTextField(5); //3つ目のテキストフィールドを作成する
		
		JPanel p1 = new JPanel(); //パネルを配置する
		p1.add(new JLabel("X=")); //Xラベルを配置する
		p1.add(tfX); //1つ目のテキストフィールドを作成する
		p1.add(new JLabel("Y="));//Yラベルを配置する
		p1.add(tfY); //2つ目のテキストフィールドを作成する
		p1.add(new JLabel("Z="));//Zラベルを配置する
		p1.add(tfZ); //3つ目のテキストフィールドを作成する
		
		JPanel p2 = new JPanel(); //パネルを配置する
		bt1 = new JButton("比較");bt1.addActionListener(this); p2.add(bt1); //ボタンを配置する
		lb1 = new JLabel(""); //ラベルを配置する
		p2.add(lb1); //ラベルの配置
		c.add(new JLabel("最大値と最小値を求めるアプリ(20c2007影山亮太)"),BorderLayout.NORTH); //自分のラベルの配置
		c.add(p1,BorderLayout.CENTER); //ボタンの配置
		c.add(p2,BorderLayout.SOUTH); //ボタンの配置
		setDefaultCloseOperation(EXIT_ON_CLOSE); //閉じるボタンがクリックされた時にアプリケーションが終了する時の命令
		pack(); //フレームの内容が適切になるように設定する
		setVisible(true); //ウィンドウを表示させる
	}
	public void actionPerformed(ActionEvent e) {	// アプリケーションのControlの定義

		c1.set_data(0, Integer.parseInt(tfX.getText())); //文字列を整数型に変換して0番目に代入
		c1.set_data(1, Integer.parseInt(tfY.getText())); //文字列を整数型に変換して1番目に代入
		c1.set_data(2, Integer.parseInt(tfZ.getText())); //文字列を整数型に変換して2番目に代入
		lb1.setText("最大値は"+c1.get_max()+"最小値"+c1.get_min()); //get_maxとget_minを使って最大値と最小値を求めてその結果を表示
	}
	public static void main(String[] args) {//おまじない
		E0401 en =new E0401(); //インスタンスを作成している
	}

}

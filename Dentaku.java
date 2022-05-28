public class Dentaku {//Dentakuクラスを定義している
	int num1;//変数num1を定義している
	int num2;//変数num2を定義している
	int display;//変数displayを定義している
	String operator;//変数operatorを定義している
	int state;//変数stateを定義している
	
	public Dentaku() {//Dentakuクラスのコンストラクタ
		num1=0;//変数num1を0に初期化している
		num2=0;//変数num2を0に初期化している
		state=0;//変数stateを0に初期化している
		display=num1;//変数displayにnum1を代入している
		operator="未";//変数operatorに文字列'未'を代入している
	}
	void pushNum(int n) {//数字が押された時の挙動
		if(state == 0 || state==3) {//初期状態,結果表示
			num1 = n;
			state=1;//数1入力中へ遷移
			display = num1;//
		}else if(state==1) {//数２入力中
			num1 = num1*10+n;
			state =1;
			display = num1; 
		}else if(state==2) {
			num2 = num2*10+n;
			state = 2;
			display = num2;
		}
	}
	void pushOp(String op) //演算子が押された時の処理
	{
		if(state == 0 || state==1 || state==3) {
			operator =op; 
			state = 2;
			display = num1;
		}else if(state == 2) {
			num1 = calc();
			num2 = 0;
			operator = op;
			state = 2;
			display = num1; 
		}
	}
	void pushClear() //クリアが押された時の処理
	{
		num1 = 0;
		num2 = 0;
		state = 0;
		display = num1;
		operator = "未";
	}
	void pushCalc() //「=」が押された時の処理
	{
		if(state == 0 || state==1 || state==3) {
			state = 3;
			display = num1;
		}else if(state == 2) {
			num1 = calc();
			num2 = 0;
			state = 3;
			display = num1;
		}
		operator="未";//誤りを防ぐための追加
	}
	
	String output() {//結果表示用のメソッド
		return Integer.toString(display);
	}
	int calc()//operatorに保持されている演算子に応じて,num1,num2の演算を行い,結果を戻り値とする
	{
		if(operator.equals("+")) {//「+」が押された時の処理
			return num1+num2;//num1+num2の計算を行う
		}
		else if(operator.equals("-")) {//「-」が押された時の処理
			return num1-num2;//num1-num2の計算を行う
		}
		else if(operator.equals("*")) {//「*」が押された時の処理
			return num1*num2;//num1*num2の計算を行う
		}
		else if(operator.equals("/")) {//「/」が押された時の処理
			return num1/num2;//num1/num2の計算を行う
		}
		return  0;//エラー処理
	}
	void show()//電卓の現在の状態を表示
	{
		System.out.println("state:"+state+" num1:"+num1+" num2:"+num2+" operator:"+operator+" display:"+display);//コンソール上に現在の状態を表示
	}
	
	

	public static void main(String[] args) {//mainメソッドで動作テストを行う
		Dentaku d = new Dentaku();//Dentakuクラスのオブジェクトの作成
		d.pushNum(1);//1ボタンが押された時
		d.show();//1ボタンが押された時の結果処理
		d.pushNum(2);//2ボタンが押された時
		d.show();//2ボタンが押された時の結果処理
		d.pushNum(3);//3ボタンが押された時
		d.show();//3ボタンが押された押された時の結果表示
		d.pushOp("+");//+ボタンが押された時
		d.show();//+ボタンが押された押された時の結果表示
		d.pushNum(4);//4ボタンが押された時
		d.show();//4ボタンが押された押された時の結果表示
		d.pushNum(5);//5ボタンが押された時
		d.show();//5ボタンが押された押された時の結果表示
		d.pushCalc();//=ボタンが押された時
		d.show();//=ボタンが押された押された時の結果表示
		d.pushNum(1);//1ボタンが押された時
		d.show();//1ボタンが押された押された時の結果表示
		d.pushNum(2);//2ボタンが押された時
		d.show();//2ボタンが押された押された時の結果表示
		d.pushNum(3);//3ボタンが押された時
		d.show();//3ボタンが押された押された時の結果表示
		System.out.println("=>"+d.output());
	}

}


abstract class NewtonMethod {
	int iter;  //繰り返し回数
	int status; //計算の状態
	double oldx, newx; // 現在のx,次のx
	boolean trace=true; //boolean型としてtrueと設定
	
	abstract double f(double x);//f(x)=0となる解を求める
	abstract double df(double x);//f(x)の
	//引数のx0を初期値としてニュートン方を適用
	public void solve(double x0) {
		double TOL = 1.0E-7, TINY=0.0;//許容誤差.最大値
		int MAX = 100;//最大繰り返し回数
		double fx,fdx;//
		newx = oldx = x0;
		status = 9;
		iter=0;
		while(iter<MAX) {//最大繰り返し回数まで繰り返し
			if(trace) System.out.println(">Newtonmethod:i="+iter+",x="+newx);
			iter++;
			fx=f(oldx);//f(x)を計算
			fdx=df(oldx);//f(x)の微分を計算
			if(Math.abs(fdx)<TINY) {//微分df(x)が0となったときは異常終了
				status=8;
				break;
			}
			newx = oldx-fx/fdx;//ニュートン法による更新
			
			if(Math.abs(newx-oldx)<=TOL) {//現在のoldxと次のnewxの差が許容誤差範囲内なら正常終了
				status=0;
				break;//処理を正常終了
			}
			oldx = newx;//oldxの更新
		}
		message();//メッセージの呼び出す
	}
	public void message() {//計算結果に関するメッセージ
		switch(status) {//switch文を使って収束するか計算不能かを判定
		case 8://statusが8の時
			System.out.println(">NewtonMethod:f'(x)=0"+iter);//微分が0となり計算不能
			break;//処理終了
		case 9://statusが9の時
			System.out.println(">NewtonMethod: Not converged after"+iter+",current value is"+ newx);//計算結果が収束しなかった
			break;//処理終了
		}
	}
}




















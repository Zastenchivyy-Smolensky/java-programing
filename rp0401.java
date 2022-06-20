
public class rp0401 extends NewtonMethod
{
	double f(double x) {//f(x)=0となる解を求める
		return x*x*x*x-3.1*x*x*x+2.1*x*x+0.01;
		
	}
	double df(double x) {// f'(x) ※f(x)の微分
		return 4*x*x*x-9.3*x*x+4.2*x;
	}
	void result() {
		if(status==0) {
			System.out.println("方程式:x="+newx+"です");
		}
	}
	public static void main(String args[]) {
		rp0401 nw = new rp0401();
		System.out.println("学籍番号20c2007影山亮太");//学籍番号を表示
		System.out.println("レポート課題4-2newton法による解法");//題名表示
		System.out.println("方程式: x^4+x^3-x^2-5x+3 == 0");//式を表示
		
		double x0 = -0.5;//1つ目の解を求める
		System.out.println("¥n 初期値x0="+x0+"で解を求める");
		nw.solve(x0);//初期値x0=1で方程式をとく
		nw.result();//結果表示
		
		//2つ目の解を求める
		x0=0.8;
		System.out.println("¥n初期値 x0="+x0+"で解を求める");
		nw.solve(x0);//初期値x0=1で方程式をとく
		nw.result();//結果表示
		
		//3つ目の解を求める
		x0=1.0;
		System.out.println("¥n初期値 x0="+x0+"で解を求める");
		nw.solve(x0);//初期値x0=1で方程式をとく
		nw.result();//結果表示
		
		//4つ目の解を求める
		x0=5.0;
		System.out.println("¥n初期値 x0="+x0+"で解を求める");
		nw.solve(x0);//初期値x0=1で方程式をとく
		nw.result();//結果表示
	}

}

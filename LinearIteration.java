abstract class LinearIteration // 線形反復法（抽象クラスとして定義）
{
	double newx, oldx;
	int iter;
	int status;
	boolean trace = true;
	
	
	// f(x)とg(x)を抽象メソッドとして定義
	// LinearIterationクラスを継承したクラスが抽象メソッドを
	// オーバーライド（上書き）してメソッドの中身をつくる。
	abstract double g(double x); 
	abstract double f(double x);
	
	public void solve(double x0)
	{
		double TOL = 1.0E-7; // 許容誤差
		int MAX = 100; // 反復回数の最大値

		newx = oldx = x0;
		iter = 0;
		status = 9;
		
		if(trace) System.out.println("x"+iter+"="+oldx);
		while(iter < MAX){
			newx = g(oldx);
			iter++;
			if(trace) System.out.println("x"+iter+"="+newx);
			if(Math.abs(newx-oldx)<TOL){
				status = 0;
				if(trace) System.out.println("f(x)="+f(newx));
				break;
			}
			oldx = newx;
		}
	}
}

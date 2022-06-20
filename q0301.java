public class q0301 extends LinearIteration
{
	double g(double x) { // 抽象メソッドをオーバーライド
		return Math.sqrt((-x*x*x+1.3*x+2.2)/1.9);
	}
	
	double f(double x) { // 抽象メソッドをオーバーライド
		return x*x*x+1.9*x*x-1.3*x-2.2;
	}

	public static void main(String args[])
	{
		q0301 li = new q0301();
		double x0 = 1.0;
		
		System.out.println("問3.1 線形反復法");
		li.solve(x0);
	
		if(li.status==0){
			System.out.println("方程式の解は x="+li.newx+" です。");
		}
		else {
			System.out.println("方程式は、解けませんでした。");
		}
	}
}

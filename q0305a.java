
public class q0305a extends NewtonMethod
{
	double f(double x) {
		return Math.tan(x)-x;
	}
	double df(double x) {
		double c = Math.cos(x);
		return 1/(c*c)-1;
	}
	public static void main(String[] args) {
		q0305a nw = new q0305a();
		System.out.println("問3.5 Newton法による解法");
		nw.solve(3*Math.PI/2-0.01);
		if(nw.status==0) {
			System.out.println("方程式の解はx="+nw.newx);
			System.out.println("方程式の値はf(x)="+nw.f(nw.newx));
		}else {
			System.out.println("方程式の解はえられませんでした");
		}
 	}

}

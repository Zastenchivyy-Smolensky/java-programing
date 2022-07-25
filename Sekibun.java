interface Func1 {
	double f(double x);
}

class Sin implements Func1{
	public double f(double x)
	{
		return Math.sin(x);
	}
}

public class Sekibun {
	double daikei(Func1 func, double a, double b, int n)
	{
		double h = (b-a)/n;
		double z = func.f(a)+func.f(b);
		
		for(int i=1; i<n; i++){
			double x = i*h;
			z += 2*func.f(x);
		}
		return h*z/2;
	}
	
	double simpson(Func1 func, double a, double b, int n)
	{
		if(n%2==1) {
			System.out.println("エラー: nは偶数のみ");
			return 0;
		}
		double h = (b-a)/n;
		double z = func.f(a)+func.f(b);
		
		for(int i=1; i<n; i++){
			double x = i*h;
			if(i%2==1)	z += 4*func.f(x);
			else z += 2*func.f(x);
		}
		return h*z/3;
	}
	
	double gauss2(Func1 func, double a, double b)
	{
		double[] x = new double[] {0.57735026918926};
		double[] al = new double[] {1.0};
		
		double w = (b - a)/2;
		
		double y0 = w - w*x[0] + a;
		double y1 = w + w*x[0] + a;
		
		return (al[0]*func.f(y0)+al[0]*func.f(y1))*w;
	}
	
	double gauss5(Func1 func, double a, double b)
	{
		double[] x = new double[] {0.0, 0.538469310105683, 0.906179845938664};
		double[] al = new double[] {0.568888888888889, 0.478628670499366, 0.236926885056189};
		
		double w = (b - a)/2;
		
		double y0 = w - w*x[2] + a;
		double y1 = w - w*x[1] + a;
		double y2 = w + a;
		double y3 = w + w*x[1] + a;
		double y4 = w + w*x[2] + a;
		
		return (al[2]*func.f(y0)+al[1]*func.f(y1)+al[0]*func.f(y2)+al[1]*func.f(y3)+al[2]*func.f(y4))*w;
	}
	
	
	public static void main(String args[])
	{
		Sekibun s = new Sekibun();
		Func1 f1 = new Sin();
		int n = 10;
		
		double z = s.daikei(f1,0.0,Math.PI/2,n);
		double e = 1-z;
		System.out.println("台形則("+n+"区間)   z = "+z+" 誤差("+e+")");

		z = s.simpson(f1,0,Math.PI/2,n);
		e = 1-z;
		System.out.println("Simpson法("+n+"区間) z = "+z+" 誤差("+e+")");
		
		z = s.gauss2(f1,0,Math.PI/2);
		e = 1-z;
		System.out.println("Gauss法(2点)     z = "+z+" 誤差("+e+")");

		z = s.gauss5(f1,0,Math.PI/2);
		e = 1-z;
		System.out.println("Gauss法(5点)     z = "+z+" 誤差("+e+")");
		
	}
}



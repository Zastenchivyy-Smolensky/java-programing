
public class Osc {
	double x,y;
	double kx1,ky1, kx2,ky2, kx3,ky3, kx4,ky4;
	double x1,y1;
	double h;
	double t;
	public Osc()
	{
		x=y=0;
		t=0;
	}
	public double fx(double t, double x, double y)
	{
		return y;
	}
	public double fy(double t, double x, double y)
	{
		return -x;
	}
	void rk() {//ルンゲクッタ法
		kx1=h*fx(t,x,y);
		ky1=h*fy(t,x,y);
		kx2=h*fx(t+h/2,x+kx1/2,y+ky1/2);
		ky2=h*fy(t+h/2,x+kx1/2,y+ky1/2);
		kx3=h*fx(t+h/2,x+kx2/2,y+ky2/2);
		ky3=h*fy(t+h/2,x+kx2/2,y+ky2/2);
		
		kx4=h*fx(t+h,x+kx3,y+ky3);
		ky4=h*fy(t+h,x+kx3,y+ky3);
		x1=x+(kx1+2*kx2+2*kx3+kx4)/6;
		y1=y+(ky1+2*ky2+2*ky3+ky4)/6;
	}
	void eu() {
		kx1=h*fx(t,x,y);
		ky1=h*fy(t,x,y);
		x1=x+kx1;
		y1=y+ky1;
	}
	void update() {
		x=x1;
		y=y1;
		t+=h;
	}

	public static void main(String[] args) {
		Osc o = new Osc();
		double alpha = 7;
		double x0 = alpha*Math.sqrt(1-(alpha/100)),y0=alpha*Math.sqrt(alpha/100);
		double C = Math.sqrt(x0*x0+y0*y0);
		o.x = x0; o.y=y0;
		o.h=0.1;
		System.out.println("20c2007 影山亮太");
		System.out.println(o.t+"¥t"+o.x+"¥t"+o.y);
		for(int i=0; i<1000;i++) {
			o.eu();
			o.rk();
			o.update();
			System.out.println(o.t+"¥t"+o.x+"¥t"+o.y);
		}
	}

}

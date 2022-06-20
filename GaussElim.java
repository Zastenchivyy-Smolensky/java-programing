public class GaussElim extends SimpleMatrix
{
	double A[][]; // n×n行列
	double b[];   // n次元 列ベクトル
	int status = 9;
	public GaussElim(double[][] A, double[] b)
	{
		setSize(A.length);
		this.A = newMatrix(); copy(A,this.A);
		this.b = newVector(); copy(b,this.b);
	}
	public void solve(double x[])
	{
		status = 0;
		double TINY = 1.0e-10;
		// 前進消去
		for(int k=0; k<(n-1); k++){
			if(Math.abs(A[k][k])<TINY){
				status = 9;
				return;
			}
			double d_k = 1/A[k][k];
			
			for(int i=k+1; i<n; i++) {
				double m_ik = A[i][k]*d_k;
				A[i][k]=0;
				for(int j=k+1;j<n; j++) {
					A[i][j] -= m_ik*A[k][j];
				}
				b[i] -= m_ik*b[k];
			}	
		}
		// 後退代入
		for(int i=n-1; i>=0; i--){
			if(Math.abs(A[i][i])<TINY){
				status = 9;
				return;
			}
			x[i] = b[i];
			for(int j=i+1;j<n;j++) {
				x[i]-= A[i][j]*x[j];
			}
			x[i]/=A[i][i];	
		}
	}
	public static void main(String args[])
	{
		double[][] A = new double[][] {{2,3,-1},{4,4,-3},{2,-3,1}};
		double[]   b = new double[] {5,3,-1};
		double[]   x = new double[3];
		double[]   r = new double[3];

		GaussElim s = new GaussElim(A,b);
		s.solve(x);
		System.out.println("例題4.1");
		System.out.println("A=¥n"+s.str(A));
		System.out.println("B=¥n"+s.str(b));
		
		
		

		if(s.status==0){
			System.out.println("解 x=\n"+s.str(x));
			s.zansa(A,b,x,r);
			System.out.println("残差 r=\n"+s.str(r));
		}
		else{
			System.out.println("Error: 体格要素がなかったので計算を停止します");
		}
	}
}
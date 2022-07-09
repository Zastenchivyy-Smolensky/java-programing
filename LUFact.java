public class LUFact extends SimpleMatrix//SimpleMatrixのファイルの中身の情報を継承している
{
	double[][] A;   //nxn行列
	double[][] L;   //下三角行列
	double[][] U;   //上三角行列
	double[] y;     //ｎ次元

	int status = 9;   //演算結果の状態表示用の変数０の場合は計算が正常修了

	//行列のサイズｎを設定して、LU分解で用いる行列、ベクトルを準備
	public void setSize(int n)
	{
		this.n = n; 
		this.A = newMatrix();
		this.L = newMatrix();  
		this.U = newMatrix();
		this.y = newVector();
	}
	
	//LU分解を行う行列を引数で渡し、オブジェクトの変数Aにコピー
	public void setA(double[][] A)
	{
		copy(A,this.A);
	}
	//行列AのLU分解を行う
	public void LUbunkai()
	{
		double TINY = 1.0e-10;   //TINYを10の-10乗に設定
		
		status = 0;
		
		for(int i=0; i<n; i++)
		{
			for(int j=i; j<n; j++) 
			{
				L[j][i] =A[j][i];   //L[j][i]を計算
				for(int k=0; k<i; k++) 
				{
					L[j][i] -= L[j][k]*U[k][i];
				}
			}
			
			//対角項L[i][i]の絶対値がTINYより小さい場合は、エラー(割り算ができない)
			if(Math.abs(L[i][i])<TINY) 
			{ 
				status = 9;
				return;
			}
			
			U[i][i] = 1;   //Crout法より、u[i][i]=1

			for(int j=i+1; j<n; j++)
			{
				U[i][j]=A[i][j];   //U[i][j]を計算
				for(int k=0; k<i; k++)
				{
					U[i][j] -= L[i][k]*U[k][j];
				}
				
				U[i][j] /= L[i][i];
			}
		}
	}
	
	//LU分解の結果を用いて、連立方程式Ax=bを解く
	public void solve(double[] b, double[] x)
	{
		//LU分解が失敗しているときはエラー
		if(status!=0)
		{
			System.out.println(">LUFact: Failed! System is singular."); //エラーが出た場合の表示の設定
			return;
		}
		
		//Ly = bを解いて、yを求める
		for(int i=0; i<n; i++)
		{
			y[i] = b[i];   //y[i]を計算する
			
			for(int j=0; j<i; j++) 
			{
				y[i] -= L[i][j]*y[j];
			}
			
			y[i] /= L[i][i];
		}
		
		//Ux = yを後退代入で解いて
		for(int i=n-1; i>=0; i--)
		{
			x[i] = y[i];   //x[i]を計算する
			
			for(int j=i+1;j<n;j++) 
			{
				x[i] -= U[i][j]*x[j];
			}
		}
	}
	
	public static void main(String args[])
	{
		double[][] A = new double[][]    //係数行列A
				{ 
			        {3, -3, -6},
					{4, -7, 1},
					{1, -3, -9}
				};
				
		double[] b = new double[]   //係数行列B(今回はx0,x1,x2の値が自分の学籍番号下３桁になるように設定) 
				{  
					-42,
					7,
					-63
				};
		
		double[] x = new double[3];   //解ベクトルx
		double[] r = new double[3];   //残差ベクトルr
		
		System.out.println("20c2007　影山亮太");           //学籍番号、氏名、課題番号を表示
		System.out.println("レポート課題4　LU分解を用いた解法");   //今回選択した課題
		
		LUFact s = new LUFact();   //LUFactクラスのオブジェクトを生成
		
		s.setSize(3);   //オブジェクトに行列サイズ3を設定
		s.setA(A);      //オブジェクトに係数行列Aを設定
		s.LUbunkai();   //係数行列AをLU分解
		
		System.out.println("A=\n"+s.str(A));    //係数行列A、オブジェクトに格納されている行列L,Uを出力
		System.out.println("L=\n"+s.str(s.L));
		System.out.println("U=\n"+s.str(s.U));
		
		s.solve(b, x);   //連立方程式を解く（solveメゾット）
		
		System.out.println("b=\n"+s.str(b));   //係数ベクトルｂ、解ｘを出力
		System.out.println("x=\n"+s.str(x));    
		System.out.println("y=\n"+s.str(s.y));
		
		s.zansa(A, b, x, r);   //解の残差ｒを計算し出力
		
		System.out.println("r=\n"+s.str(r));   //SimpleMatrixクラスのzannsaメゾットを使用
	}
}

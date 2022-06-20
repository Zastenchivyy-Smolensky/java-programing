public class SimpleMatrix
{
	/* 行列, ベクトルのサイズを表す．(n×n行列，n次元ベクトル) */
	int n;

	/* 行列，ベクトルのサイズを設定する．*/
	public void setSize(int n)
	{
		this.n = n;
	}

	/* 新しい n×n行列を作成して返す. */
	public double[][] newMatrix()
	{
		return new double[n][n];
	}

	/* 新しい n×n次元ベクトルを作成して返す. */
	public double[] newVector()
	{
		return new double[n];
	}

	/* 行列a1の内容を行列a2にコピーする． */
	public void copy(double[][] a1, double[][] a2)
	{
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				a2[i][j] = a1[i][j];
	}

	/* ベクトルv1の内容をベクトルv2にコピーする．*/
	public void copy(double[] v1, double[] v2)
	{
		for(int i=0; i<n; i++)
			v2[i] = v1[i];
	}

	/* 行列 aを文字列に変換して返す．*/
	public String str(double[][] a)
	{
		String s = "";
		for(int i=0; i<n; i++) {
			s += "|";
			for(int j=0; j<n; j++)
				s += " "+a[i][j]+" ";
			s +="|\n";
		}
		return s;
	}

	/* ベクトル vを文字列に変換して返す． */
	public String str(double[] v)
	{
		String s = "";
		for(int i=0; i<n; i++)
			s += "|"+v[i]+"|\n";
		return s;
	}

	/* 連立方程式の解の残差 r = A x - b を計算する．*/
	public void zansa(double[][] A, double[] b, double[] x, double[] r)
	{
		double[] c = newVector();
		seki(A,x,c);
		sa(c,b,r);
	}

	/* 行列とベクトルの積 c = A×b を計算する． */
	public void seki(double[][] A, double[] b, double[] c)
	{
		for(int i=0; i<n; i++){
			c[i]=0;
			for(int j=0; j<n; j++){
				c[i] += A[i][j]*b[j];
			}
		}
	}

	/* ベクトルの差 c = a－b を計算する． */
	public void sa(double[] a, double[] b, double[] c)
	{
		for(int i=0; i<n; i++){
			c[i] = a[i]-b[i];
		}
	}

	/* 行列の和 C = A＋B を計算する． */
	public void wa(double[][] A, double[][] B, double[][] C)
	{
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				C[i][j] = A[i][j]+B[i][j];
			}
		}
	}

	/* 行列の積 C = A×B を計算する． */
	public void seki(double[][] A, double[][] B, double[][] C)
	{
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				C[i][j]=0;
				for(int k=0; k<n; k++){
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
	}
}

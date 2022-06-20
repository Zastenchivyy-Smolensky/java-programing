public class RensyuMatrix extends SimpleMatrix
{
	//練習
	public void rensyu()
	{
		// 行列のベクトルのサイズを設定
		//n = 2;
		setSize(2);
		// 2x2行列の定義
		// 通常の場合
		// double[][] A = new double[2][2];
		// SimpleMatrixクラスを使う場合
		double[][] A = newMatrix();

		// 2次元ベクトルの定義
		// double[] x = new double[2];
		double[] x = newVector();
		double[] b = newVector();

		A[0][0]=1;  A[0][1]=2;
		A[1][0]=-1; A[1][1]=1;

		x[0]=1; x[1]=2;

		// 行列Aとベクトルxを出力
		System.out.println("A=");
		System.out.println(str(A));

		System.out.println("x=");
		System.out.println(str(x));

		// Aとxの積を計算し結果をbに代入する。
		seki(A, x, b);
		// bを表示する。
		System.out.println("Ax=b, b=");
		System.out.println(str(b));

		// 行列 Bの定義
		double[][] B = newMatrix();
		B[0][0]=3; B[0][1]=1;
		B[1][0]=4; B[1][1]=2;
		//行列 Cの定義
		double[][] C = newMatrix();

		wa(A,B,C); // AとBの和を計算してCに代入
		System.out.println("A+B=C, C=");
		System.out.println(str(C));

		seki(A,B,C); // AとBの積を計算してCに代入
		System.out.println("A*B=C, C=");
		System.out.println(str(C));
	}

	public static void main(String args[])
	{
		RensyuMatrix test = new RensyuMatrix(); // SimpleMatrixクラスのオブジェクトを作成
		test.rensyu(); // rensyu()メソッドを実行
	}
}

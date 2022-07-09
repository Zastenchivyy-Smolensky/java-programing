package GyakuGyouretsu.copy;
public class GyakuGyouretsu extends LUFact 
{ 

/* LU 分解を行い、行列 A の逆行列 X を計算する */ 
public void gyakuGyouretsu(double[][] X) 
{ 

// LU 分解を行う 
// LUFact クラスで作成した LUbunkai メソッドを用いる 

// LU 分解に失敗した場合はエラー 
if(status!=0){ 

System.out.println(">LUFact: Failed! System is singular."); 
return; 

} 
// 演算用の n 次元ベクトル b, x を用意 
double[] b = newVector(); 
double[] x = newVector(); 

// 逆行列 X の各列(i 列)を LU 分解の結果を用いて解く 
for(int i=0; i<n; i++){ 

// ベクトル b の第 i 番目の要素が 1、それ以外の要素は 0 とする。 

// A x = b を解き x を得る 
// LUFact クラスで作成した sovle メソッドを用いる 

// 解 x を 逆行列 X の第 i 列にコピーする 

} 

} 
public static void main(String args[]) 
{ 

double[][] A = new double[][] { // 逆行列を計算する行列 

{2, 3, -1}, 
{4, 4, -3}, 
{2, -3, 1}}; 
double[][] X = new double[3][3]; //計算結果の逆行列を格納する 
double[][] I = new double[3][3]; //検算結果の A と X の積を格納する 
// GyakuGyouretsu クラスのオブジェクトを生成 
GyakuGyouretsu s = new GyakuGyouretsu(); 
// オブジェクトに行列のサイズ 3 を設定 
s.setSize(3); 
// オブジェクトに行列 A を設定 
s.setA(A); 
// 行列 A を出力 
System.out.println("A=\n"+s.str(A)); 
// 逆行列の計算を行う 
s.gyakuGyouretsu(X);  
// オブジェクトに格納されている 行列 L, U を出力 
System.out.println("L=\n"+s.str(s.L)); // 結果の表示 
System.out.println("U=\n"+s.str(s.U)); 
// 計算結果の逆行列 X を出力 
System.out.println("X=\n"+s.str(X)); 
// 検算として A と X の積を計算し結果を出力する 
// SimpleMatrix クラスの seki メソッドを完成させて使用する。 
s.seki(A,X,I); 
System.out.println("AX=I=\n"+s.str(I)); 

} 

} 
public class Ensyu0103 {//クラスを宣言している
	public static void main(String[] args) {//おまじない
		 	int[] data = {91,82,65,73,85,67,95,70,55,68};//配列形式で各要素を格納している.
	        int sum = 0;//合計sumを初期化していて初期値には0を格納している.
	        float average = 0;//平均値averageを初期化していて初期値には0を格納している.
	        System.out.println("学籍番号20c2007 氏名 影山亮太");//学籍番号と氏名をコンソール上で出力させている
	    	System.out.println("2022年4月15日");//日付を出力している
	        System.out.println(data.length+"個のデータの合計と平均を計算します");//コンソール上で配列の中に格納された要素の合計を出力している
		       for(int value : data) {//拡張for文を使って配列形式でdataに格納されている要素を一つずつ取り出してvalueに格納
		    	   sum += value;
		        }
	        average = (float)sum/data.length;//dataに格納されている要素数の合計sumと要素数を使って,平均を出している.
	        //その際にaverageには,float型で格納されるようにするためにキャストを使って型変換を行っている.
	    	System.out.println("10個のデータの合計と平均を計算します");//文字列を出力している
	        System.out.println("¥n合計="+sum+"平均="+average);//合計sumと平均値averageを出力してこのプログラムは終了である.
	}
}

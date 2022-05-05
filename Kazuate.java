import java.util.*;
public class Kazuate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = (int)(Math.random()*20)+1;

		System.out.print("1桁目を入力");
		int x = sc.nextInt();
		System.out.print("2桁目を入力");
		int y = sc.nextInt();
		System.out.print("3桁目を入力");
		int z = sc.nextInt();
		int T = x+y+z;
		while(T!=a) {
			System.out.println("違います");
			if(x>a) {
				System.out.println("大きい");
			}else {
				System.out.println("小さい");
			}
			System.out.print("1桁目を入力");
			int x = sc.nextInt();
			System.out.print("2桁目を入力");
			int y = sc.nextInt();
			System.out.print("3桁目を入力");
			int z = sc.nextInt();
		}
		System.out.println("当たりです");
	}
}

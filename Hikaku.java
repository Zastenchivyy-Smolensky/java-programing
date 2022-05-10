public class Hikaku {
	int num;
	int data[];
	public Hikaku(int n) {
		num=n;
		data = new int[n];
	}
	void set_data(int i, int x) {
		data[i] = x;
	}
	int get_max(){
		int max = data[0];
		for(int i=1;i<num;i++) {
			if(max<data[i])max=data[i];
		}
		return max;
	}
	int get_min() {
		int min = data[0];
		for(int i=1;i<num;i++) {
			if(min > data[i])min=data[i];
		}
		return min;
	}
	public static void main(String args[]) {
		Hikaku obj = new Hikaku(3);
		obj.set_data(0, 30);
		obj.set_data(1, 20);
		obj.set_data(2, 10);
		
		System.out.println("最大値"+obj.get_max()+"です");
		System.out.println("最小値"+obj.get_min()+"です");
	}
}

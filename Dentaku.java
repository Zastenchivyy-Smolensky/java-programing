public class Dentaku {
	int num1;
	int num2;
	int display;
	String operator;
	int state;
	
	public Dentaku() {
		num1=0;
		num2=0;
		state=0;
		display=num1;
		operator="未";
	}
	void pushNum(int n) {
		if(state == 0 || state==3) {
			num1 = n;
			state=1;
			display = num1;
		}else if(state==1) {
			num1 = num1*10+n;
			state =1;
			display = num1; 
		}else if(state==2) {
			num2 = num2*10+n;
			state = 2;
			display = num2;
		}
	}
	void pushOp(String op) 
	{
		if(state == 0 || state==1 || state==3) {
			operator =op; 
			state = 2;
			display = num1;
		}else if(state == 2) {
			num1 = calc();
			num2 = 0;
			operator = op;
			state = 2;
			display = num1; 
		}
	}
	void pushClear()
	{
		num1 = 0;
		num2 = 0;
		state = 0;
		display = num1;
		operator = "未";
	}
	void pushCalc()
	{
		if(state == 0 || state==1 || state==3) {
			state = 3;
			display = num1;
		}else if(state == 2) {
			num1 = calc();
			num2 = 0;
			state = 3;
			display = num1;
		}
		operator="未";
	}
	String output() {
		return Integer.toString(display);
	}
	int calc()
	{
		if(operator.equals("+")) {
			return num1+num2;
		}
		else if(operator.equals("-")) {
			return num1-num2;
		}
		else if(operator.equals("*")) {
			return num1*num2;
		}
		else if(operator.equals("/")) {
			return num1/num2;
		}
		return  0;
	}
	void show()
	{
		System.out.println("state:"+state+" num1:"+num1+" num2:"+num2+" operator:"+operator+" display:"+display);
	}
	
	

	public static void main(String[] args) {
		Dentaku d = new Dentaku();
		d.pushNum(1);
		d.show();
		d.pushNum(2);
		d.show();
		d.pushNum(3);
		d.show();
		d.pushOp("+");
		d.show();
		d.pushNum(4);
		d.show();
		d.pushNum(5);
		d.show();
		d.pushCalc();
		d.show();
		d.pushNum(1);
		d.show();
		d.pushNum(2);
		d.show();
		d.pushNum(3);
		d.show();
		System.out.println("=>"+d.output());
	}

}

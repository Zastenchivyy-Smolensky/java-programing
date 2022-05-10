
public class Janken {
	int PlayerA;
	int PlayerB;
	String action[] = {"グー","チョキ","パー","未設定"};
	String message[] = {"引き分け","Aの勝ち","Bの勝ち","エラー"};
	public Janken() 
	{
		PlayerA = 3;
		PlayerB = 3;
	}
	void setPlayerA(String com)
	{
		if(com.equals("グー")) PlayerA=0;
		else if(com.equals("チョキ")) PlayerA=1;
		else if(com.equals("パー")) PlayerA=2;
		else PlayerA = 3;
	}
	void setPlayerB_random()
	{
		PlayerB=(int)(3*Math.random());
	}
	String getPlayerA() {
		return action[PlayerA];
	}
	String getPlayerB() {
		return action[PlayerB];
	}
	int judge() {
		int res;
		//簡単なやり方
		if (PlayerA >=0 && PlayerB <3 && PlayerB >= 0 && PlayerB <3) {
			res = (PlayerB-PlayerA+3)%3;
		}else {
			res = 3;
		}
		return res;
	}
	String result() {
		int res = judge();
		return message[res];
	}
	public static void main(String args[])
	{
		Janken jkn = new Janken();
		jkn.setPlayerA("パー");
		jkn.setPlayerB_random();
		
		System.out.println("PlayerAの手は"+jkn.getPlayerA()+"です");
		System.out.println("PlayerBの手は"+jkn.getPlayerB()+"です");
		System.out.println("result:"+jkn.result());
	}
}

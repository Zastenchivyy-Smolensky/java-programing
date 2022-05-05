import java.io.*;
public class Ensyu0102 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X,Y;
		System.out.println("X =");
		X=Integer.parseInt(br.readLine());
		System.out.println("Y =");
		Y=Integer.parseInt(br.readLine());
		
		System.out.println("X+Y =" + (X+Y));
		System.out.println("X-Y =" + (X-Y));
		System.out.println("X*Y =" + (X*Y));
		System.out.println("X/Y =" + ((double)X/(double)Y));

	}

}

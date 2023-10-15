import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		switch (N % 8) {
			case 0:
			case 2:
				System.out.print(2);
				break;
			case 1:
				System.out.print(1);
				break;
			case 3:
			case 7:
				System.out.print(3);
				break;
			case 4:
			case 6:
				System.out.print(4);
				break;
			case 5:
				System.out.print(5);
		}
	
	}
	
}
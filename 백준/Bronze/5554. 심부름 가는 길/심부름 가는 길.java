import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		System.out.print(sum / 60 + "\n" + sum % 60);
		
	}
	
}
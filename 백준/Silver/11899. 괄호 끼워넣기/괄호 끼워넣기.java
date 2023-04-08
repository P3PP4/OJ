import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '(') sum++;
			else {
				if (0 < sum) sum--;
				else cnt++;
			}
		}
		
		System.out.print(cnt + sum);
	
	}
	
}
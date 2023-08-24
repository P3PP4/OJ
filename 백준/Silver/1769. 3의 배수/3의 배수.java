import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int cnt = 0;
		while (1 < input.length()) {
			int newNum = 0;
			for (int i = 0; i < input.length(); i++) {
				newNum += input.charAt(i) - '0';
			}
			input = newNum + "";
			cnt++;
		}
		System.out.print(cnt + "\n" + (Integer.parseInt(input) % 3 == 0 ? "YES" : "NO"));
	
	}
	
}
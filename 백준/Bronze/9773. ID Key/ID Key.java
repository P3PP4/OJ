import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int result = 0;
			String input = br.readLine();
			for (int j = 0; j < 13; j++) {
				result += input.charAt(j) - '0';
			}
			result += Integer.parseInt(input.substring(10, 13)) * 10;
			sb.append(String.format("%04d", result > 9999 ? result - 10000 : result < 1000 ? result + 1000 : result)).append("\n");
		}
		System.out.print(sb);
		
	}
	
}
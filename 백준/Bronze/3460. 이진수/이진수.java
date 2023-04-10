import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String N = Integer.toBinaryString(Integer.parseInt(br.readLine()));
			int len = N.length() - 1;
			for (int j = 0; j <= len; j++) {
				if (N.charAt(len - j) == '1') sb.append(j).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}
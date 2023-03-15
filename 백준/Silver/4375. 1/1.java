import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		while (true) {
			
			String s = br.readLine();
			if (s == null || s.isEmpty() || "".equals(s)) break;
			
			long unit = Long.parseLong(s);
			long num = 1;
			int len = 1;
			
			while (num % unit != 0) {
				num %= unit;
				num = num * 10 + 1;
				len++;
			}
			
			sb.append(len).append("\n");
			
		}
		
		System.out.print(sb);
	
	}
	
}
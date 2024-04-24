import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			String s = br.readLine().toUpperCase();
			int len = s.length();
			boolean flag = true;
			for (int i = 0; i < len / 2; i++) {
				if (s.charAt(i) != s.charAt(len - 1 - i)) {
					flag = false;
					break;
				}
			}
			if (flag) sb.append("Yes\n");
			else sb.append("No\n");
		}
		System.out.print(sb);
	
	}
	
}
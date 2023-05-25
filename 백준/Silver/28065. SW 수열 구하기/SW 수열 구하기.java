import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int left = 1;
		boolean flag = true;
		while (left <= N) {
			if (flag) sb.append(N--).append(" ");
			else sb.append(left++).append(" ");
			flag = !flag;
		}
		
		System.out.print(sb);
	
	}
	
}
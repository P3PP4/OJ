import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;
			int mod = a % 5;
			if (mod == 2 || mod == 3) b = (b % 4) + 1;
			else if (mod == 4) b = (b % 2) + 1;
			else b = 1;
			
			int c = a;
			for (int i = 2; i <= b; i++) {
				a *= c;
			}
			sb.append(a % 10 == 0 ? 10 : a % 10).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}
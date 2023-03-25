import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				input[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}

			int cnt = N;
			int min = 9999999;
			
			for (int i = 1; i <= N; i++) {
				
				if(input[i] > min) --cnt;
				else min = input[i];
					
			}
			
			sb.append(cnt).append("\n");
			
		}
		
		System.out.print(sb.toString());
		
	}
	
}
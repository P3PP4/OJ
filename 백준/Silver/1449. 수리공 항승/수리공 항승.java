import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		boolean[] lick = new boolean[2001];
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			lick[Integer.parseInt(st.nextToken())] = true;
		}
		
		int cnt = 0;
		for (int i = 1; i <= 1000; i++) {
			if (lick[i]) {
				cnt++;
				for (int j = i; j < i + K; j++) {
					lick[j] = false;
				}
				i += K - 1;
			}
		}
		
		System.out.print(cnt);
	
	}
	
}
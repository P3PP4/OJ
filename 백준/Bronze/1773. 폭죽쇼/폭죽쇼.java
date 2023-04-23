import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[] fire = new boolean[C + 1];
		for (int i = 0; i < N; i++) {
			int time = Integer.parseInt(br.readLine());
			for (int j = time; j <= C; j += time) {
				fire[j] = true;
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= C; i++) {
			if (fire[i]) cnt++;
		}
		
		System.out.print(cnt);
	
	}
	
}
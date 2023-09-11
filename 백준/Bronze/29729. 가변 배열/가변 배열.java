import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for (int i = 0; i < N + M; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 1) {
				if (S < ++cnt) S *= 2;
			} else --cnt;
		}
		System.out.print(S);
	
	}
	
}
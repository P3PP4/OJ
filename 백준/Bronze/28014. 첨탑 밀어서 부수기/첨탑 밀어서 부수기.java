import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		int pre = 0;
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (pre <= now) cnt++;
			pre = now;
		}
		
		System.out.print(cnt);
	
	}
	
}
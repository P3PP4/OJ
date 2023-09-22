import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lr = { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (lr[a] != b && lr[a] != 4) cnt++;
			lr[a] = b;
		}
		System.out.print(cnt);
	
	}
	
}
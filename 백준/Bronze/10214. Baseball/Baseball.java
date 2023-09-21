import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int yp = 0;
			int kp = 0;
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				yp += Integer.parseInt(st.nextToken());
				kp += Integer.parseInt(st.nextToken());
			}
			if (yp == kp) sb.append("Draw\n");
			else if (yp < kp) sb.append("Korea\n");
			else sb.append("Yonsei\n");
		}
		System.out.print(sb);
	
	}
	
}
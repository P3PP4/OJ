import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			int N = Integer.parseInt(br.readLine());
			String max = "";
			int maxL = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String school = st.nextToken();
				int L = Integer.parseInt(st.nextToken());
				if (maxL < L) {
					maxL = L;
					max = school;
				}
			}
			sb.append(max).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}
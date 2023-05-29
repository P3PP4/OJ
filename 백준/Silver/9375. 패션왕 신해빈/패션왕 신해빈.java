import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String s = st.nextToken();
				map.put(s, map.getOrDefault(s, 0) + 1);
			}
			
			int cnt = 1;
			for (Integer value : map.values()) {
				cnt *= value + 1;
			}
			sb.append(cnt - 1).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}
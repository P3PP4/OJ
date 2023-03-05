import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		HashMap<String, Integer> wrong = new HashMap<>();
		HashSet<String> pass = new HashSet<>();
		double passCnt = 0;
		double wrongBeforePass = 0;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			String id = st.nextToken();
			int result = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				st.nextToken();
			}
			
			if ("megalusion".equals(id) || pass.contains(id)) continue;
			
			if (result == 4) {
				passCnt++;
				wrongBeforePass += wrong.getOrDefault(id, 0);
				pass.add(id);
			} else {
				wrong.put(id, wrong.getOrDefault(id, 0) + 1);
			}
			
		}
		
		if (passCnt == 0) System.out.print(0);
		else System.out.print((passCnt / (passCnt + wrongBeforePass)) * 100);
	
	}
	
}

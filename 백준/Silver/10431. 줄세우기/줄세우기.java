import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		int P = Integer.parseInt(br.readLine());
		for (int T = 1; T <= P; T++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(0);
			int result = 0;
			
			for (int i = 1; i <= 20; i++) {
				int now = Integer.parseInt(st.nextToken());
				int index = i;
				
				while (0 <= --index) {
					if (list.get(index) < now) {
						result += list.size() - (index + 1);
						list.add(index + 1, now);
						break;
					}
				}
			}
			
			sb.append(T).append(" ").append(result).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}
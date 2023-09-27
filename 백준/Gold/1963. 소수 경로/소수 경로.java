import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] np = new boolean[10000];
		for (int i = 2; i < 10000; i++) {
			if (!np[i]) {
				for (int j = i + i; j < 10000; j += i) {
					np[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
x:		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String from = st.nextToken();
			String to = st.nextToken();
			
			Queue<String> q = new LinkedList<>();
			int[] visited = new int[10000];
			q.offer(from);
			visited[Integer.parseInt(from)] = 1;
			
			while (!q.isEmpty()) {
				String s = q.poll();
				int n = Integer.parseInt(s);
				
				if (s.equals(to)) {
					sb.append(visited[n] - 1).append("\n");
					continue x;
				}
				
				for (int idx = 0; idx < 4; idx++) {
					for (int num = 0; num < 10; num++) {
						String sTemp = s.substring(0, idx) + num + s.substring(idx + 1, 4);
						int nTemp = Integer.parseInt(sTemp);
						if (999 < nTemp && !np[nTemp] && visited[nTemp] == 0) {
							q.offer(sTemp);
							visited[nTemp] = visited[n] + 1;
						}
					}
				}
			}
		}
		System.out.print(sb);
	
	}
	
}
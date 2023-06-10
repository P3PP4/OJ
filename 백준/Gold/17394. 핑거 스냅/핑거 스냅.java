import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		boolean[] np = new boolean[100001];
		for (int i = 2; i < 100001; i++) {
			if (!np[i]) {
				for (int j = i + i; j < 100001; j += i) {
					np[j] = true;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
t:		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (N < 100000 && A <= N && N <= B && !np[N]) {
				sb.append(0).append("\n");
				continue;
			}
			boolean flag = false;
			for (int i = B; i >= A; i--) {
				if (!np[i]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				sb.append(-1).append("\n");
				continue t;
			}
			
			Queue<Integer> q = new LinkedList<>();
			int[] visited = new int[1000001];
			q.offer(N);
			
			while (!q.isEmpty()) {
				int num = q.poll();
				
				if (A <= num && num <= B && !np[num]) {
					sb.append(visited[num]).append("\n");
					continue t;
				}
				
				for (int i = 2; i <= 3; i++) {
					int next = num / i;
					if (visited[next] == 0) {
						q.offer(next);
						visited[next] = visited[num] + 1;
					}
				}
				for (int i = -1; i <= 1; i += 2) {
					int next = num + i;
					if (0 <= next && next < 1000001 && visited[next] == 0) {
						q.offer(next);
						visited[next] = visited[num] + 1;
					}
				}
			}
			
			sb.append(-1).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}
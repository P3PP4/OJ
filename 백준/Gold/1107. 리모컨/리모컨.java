import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] NA = new boolean[10];
		boolean[] num = new boolean[1000001];
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				NA[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int[] visited = new int[1000001];
		Queue<Integer> q = new LinkedList<>();
		visited[100] = 1;
		q.offer(100);
		
		while (!q.isEmpty()) {
			int i = q.poll();
			
			if (i == N) {
				System.out.print(visited[i] - 1);
				return;
			}
			
			if (0 <= i - 1 && visited[i - 1] == 0) {
				visited[i - 1] = visited[i] + 1;
				q.offer(i - 1);
			}
			if (i + 1 < 1000001 && visited[i + 1] == 0) {
				visited[i + 1] = visited[i] + 1;
				q.offer(i + 1);
			}
			
			for (int j = 0; j < 10; j++) {
				if (NA[j]) continue;
				
				if (visited[j] == 0) {
					num[j] = true;
					visited[j] = visited[i] + 1;
					q.offer(j);
				}
				
				int k = i * 10 + j;
				if (num[i] && k < 1000001 && !num[k]) {
					num[k] = true;
					visited[k] = visited[i] + 1;
					q.offer(k);
				}
			}
			
		}
	
	}
	
}
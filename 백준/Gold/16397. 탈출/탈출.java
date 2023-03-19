import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100000];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { N, 0 });
		
		while (!q.isEmpty()) {
			int[] a = q.poll();
			
			if (a[0] == G) {
				System.out.print(a[1]);
				return;
			}
			if (T <= a[1]) continue;
			
			if (a[0] < 99999 && !visited[a[0] + 1]) {
				q.offer(new int[] { a[0] + 1, a[1] + 1 });
				visited[a[0] + 1] = true;
			}
			if (a[0] * 2 < 99999) {
				a[0] *= 2;
				int x = (int) Math.pow(10, (int) Math.log10(a[0]));
				if (visited[a[0] - x]) continue;
				q.offer(new int[] { a[0] - x, a[1] + 1 });
				visited[a[0] - x] = true;
			}
		}
		
		System.out.print("ANG");
	
	}
	
}
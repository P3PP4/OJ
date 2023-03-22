import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, D;
	static char[][] before, after;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		before = new char[N][M];
		after  = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				before[i][j] = input.charAt(j);
				if (before[i][j] == 'O') {
					visited[i][j] = true;
					q.offer(new int[] { i, j });
				}
			}
		}
		D = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			after[i] = br.readLine().toCharArray();
		} // end of input
		
		while (!q.isEmpty()) {
			int[] a = q.poll();
			
			for (int i = a[0] - D; i <= a[0] + D; i++) {
				for (int j = a[1] - D; j <= a[1] + D; j++) {
					if (0 <= i && i < N && 0 <= j && j < M && Math.abs(a[0] - i) + Math.abs(a[1] - j) <= D && after[i][j] == 'O' && !visited[i][j]) {
						visited[i][j] = true;
						q.offer(new int[] { i, j });
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ((after[i][j] == 'O' && !visited[i][j]) || (after[i][j] == 'X' && before[i][j] == 'O')) {
					System.out.print("NO");
					return;
				}
			}
		}
		System.out.print("YES");
		
	}
	
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] input = new char[N][M];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					if (input[i][j] == '|') {
						for (int k = i + 1; k < N && input[k][j] == '|'; k++) {
							visited[k][j] = true;
						}
					} else {
						for (int k = j + 1; k < M && input[i][k] == '-'; k++) {
							visited[i][k] = true;
						}
					}
				}
			}
		}
		
		System.out.print(cnt);
	
	}
	
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][M + 1];
		int[][][] info = new int[3][N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String input = " " + br.readLine();
			for (int j = 1; j <= M; j++) {
				switch (input.charAt(j)) {
					case 'J':
						info[0][i][j] = info[0][i - 1][j] + info[0][i][j - 1] - info[0][i - 1][j - 1] + 1;
						info[1][i][j] = info[1][i - 1][j] + info[1][i][j - 1] - info[1][i - 1][j - 1];
						info[2][i][j] = info[2][i - 1][j] + info[2][i][j - 1] - info[2][i - 1][j - 1];
						break;
					case 'O':
						info[0][i][j] = info[0][i - 1][j] + info[0][i][j - 1] - info[0][i - 1][j - 1];
						info[1][i][j] = info[1][i - 1][j] + info[1][i][j - 1] - info[1][i - 1][j - 1] + 1;
						info[2][i][j] = info[2][i - 1][j] + info[2][i][j - 1] - info[2][i - 1][j - 1];
						break;
					case 'I':
						info[0][i][j] = info[0][i - 1][j] + info[0][i][j - 1] - info[0][i - 1][j - 1];
						info[1][i][j] = info[1][i - 1][j] + info[1][i][j - 1] - info[1][i - 1][j - 1];
						info[2][i][j] = info[2][i - 1][j] + info[2][i][j - 1] - info[2][i - 1][j - 1] + 1;
				}
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			sb.append(info[0][c][d] - info[0][c][b - 1] - info[0][a - 1][d] + info[0][a - 1][b - 1]).append(" ");
			sb.append(info[1][c][d] - info[1][c][b - 1] - info[1][a - 1][d] + info[1][a - 1][b - 1]).append(" ");
			sb.append(info[2][c][d] - info[2][c][b - 1] - info[2][a - 1][d] + info[2][a - 1][b - 1]).append("\n");
		}
		System.out.print(sb);
	
	}
	
}
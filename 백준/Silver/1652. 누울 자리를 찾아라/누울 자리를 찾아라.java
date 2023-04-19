import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // end of input
		
		boolean[][][] visited = new boolean[2][N][N];
		int hor = 0;
		int ver = 0;
		
		// 가로
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (!visited[0][i][j] && !visited[0][i][j + 1] && map[i][j] == '.' && map[i][j + 1] == '.') {
					visited[0][i][j] = true;
					hor++;
					int nj = j + 1;
					while (nj < N && map[i][nj] == '.') {
						visited[0][i][nj++] = true;
					}
				}
			}
		}
		
		// 가로
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[1][i][j] && !visited[1][i + 1][j] && map[i][j] == '.' && map[i + 1][j] == '.') {
					visited[1][i][j] = true;
					ver++;
					int ni = i + 1;
					while (ni < N && map[ni][j] == '.') {
						visited[1][ni++][j] = true;
					}
				}
			}
		}
		
		System.out.print(hor + " " + ver);
		
	}
	
}
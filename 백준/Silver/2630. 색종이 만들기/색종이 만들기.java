import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, white, blue;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		paper(0, 0, N);
		System.out.print(white + "\n" + blue);
	
	}
	
	static void paper(int r, int c, int size) {
		int one = 0;
		int zero = 0;
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] == 1) one++;
				else zero++;
			}
		}
		
		if (one == size * size) blue++;
		else if (zero == size * size) white++;
		else {
			int half = size / 2;
			paper(r, c, half);
			paper(r + half, c, half);
			paper(r, c + half, half);
			paper(r + half, c + half, half);
		}
	}
	
}
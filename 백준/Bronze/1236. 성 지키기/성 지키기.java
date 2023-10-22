import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		boolean[] ver = new boolean[N];
		boolean[] hor = new boolean[M];
		int verCnt = 0;
		int horCnt = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'X') {
					ver[i] = true;
					hor[j] = true;
				}
			}
			if (!ver[i]) verCnt++;
		}
		
		for (int i = 0; i < M; i++) {
			if (!hor[i]) horCnt++;
		}
		
		System.out.print(Math.max(verCnt, horCnt));
	
	}
	
}
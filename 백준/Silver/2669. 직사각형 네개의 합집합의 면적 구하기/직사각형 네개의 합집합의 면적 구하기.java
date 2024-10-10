import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] map = new boolean[100][100];
		int sum = 0;
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			for (int r = sr; r < er; r++) {
				for (int c = sc; c < ec; c++) {
					if (!map[r][c]) {
						map[r][c] = true;
						sum++;
					}
				}
			}
		}
		
		System.out.print(sum);
		
	}
	
}
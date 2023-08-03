import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		int[][] time = new int[H][W];
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(time[i], -1);
			for (int j = 0; j < W; j++) {
				if (time[i][j] == -1 && map[i][j] == 'c') {
					int t = 0;
					for (int k = j; k < W; k++) {
						if (j < k && map[i][k] == 'c') break;
						time[i][k] = t++;
					}
				}
			}
			
			for (int j = 0; j < W; j++) {
				sb.append(time[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
}
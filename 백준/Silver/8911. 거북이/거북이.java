import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int r = 0;
			int c = 0;
			int maxL = 0;
			int maxR = 0;
			int maxU = 0;
			int maxD = 0;
			int dir = 0;
			
			char[] input = br.readLine().toCharArray();
			for (int i = 0; i < input.length; i++) {
				switch (input[i]) {
					case 'F' :
						r += dr[dir];
						c += dc[dir];
						break;
					case 'B':
						r -= dr[dir];
						c -= dc[dir];
						break;
					case 'L':
						dir = dir == 0 ? 3 : dir - 1;
						break;
					case 'R':
						dir = (dir + 1) % 4;
						break;
				}
				
				if (maxU < r) maxU = r;
				if (r < maxD) maxD = r;
				if (maxR < c) maxR = c;
				if (c < maxL) maxL = c;
			}
			
			sb.append((maxR - maxL) * (maxU - maxD)).append("\n");
		}
		System.out.print(sb);
	
	}
	
}
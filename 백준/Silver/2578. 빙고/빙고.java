import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] input = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int call = 1;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				x: for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (input[r][c] == num) {
							input[r][c] = 0;
							break x;
						}
					}
				}
				
				int bingo = 0;
				
				for (int k = 0; k < 5; k++) {
					int ver = 0;
					int hor = 0;
					for (int l = 0; l < 5; l++) {
						if (input[k][l] == 0) hor++;
						if (input[l][k] == 0) ver++;
					}
					if (ver == 5) bingo++;
					if (hor == 5) bingo++;
				}
				
				int rd = 0;
				int ld = 0;
				for (int k = 0; k < 5; k++) {
					if (input[k][k] == 0) rd++;
					if (input[k][4 - k] == 0) ld++;
				}
				if (rd == 5) bingo++;
				if (ld == 5) bingo++;
				
				if (bingo >= 3) {
					System.out.print(call);
					return;
				} else call++;
			}
		}
		
	}
	
}
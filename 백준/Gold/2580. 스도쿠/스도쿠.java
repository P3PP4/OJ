import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] arr;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		
		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of input
		
		fill(0);
		
		System.out.print(sb);
	
	}
	
	static void fill(int index) {
		
		int i = index / 9;
		int j = index % 9;
		
		while (i < 9) {
			if (arr[i][j] == 0) {
				for (int num = 1; num <= 9; num++) {
					if (check(i, j, num)) {
						arr[i][j] = num;
						fill(i * 9 + j + 1);
						if (flag) return;
						arr[i][j] = 0;
					}
				}
				if (arr[i][j] == 0) return;
			}
			if (8 < ++j) {
				j = 0;
				i++;
			}
		}
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(arr[r][c]).append(" ");
			}
			sb.append("\n");
		}
		flag = true;
	
	}
	
	static boolean check(int row, int col, int num) {
		
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == num) return false;
		}
		for (int j = 0; j < 9; j++) {
			if (arr[row][j] == num) return false;
		}
		for (int i = (row / 3) * 3; i < (row / 3 + 1) * 3; i++) {
			for (int j = (col / 3) * 3; j < (col / 3 + 1) * 3; j++) {
				if (arr[i][j] == num) return false;
			}
		}
		return true;
	
	}
	
}
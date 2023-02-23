import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map = new int[10][10];
	static int[] papers = { 0, 5, 5, 5, 5, 5 };
	static int result = 99;
	
	public static void main(String[] args) throws IOException {
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		
		
		dfs(0, 0, 0);
		
		System.out.println(result == 99 ? -1 : result);
		
	}
	
	static void dfs(int i, int j, int cnt) {
		
		if(cnt >= result) return;
		
		if(check(map, 0, 0, 10, 10, 0)) {
			
			int sum = 25 - papers[1] - papers[2] - papers[3] - papers[4] - papers[5];
			
			if(result > sum) result = sum;
			
			return;
			
		}
		
		if(j > 9) {
			
			i++;
			j = 0;
			
			if(i > 9) return;
			
		}
				
		if (map[i][j] == 1) {
			
			for (int k = 5; k >= 1; k--) {

				int nextR = i + k - 1;
				int nextC = j + k - 1;

				if (papers[k] > 0 && nextR < 10 && nextC < 10 && check(map, i, j, nextR + 1, nextC + 1, 1)) {
					
					cover(map, i, j, nextR + 1, nextC + 1, 0);
					papers[k]--;
					dfs(i, j, cnt + 1);
					cover(map, i, j, nextR + 1, nextC + 1, 1);
					papers[k]++;

				}

			}
			
		} else {

			dfs(i, j + 1, cnt);
			
		}
		
	}
	
	static int[][] cover(int[][] map, int startR, int startC, int endR, int endC, int num) {
		
		for (int i = startR; i < endR; i++) {
			
			for (int j = startC; j < endC; j++) {
				
				map[i][j] = num;
				
			}
			
		}
		
		return map;
		
	}
	
	static boolean check(int[][] map, int startR, int startC, int endR, int endC, int num) {
		
		for (int i = startR; i < endR; i++) {
			
			for (int j = startC; j < endC; j++) {
				
				if(map[i][j] != num) return false;
				
			}
			
		}
		
		return true;
		
	}
	
}
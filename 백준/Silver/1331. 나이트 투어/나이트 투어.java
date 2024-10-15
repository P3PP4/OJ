import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] visited = new boolean[7][7];
		char[] start = br.readLine().toCharArray();
		int[] s = { start[0] - 64, start[1] - 48 };
		int[] pos = { start[0] - 64, start[1] - 48 };
		visited[pos[0]][pos[1]] = true;
		for (int i = 0; i < 35; i++) {
			char[] input = br.readLine().toCharArray();
			int[] next = { input[0] - 64, input[1] - 48 };
			int r = Math.abs(pos[0] - next[0]);
			int c = Math.abs(pos[1] - next[1]);
			if (r < 1 || 2 < r || c < 1 || 2 < c || r + c != 3 || visited[next[0]][next[1]]) {
				System.out.print("Invalid");
				return;
			}
			visited[next[0]][next[1]] = true;
			pos[0] = next[0];
			pos[1] = next[1];
		}
		int r = Math.abs(pos[0] - s[0]);
		int c = Math.abs(pos[1] - s[1]);
		if (r < 1 || 2 < r || c < 1 || 2 < c || r + c != 3) System.out.print("Invalid");
		else System.out.print("Valid");
		
	}
	
}
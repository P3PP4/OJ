import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] input = new int[10][10];
		int maxValue = 0;
		int maxRow = 1;
		int maxCol = 1;
		for (int i = 1; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 10; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if (maxValue < input[i][j]) {
					maxValue = input[i][j];
					maxRow = i;
					maxCol = j;
				}
			}
		}
		System.out.print(maxValue + "\n" + maxRow + " " + maxCol);
	
	}
	
}
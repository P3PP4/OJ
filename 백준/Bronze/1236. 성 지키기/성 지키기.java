import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][m];
		boolean[] row = new boolean[n];
		boolean[] col = new boolean[m];
		int r = 0;
		int c = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 'X') {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			if(!row[i]) r++;
		}
		for(int i = 0; i < m; i++) {
			if(!col[i]) c++;
		}
		System.out.println(c > r ? c : r);
	}

}
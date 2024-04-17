import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken()) - 1;
		int W = Integer.parseInt(st.nextToken()) - 1;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int row = 1;
		int col = 1;
		row += W / (M + 1);
		col += H / (N + 1);
		System.out.print(row * col);
	
	}
	
}
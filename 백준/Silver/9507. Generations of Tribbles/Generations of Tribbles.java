import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] koong = new long[68];
		koong[0] = koong[1] = 1;
		koong[2] = 2;
		koong[3] = 4;
		for (int i = 4; i < 68; i++) {
			koong[i] = koong[i - 4] + koong[i - 3] + koong[i - 2] + koong[i - 1];
		}
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			sb.append(koong[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.print(sb);
	
	}
	
}
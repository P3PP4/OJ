import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		double[] input = { 350.34, 230.90, 190.55, 125.30, 180.90 };
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double sum = 0.0;
			for (int i = 0; i < 5; i++) {
				sum += input[i] * Double.parseDouble(st.nextToken());
			}
			sb.append("$").append(String.format("%.2f\n", sum));
		}
		System.out.print(sb);
	
	}
	
}
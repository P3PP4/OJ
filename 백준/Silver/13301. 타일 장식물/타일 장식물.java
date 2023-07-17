import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] square = new long[N + 1];
		long[] round = new long[N + 1];
		square[1] = 1;
		round[1] = 4;
		for (int i = 2; i <= N; i++) {
			square[i] = square[i - 2] + square[i - 1];
			round[i] = round[i - 1] + square[i] * 2;
		}
		System.out.print(round[N]);
	
	}
	
}
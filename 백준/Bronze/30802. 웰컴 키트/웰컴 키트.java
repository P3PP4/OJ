import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int tCnt = 0;
		for (int i = 0; i < 6; i++) {
			tCnt += arr[i] / T;
			if (arr[i] % T != 0) tCnt++;
		}
		sb.append(tCnt).append("\n").append(N / P).append(" ").append(N % P);
		System.out.print(sb);
	
	}
	
}
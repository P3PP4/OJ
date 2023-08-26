import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int people = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		int total = 0;
		int cnt = 0;
		int[] pen = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pen[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pen);
		int idx = N;
		while (idx-- > 0) {
			total += pen[idx];
			cnt++;
			if (people <= total) {
				System.out.print(cnt);
				return;
			}
		}
		System.out.print("STRESS");
	
	}
	
}
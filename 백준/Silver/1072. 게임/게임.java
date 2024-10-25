import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		// end of input
		
		long wr = Y * 100L / X;
		if (99 <= wr) {
			System.out.print(-1);
			return;
		}
		int l = 1;
		int r = 1_000_000_000;
		int res = -1;
		while (l <= r) {
			int m = (l + r) / 2;
			long nx = X + m;
			long ny = Y + m;
			long nwr = ny * 100L / nx;
			if (nwr == wr) l = m + 1;
			else {
				r = m - 1;
				res = m;
			}
		}
		System.out.print(res);
		
	}
	
}
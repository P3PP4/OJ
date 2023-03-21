import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, ns, P, input, high, same;
	
	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		ns = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		if (N == 0) {
			if (P == 0) System.out.print(-1);
			else if (0 < P) System.out.print(1);
			return;
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input = Integer.parseInt(st.nextToken());
			if (ns < input) high++;
			else if (ns == input) same++;
			else break;
		}
		
		if (high + same < P) System.out.print(high + 1);
		else System.out.print(-1);
	
	}
	
}
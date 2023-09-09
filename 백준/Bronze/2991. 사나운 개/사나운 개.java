import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int P = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int PCnt = 0;
		int MCnt = 0;
		int NCnt = 0;
		int P1 = P % (A + B);
		int M1 = M % (A + B);
		int N1 = N % (A + B);
		int P2 = P % (C + D);
		int M2 = M % (C + D);
		int N2 = N % (C + D);
		
		if (0 < P1 && P1 <= A) PCnt++;
		if (0 < P2 && P2 <= C) PCnt++;
		if (0 < M1 && M1 <= A) MCnt++;
		if (0 < M2 && M2 <= C) MCnt++;
		if (0 < N1 && N1 <= A) NCnt++;
		if (0 < N2 && N2 <= C) NCnt++;
		
		System.out.print(PCnt + "\n" + MCnt + "\n" + NCnt);
		
	}
	
}
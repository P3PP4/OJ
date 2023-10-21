import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int verMax = -99999;
		int horMax = -99999;
		int verMin = 99999;
		int horMin = 99999;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (verMax < a) verMax = a;
			if (verMin > a) verMin = a;
			if (horMax < b) horMax = b;
			if (horMin > b) horMin = b;
		}
		
		System.out.print((horMax - horMin) * (verMax - verMin));
		
	}
	
}
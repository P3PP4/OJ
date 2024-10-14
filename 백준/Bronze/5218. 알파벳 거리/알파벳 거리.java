import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			sb.append("Distances: ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char[] A = st.nextToken().toCharArray();
			char[] B = st.nextToken().toCharArray();
			for (int i = 0; i < A.length; i++) {
				if (A[i] <= B[i]) {
					sb.append(B[i] - A[i]).append(" ");
				} else {
					sb.append(26 - (A[i] - B[i])).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	
	}
	
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int[] a = new int[3];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a[0] = Integer.parseInt(st.nextToken());
			a[1] = Integer.parseInt(st.nextToken());
			a[2] = Integer.parseInt(st.nextToken());
			if (a[0] == 0) break;

			Arrays.sort(a);
			if (a[2] >= a[0] + a[1]) sb.append("Invalid\n");
			else if (a[0] == a[1] && a[1] == a[2]) sb.append("Equilateral\n");
			else if (a[0] == a[1] || a[1] == a[2] || a[2] == a[0]) sb.append("Isosceles\n");
			else sb.append("Scalene\n");
		}
		System.out.print(sb);

	}
	
}
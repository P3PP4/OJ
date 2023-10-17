import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] input = br.readLine().toCharArray();
		int[][] cnt = new int['z' - 'a' + 1][input.length];
		cnt[input[0] - 'a'][0] = 1;
		for (int i = 1; i < input.length; i++) {
			for (int j = 'a'; j <= 'z'; j++) {
				cnt[j - 'a'][i] = cnt[j - 'a'][i - 1];
			}
			cnt[input[i] - 'a'][i]++;
		}
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char a = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			sb.append(cnt[a - 'a'][r] - (l == 0 ? 0 : cnt[a - 'a'][l - 1])).append("\n");
		}
		System.out.print(sb);
	
	}
	
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String N = st.nextToken();
		int len = N.length();
		if (N.replace("0", "").length() < 2 && len < 3) {
			System.out.print(-1);
			return;
		}
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		Queue<String> q = new LinkedList<>();
		q.offer(N);
		while (!q.isEmpty()) {
			int size = q.size();
			HashSet<String> set = new HashSet<>();
			while (size-- > 0) {
				String s = q.poll();
				for (int i = 0; i < len - 1; i++) {
					for (int j = i + 1; j < len; j++) {
						if (i == 0 && s.charAt(j) == '0') continue;
						String next = s.substring(0, i) + s.charAt(j) + s.substring(i + 1, j) + s.charAt(i) + s.substring(j + 1, len);
						if (set.contains(next)) continue;
						set.add(next);
						q.offer(next);
					}
				}
			}
			if (--K == 0) {
				for (String s : set) {
					int n = Integer.parseInt(s);
					if (max < n) max = n;
				}
				break;
			}
		}
		System.out.print(max);
	
	}
	
}
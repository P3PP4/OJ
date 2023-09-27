import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeSet<Problem> set = new TreeSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int dif = Integer.parseInt(st.nextToken());
			set.add(new Problem(num, dif));
			map.put(num, dif);
		}
		int P = Integer.parseInt(br.readLine());
		for (int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			if ("add".equals(order)) {
				int num = Integer.parseInt(st.nextToken());
				int dif = Integer.parseInt(st.nextToken());
				set.add(new Problem(num, dif));
				map.put(num, dif);
			} else if ("solved".equals(order)) {
				int num = Integer.parseInt(st.nextToken());
				set.remove(new Problem(num, map.get(num)));
			} else {
				if ("1".equals(st.nextToken())) {
					sb.append(set.last().num).append("\n");
				} else {
					sb.append(set.first().num).append("\n");
				}
			}
		}
		System.out.print(sb);
	
	}
	
	static class Problem implements Comparable<Problem> {
		int num, dif;
		
		public Problem(int num, int dif) {
			this.num = num;
			this.dif = dif;
		}
		
		@Override
		public int compareTo(Problem o) {
			if (this.dif == o.dif) return this.num - o.num;
			return this.dif - o.dif;
		}
	}
	
}
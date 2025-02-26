import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		HashSet[] set = new HashSet[N + 1];
		for (int i = 1; i <= N; i++) {
			set[i] = new HashSet<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());
			HashSet<Integer> participant = new HashSet<>();
			
			for (int j = 0; j < K; j++) {
				participant.add(Integer.parseInt(st.nextToken()));
			}
			
			if (participant.contains(1)) {
				for (int person : participant) {
					set[person].add(i);
				}
			} else {
				for (int person1 : participant) {
					for (int person2 : participant) {
						if (person1 == person2) continue;
						set[person2].forEach(v -> set[person1].add(v));
						set[person1].forEach(v -> set[person2].add(v));
					}
				}
			}
		}
		
		sb.append(1).append("\n");
		int size = set[1].size();
		for (int i = 2; i <= N; i++) {
			if (set[i].size() == size) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb);
	
	}
	
}
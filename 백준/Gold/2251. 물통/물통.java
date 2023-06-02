import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] max = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		HashSet<Integer> set = new HashSet<>();
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[max[0] + 1][max[1] + 1][max[2] + 1];
		q.offer(new int[] { 0, 0, max[2] });
		
		while (!q.isEmpty()) {
			int[] n = q.poll();
			
			if (visited[n[0]][n[1]][n[2]]) continue;
			visited[n[0]][n[1]][n[2]] = true;
			
			if (n[0] == 0) set.add(n[2]);
			
			for (int i = 0; i < 3; i++) {
				if (n[i] == 0) continue;
				
				int prev = (i + 2) % 3;
				int next = (i + 1) % 3;
				int prevN = Math.min(max[prev] - n[prev], n[i]);
				int nextN = Math.min(max[next] - n[next], n[i]);
				
				int[] prevArr = new int[3];
				prevArr[prev] = n[prev] + prevN;
				prevArr[i] = n[i] - prevN;
				prevArr[next] = n[next];
				q.offer(prevArr);
				
				int[] nextArr = new int[3];
				nextArr[prev] = n[prev];
				nextArr[i] = n[i] - nextN;
				nextArr[next] = n[next] + nextN;
				q.offer(nextArr);
			}
		}
		
		set.stream().sorted().collect(Collectors.toList()).forEach(x -> sb.append(x).append(" "));
		System.out.print(sb);
		
	}
	
}
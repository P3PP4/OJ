import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] dr = { -1,  0,  1,  0 };
		int[] dc = {  0,  1,  0, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[3][3];
		String s = "";
		int idx = -1;
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				s += map[i][j];
				if (map[i][j] == 0) idx = i * 3 + j;
			}
		}
		
		Queue<Info> q = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		q.offer(new Info(s, idx));
		set.add(s);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Info info = q.poll();
				if (info.zeroIdx == 8 && "123456780".equals(info.str)) {
					System.out.print(cnt);
					return;
				}
				
				for (int dir = 0; dir < 4; dir++) {
					switch (dir) {
						case 1:
							if (info.zeroIdx == 2 || info.zeroIdx == 5) continue;
							break;
						case 3:
							if (info.zeroIdx == 3 || info.zeroIdx == 6) continue;
						default:
							break;
					}
					int nextIdx = info.zeroIdx + (dr[dir] * 3) + dc[dir];
					if (nextIdx < 0 || 8 < nextIdx) continue;
					
					String temp = "";
					if (nextIdx < info.zeroIdx) temp = info.str.substring(0, nextIdx) + info.str.charAt(info.zeroIdx) + info.str.substring(nextIdx + 1, info.zeroIdx) + info.str.charAt(nextIdx) + info.str.substring(info.zeroIdx + 1, 9);
					else temp = info.str.substring(0, info.zeroIdx) + info.str.charAt(nextIdx) + info.str.substring(info.zeroIdx + 1, nextIdx) + info.str.charAt(info.zeroIdx) + info.str.substring(nextIdx + 1, 9);
					if (set.contains(temp)) continue;
					
					q.offer(new Info(temp, nextIdx));
					set.add(temp);
				}
			}
			cnt++;
		}
		System.out.print(-1);
	
	}
	
	static class Info {
		String str;
		int zeroIdx;
		
		Info(String str, int zeroIdx) {
			this.str = str;
			this.zeroIdx = zeroIdx;
		}
		
	}
	
}
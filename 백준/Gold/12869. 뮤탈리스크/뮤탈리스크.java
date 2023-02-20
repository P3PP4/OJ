import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] hp = new int[3];
		boolean[][][] visited = new boolean[61][61][61];
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for (int i = 0; i < N; i++) {
		    hp[i] = Integer.parseInt(st.nextToken());
	    } // end of input
	
	    Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { hp[0], hp[1], hp[2] });
		visited[hp[0]][hp[1]][hp[2]] = true;
		int time = -1;
		
		while(!q.isEmpty()) {
		
			time++;
			int size = q.size();
			
			while(size-- > 0) {
				
				int[] a = q.poll();
				
				if (a[0] == 0 && a[1] == 0 && a[2] == 0) {
					System.out.print(time);
					return;
				}
				
				for (int i = 0; i < 3; i++) {
				
					int n0 = a[0 + i] - 9 < 0 ? 0 : a[0 + i] - 9;
					int n1 = a[(1 + i) % 3] - 3 < 0 ? 0 : a[(1 + i) % 3] - 3;
					int n2 = a[(2 + i) % 3] - 1 < 0 ? 0 : a[(2 + i) % 3] - 1;
					
					if (!visited[n0][n1][n2]) {
						visited[n0][n1][n2] = true;
						q.offer(new int[] { n0, n1, n2 });
					}
					
					n1 = a[(1 + i) % 3] - 1 < 0 ? 0 : a[(1 + i) % 3] - 1;
					n2 = a[(2 + i) % 3] - 3 < 0 ? 0 : a[(2 + i) % 3] - 3;
					
					if (!visited[n0][n1][n2]) {
						visited[n0][n1][n2] = true;
						q.offer(new int[] { n0, n1, n2 });
					}
					
				}
			
			}
			
		}
	    
    }

}
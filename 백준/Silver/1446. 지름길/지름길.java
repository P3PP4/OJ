import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] dist = new int[D + 1];
		int[][] road = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
			road[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= D; i++) {
			dist[i] = dist[i - 1] + 1;
			for (int j = 0; j < N; j++) {
				if (road[j][1] == i && dist[road[j][0]] + road[j][2] < dist[i]) dist[i] = dist[road[j][0]] + road[j][2];
			}
		}
		System.out.print(dist[D]);
	
	}
	
}
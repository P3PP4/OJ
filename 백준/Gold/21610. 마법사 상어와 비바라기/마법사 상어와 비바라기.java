import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, d, s, result;
	static int[][] A;
	static int[] dr = {  0, -1, -1, -1,  0,  1,  1,  1 };
	static int[] dc = { -1, -1,  0,  1,  1,  1,  0, -1 };
	static boolean[][] check;
	static ArrayList<int[]> list = new ArrayList<>();
	static ArrayList<int[]> clouds = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			list.add(new int[] { d, s });
		} // end of input
		
		// 첫 구름들
		clouds.add(new int[] { N - 2, 0 });
		clouds.add(new int[] { N - 2, 1 });
		clouds.add(new int[] { N - 1, 0 });
		clouds.add(new int[] { N - 1, 1 });
		
		for (int num = 0; num < M; num++) {
		
			int[] skill = list.get(num);
			
			// 이동
			for (int i = 0; i < clouds.size(); i++) {
				int[] cloud = clouds.get(i);
				for (int j = 0; j < skill[1]; j++) {
					cloud[0] += dr[skill[0]];
					cloud[1] += dc[skill[0]];
					cloud[0] = cloud[0] < 0 ? cloud[0] + N : cloud[0] % N;
					cloud[1] = cloud[1] < 0 ? cloud[1] + N : cloud[1] % N;
				}
				clouds.set(i, cloud);
			}
			
			// 구름 있는 칸에 비 1씩 내림
			for (int[] cloud : clouds) {
				A[cloud[0]][cloud[1]]++;
			}
			
			// 대각선 물 흡수
			int[] w = new int[clouds.size()];
			for (int i = 0; i < clouds.size(); i++) {
				int[] cloud = clouds.get(i);
				for (int dir = 1; dir < 8; dir += 2) {
					int nr = cloud[0] + dr[dir];
					int nc = cloud[1] + dc[dir];
					if (0 <= nr && nr < N && 0 <= nc && nc < N && 0 < A[nr][nc]) w[i]++;
				}
			}
			for (int i = 0; i < clouds.size(); i++) {
				int[] cloud = clouds.get(i);
				A[cloud[0]][cloud[1]] += w[i];
			}
			
			// 구름 생기고 물 제거 (스킬 썼던 칸에도 채워두고 전체 탐색)
			check = new boolean[N][N];
			for (int[] cloud : clouds) {
				check[cloud[0]][cloud[1]] = true;
			}
			clouds.clear();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!check[i][j] && 2 <= A[i][j]) {
						clouds.add(new int[] { i, j });
						A[i][j] -= 2;
					}
				}
			}
			
		}
		
		// 남아있는 물 셈
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += A[i][j];
			}
		}
		
		System.out.print(result);
	
	}
	
}
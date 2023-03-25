import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int H, W, result;
	static boolean[][] wall;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		wall = new boolean[H][W];
		st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < W; j++) {
			int height = Integer.parseInt(st.nextToken());
			for (int i = 0; i < height; i++) {
				wall[i][j] = true;
			}
		} // 입력 끝
		
		for (int row = 0; row < H; row++) {
			
			for (int col = 0; col < W; col++) {
				
				if(wall[row][col]) {
					
					int cnt = 0;
					
					for (int j = col + 1; j < W; j++) {
						
						if(!wall[row][j]) cnt++;
						else if(wall[row][j]) {
                            
							col = j - 1;
							break;
                            
						}
						
						if(j == W - 1 && !wall[row][j]) {
							
							cnt = 0;
							col = j;
							break;
							
						}
						
					}
					
					result += cnt;
					
				}
				
			}
			
		}
		
		System.out.println(result);
		
	}
	
}
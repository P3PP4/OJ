import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
     
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
     
    public static void main(String[] args) throws Exception {
    	
    	st = new StringTokenizer(br.readLine(), " ");
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken()) - 1;
    	int[][] input = new int[N][4];
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[num][0] = g;
			input[num][1] = s;
			input[num][2] = b;
			input[num][3] = num;
		}
    	
    	Arrays.sort(input, (int[] o1, int[] o2) -> {
    		if(o1[0] == o2[0]) return o2[1] - o1[1]; 
    		if(o1[1] == o2[1]) return o2[2] - o1[2];
    		return o2[0] - o1[0];
    	});
    	
    	int result = 0;
    	int index = 0;
    	
    	for (int i = 0; i < N; i++) {
			
    		result++;
    		
    		if(input[i][3] == K) {
    			
    			index = i;
    			break;
    			
    		}
    		
		}
    	
    	for (int i = index - 1; i > 0; i--) {
			
    		if(input[index][0] == input[i][0] && input[index][1] == input[i][1] && input[index][2] == input[i][2]) result--;
    		else break;
    		
		}
    	
    	System.out.println(result);
    	
    }
 
}
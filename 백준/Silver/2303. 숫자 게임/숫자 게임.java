import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, max, maxIndex;
	
    public static void main(String[] args) throws Exception {
	
	    N = Integer.parseInt(br.readLine());
	    for (int i = 1; i <= N; i++) {
		    int[] n = new int[5];
		    st = new StringTokenizer(br.readLine(), " ");
		    n[0] = Integer.parseInt(st.nextToken());
		    n[2] = Integer.parseInt(st.nextToken());
		    n[1] = Integer.parseInt(st.nextToken());
		    n[3] = Integer.parseInt(st.nextToken());
		    n[4] = Integer.parseInt(st.nextToken());
			
		    for (int j = 0; j < 3; j++) {
			    for (int k = j + 1; k < 4; k++) {
				    for (int l = k + 1; l < 5; l++) {
						int temp = (n[j] + n[k] + n[l]) % 10;
						if (max <= temp) {
							max = temp;
							maxIndex = i;
						}
				    }
			    }
		    }
	    }
	
	    System.out.print(maxIndex);
		
    }

}
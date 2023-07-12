import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (Integer.parseInt(br.readLine()) % 2 == 1) System.out.print("CY");
		else System.out.print("SK");
	
	}
	
}
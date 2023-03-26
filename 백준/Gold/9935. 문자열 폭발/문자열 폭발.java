import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
    
        String str = br.readLine();
        String cut = br.readLine();
    
        Stack<Character> stack = new Stack<>();
        int size = cut.length() - 1;
        char start = cut.charAt(0);
    
        for (int i = str.length() - 1; i >= 0; i--) {
        
            char c = str.charAt(i);
            stack.push(c);
            
            if (c == start && size < stack.size()) {
            
                Stack<Character> temp = new Stack<Character>();
    
                for (int j = 0; j < cut.length(); j++) {
                    
                    char strC = stack.pop();
                    char cutC = cut.charAt(j);
                    temp.push(strC);
                    
                    if (strC != cutC) {
                        while (!temp.isEmpty()) {
                            stack.push(temp.pop());
                        }
                    }
                    
                }
            
            }
        
        }
        
        if (stack.isEmpty()) sb.append("FRULA");
        else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }
    
        System.out.print(sb.toString());
    
    }

}
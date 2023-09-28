import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K, redCnt, blueCnt;
    static int[] parent;
    static ArrayList<Line> red, blue, compulsory;
    
    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 정점 수
        M = Integer.parseInt(st.nextToken()); // 간선 수
        K = Integer.parseInt(st.nextToken()); // 파란 간선 수
        red = new ArrayList<>();
        blue = new ArrayList<>();
        compulsory = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char a = st.nextToken().charAt(0);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(a == 'R') red.add(new Line(from, to));
            else blue.add(new Line(from, to));
        } // end of input
        
        // 파란색 간선 수가 K보다 적으면 종료
        if(blue.size() < K) {
            System.out.print(0);
            return;
        }
        
        make();
    
        for (Line r : red) {
            if(union(r.from, r.to) && ++redCnt == N - 1) break;
        }
        for (Line b : blue) {
            if(blueCnt + redCnt == N - 1) break;
            if(union(b.from, b.to)) {
                compulsory.add(b);
                blueCnt++;
            }
        }
        
        // 가망 없으면 종료
        if(K < blueCnt || blueCnt + redCnt < N - 1) {
            System.out.print(0);
            return;
        }
        
        make();
        redCnt = 0;
        blueCnt = compulsory.size();
    
        for (Line c : compulsory) {
            union(c.from, c.to);
            sb.append(c.from + " " + c.to + "\n");
        }
        for (Line b : blue) {
            if(blueCnt == K || blueCnt == N - 1) break;
            if(union(b.from, b.to)) {
                sb.append(b.from + " " + b.to + "\n");
                blueCnt++;
            }
        }
        for (Line r : red) {
            if(blueCnt + redCnt == N - 1) break;
            if(union(r.from, r.to)) {
                sb.append(r.from + " " + r.to + "\n");
                redCnt++;
            }
        }
        
        if(blueCnt != K || blueCnt + redCnt != N - 1) System.out.print(0);
        else System.out.print(sb.toString());
        
    }
    
    static boolean union(int a, int b) {
        
        a = find(a);
        b = find(b);
        
        if(a == b) return false;
        
        if(a < b) parent[b] = a;
        else parent[a] = b;
        
        return true;
        
    }
    
    static int find(int a) {
        
        if(a == parent[a]) return a;
        
        return parent[a] = find(parent[a]);
        
    }
    
    static void make() {
        
        parent = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
    }
    
    static class Line {
        
        int from, to;
        
        public Line(int from, int to) {
            this.from = from;
            this.to = to;
        }
        
    }
    
}
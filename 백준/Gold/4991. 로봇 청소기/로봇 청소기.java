import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int sr, sc, H, W, trashCnt;
    static char[][] map;
    static int[][][] visited;
    static int[] dr = { -1,  0,  1,  0 };
    static int[] dc = {  0,  1,  0, -1 };
    static List<int[]> trashList;
    
    public static void main(String[] args) throws Exception {
    
t:        while (true) {
    
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (H == 0) break;
            map = new char[H][W];
            visited = new int[H][W][1 << 10];
            trashList = new ArrayList<>();
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 'o') {
                        sr = i;
                        sc = j;
                        map[i][j] = '.';
                    } else if (map[i][j] == '*') trashList.add(new int[] { i, j });
                }
            } // end of input
            
            trashCnt = trashList.size();
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] { sr, sc, 0 });
            visited[sr][sc][0] = 1;
            
            while (!q.isEmpty()) {
            
                int[] now = q.poll();
    
                for (int dir = 0; dir < 4; dir++) {
                
                    int nr = now[0] + dr[dir];
                    int nc = now[1] + dc[dir];
                    
                    if (0 <= nr && nr < H && 0 <= nc && nc < W && map[nr][nc] != 'x' && visited[nr][nc][now[2]] == 0) {
                    
                        if (map[nr][nc] == '.') {
                            q.offer(new int[] { nr, nc, now[2] });
                            visited[nr][nc][now[2]] = visited[now[0]][now[1]][now[2]] + 1;
                        } else if (map[nr][nc] == '*') {
                            for (int i = 0; i < trashCnt; i++) {
                                int[] trash = trashList.get(i);
                                if (nr == trash[0] && nc == trash[1]) {
                                    if ((1 << trashCnt) - 1 == (now[2] | (1 << i))) {
                                        sb.append(visited[now[0]][now[1]][now[2]]).append("\n");
                                        continue t;
                                    }
                                    q.offer(new int[] { nr, nc, now[2] | (1 << i)});
                                    visited[nr][nc][now[2]] = visited[now[0]][now[1]][now[2]] + 1;
                                    visited[nr][nc][now[2] | (1 << i)] = visited[now[0]][now[1]][now[2]] + 1;
                                    break;
                                }
                            }
                        }
                    
                    }
                
                }
                
            }
            
            sb.append(-1).append("\n");
            
        }
    
        System.out.print(sb.toString());
    
    }
    
}

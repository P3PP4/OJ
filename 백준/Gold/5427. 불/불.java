import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, W, H, time;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = { -1,  0,  1,  0 };
    static int[] dc = {  0,  1,  0, -1 };

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

test:       for (int tc = 0; tc < T; tc++) {

            Queue<int[]> man  = new LinkedList<>();
            Queue<int[]> fire = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            visited = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    if(map[i][j] == '@') {
                        map[i][j] = '.';
                        man.offer(new int[] { i, j });
                        visited[i][j] = true;
                    } else if(map[i][j] == '*') {
                        fire.offer(new int[] { i, j });
                    }
                }
            } // end of input

            time = 0;

            while(!man.isEmpty()) {

                time++;
                int size = man.size();

                while(size-- > 0) {

                    int[] now = man.poll();

                    if(map[now[0]][now[1]] == '*') continue;

                    if(now[0] == 0 || now[0] == H - 1 || now[1] == 0 || now[1] == W - 1) {
                        sb.append(time).append("\n");
                        continue test;
                    }

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = now[0] + dr[dir];
                        int nc = now[1] + dc[dir];

                        if(0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc] && map[nr][nc] == '.') {
                            man.offer(new int[] { nr, nc });
                            visited[nr][nc] = true;
                        }
                    }

                }

                size = fire.size();

                while(size-- > 0) {
                    int[] now = fire.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = now[0] + dr[dir];
                        int nc = now[1] + dc[dir];

                        if(0 <= nr && nr < H && 0 <= nc && nc < W && map[nr][nc] == '.') {
                            fire.offer(new int[] { nr, nc });
                            map[nr][nc] = '*';
                        }
                    }

                }

            }

            sb.append("IMPOSSIBLE").append("\n");

        }

        System.out.print(sb.toString());

    }

}
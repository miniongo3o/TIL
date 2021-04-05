package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7569_토마토 {
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dh = { 1, -1 };

	static class pos {
		int y, x, h;
		int cnt;

		public pos(int h, int y, int x,int cnt) {
			this.y = y;
			this.x = x;
			this.h = h;
			this.cnt=cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int h = Integer.parseInt(str[2]);
		int[][][] arr = new int[h][n][m];

		Queue<pos> q = new LinkedList();
		boolean[][][] visit = new boolean[h][n][m];
		int fresh=0;
		for (int p = 0; p < h; p++) {
			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					arr[p][i][j] = Integer.parseInt(temp[j]);
					if (arr[p][i][j] == 1) {
						q.offer(new pos(p, i, j,0));
						visit[p][i][j] = true;
					}else if(arr[p][i][j]==0) {
						fresh++;
					}
				}
			}
		}
		int max = -1;
		// 한개도 없는 경우
		if(fresh==0) {
			System.out.println(0); 
			return;
		}

		// bfs확인
		while (!q.isEmpty()) {
			pos p = q.poll();
			int y = p.y;
			int ht = p.h;
			int x = p.x;
			int cnt=p.cnt;
			max=(cnt>max?cnt:max);

			// 4방위
			for (int dir = 0; dir < 4; dir++) {
				int ny=y+dy[dir];
				int nx=x+dx[dir];
				if(ny<0||nx<0||ny>=n||nx>=m)continue;
				if(!visit[ht][ny][nx]&&arr[ht][ny][nx]==0) {
					visit[ht][ny][nx]=true;
					arr[ht][ny][nx]=1;
					q.offer(new pos(ht,ny,nx,cnt+1));
				}
					
			}
			// 위아래
			for (int dir = 0; dir < 2; dir++) {
				int nh=ht+dh[dir];
				if(nh<0||nh>=h)continue;
				
				if(!visit[nh][y][x]&&arr[nh][y][x]==0) {
					visit[nh][y][x]=true;
					arr[nh][y][x]=1;
					q.offer(new pos(nh,y,x,cnt+1));
				}
			}
			

		}

		// 체크
		for (int p = 0; p < h; p++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[p][i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(max);

	}

}

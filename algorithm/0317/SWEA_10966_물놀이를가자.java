package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_10966_물놀이를가자 {
	static int n, sum;
	static int r, c;
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static int map[][];
	static char[][] arr;
	static boolean visit[][];

	static class pos {
		int y, x;

		public pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int t = 1; t <= n; t++) {
			String[] str = br.readLine().split(" ");
			r = Integer.parseInt(str[0]);
			c = Integer.parseInt(str[1]);
			map = new int[r][c];
			arr = new char[r][c];
			for (int i = 0; i < r; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < c; j++) {
					arr[i][j] = tmp.charAt(j);
				}
			}
			visit=new boolean[r][c];
			bfs();
			
			sum=0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(arr[i][j]=='L') {
						sum+=map[i][j];
					}
				}
			}
			
			System.out.println("#" + t + " " + sum);

		}

	}

	private static void bfs() {

		Queue<pos> q = new LinkedList<pos>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j]=='W') {
					q.offer(new pos(i,j));
				}
			}
		}
		
		
		
		while (!q.isEmpty()) {
			pos p = q.poll();
			int nowx = p.x;
			int nowy = p.y;

			for (int dir = 0; dir < 4; dir++) {
				int ny = p.y + dy[dir];
				int nx = p.x + dx[dir];
				if (ny >= 0 && nx >= 0 && ny < r && nx < c &&!visit[ny][nx]&&arr[ny][nx]=='L') {
					visit[ny][nx]=true;
					map[ny][nx]=map[nowy][nowx]+1;
					q.offer(new pos(ny,nx));
				}

			}
		}

	}
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_20056_마법사와상어파이어볼 {
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int n, m, k;
	static ArrayList<fire>[][] map;

	static class fire {
		int m, s, d;

		public fire(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);

		map = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new ArrayList();
			}
		}
		for (int i = 0; i < m; i++) {
			String[] temp = br.readLine().split(" ");
			int r = Integer.parseInt(temp[0]) - 1;
			int c = Integer.parseInt(temp[1]) - 1;
			int m = Integer.parseInt(temp[2]); // 질량
			int s = Integer.parseInt(temp[3]); // 속도
			int d = Integer.parseInt(temp[4]); // 방향
			map[r][c].add(new fire(m, s, d));
		}

		for (int i = 0; i < k; i++) {
			move();
		}
		System.out.println(sum());
	}

	public static void move() {
		ArrayList<fire>[][] copied = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copied[i][j] = new ArrayList();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].size() >= 1) {

					for (fire f : map[i][j]) {
						int distance = f.s % n;
						int y = i + dy[f.d] * distance;
						int x = j + dx[f.d] * distance;
						if (x >= n) {
							x -= n;
						} else if (x < 0) {
							x += n;
						}

						if (y >= n) {
							y -= n;

						} else if (y < 0) {
							y += n;
						}

						copied[y][x].add(new fire(f.m,f.s,f.d));
					}

				}
			}
		}
		map=copied;
		split();

	}

	public static void split() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j].size()>=2) {
					int mSum=0;
					int sSum=0;
					boolean odd=true;
					boolean even=true;
					for(fire f:map[i][j]) {
						mSum+=f.m;
						sSum+=f.s;
						if(f.d%2==0) {
							odd=false;
						}else {
							even=false;
						}
					}
					
					int m=mSum/5;
					int s=sSum/map[i][j].size();
					map[i][j].clear();
					if(m>0) {
						for(int dir=0;dir<4;dir++) {
							if(odd||even) {
								//짝수 방향
								map[i][j].add(new fire(m,s,2*dir));
							}else { 
								//홀수 방ㅎ야 
								map[i][j].add(new fire(m,s,1+2*dir));
								
							}
						}
					}
				}
			}
		}

	}

	public static int sum() {
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(fire f:map[i][j]) {
					sum+=f.m;
				}
			}
		}
		return sum;
	}
}

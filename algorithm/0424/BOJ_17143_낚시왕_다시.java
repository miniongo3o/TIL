package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_17143_낚시왕_다시 {

	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int R, C, M;
	static ArrayList<shark> list = new ArrayList();

	static class shark implements Comparable<shark> {
		int r, c, s, d, z;

		public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

		public int getS() {
			return s;
		}

		public void setS(int s) {
			this.s = s;
		}

		public int getD() {
			return d;
		}

		public void setD(int d) {
			this.d = d;
		}

		public int getZ() {
			return z;
		}

		public void setZ(int z) {
			this.z = z;
		}

		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(shark o) {
			// TODO Auto-generated method stub
			if (this.c == o.c) {
				if (this.r == o.r) {
					return this.z < o.z ? 1 : -1;
				} else
					return this.r < o.r ? -1 : 1;
			}
			return this.c < o.c ? -1 : 1;

		}

	}

	static int map[][];
	static int size[][];
	static int direc[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		M = Integer.parseInt(str[2]);

		for (int m = 1; m <= M; m++) {
			String[] temp = br.readLine().split(" ");
			int y = Integer.parseInt(temp[0]) - 1;
			int x = Integer.parseInt(temp[1]) - 1;
			int s = Integer.parseInt(temp[2]);
			int d = Integer.parseInt(temp[3]);
			int z = Integer.parseInt(temp[4]);
			list.add(new shark(y, x, s, d, z));
		}
		int time = 0;
		int result = 0;
		while (time < C) {
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).c == time) {
					result += list.get(i).z;
					list.remove(i);
					break;
				}
			}	

			for (int i = 0; i < list.size(); i++) {
				shark sh = list.get(i);
				int r = sh.r;
				int c = sh.c;
				int dir = sh.d;
				int speed = sh.s;

				while (speed > 0) {
					r += dy[dir];
					c += dx[dir];

					if (r < 0 || c < 0 || r >= R || c >= C) {
						r -= dy[dir];
						c -= dx[dir];

						if (dir == 1) {
							dir = 2;
						} else if (dir == 2) {
							dir = 1;
						} else if (dir == 3) {
							dir = 4;
						} else if (dir == 4) {
							dir = 3;
						}
						continue;

					}
					speed--;
				}

				list.get(i).setR(r);
				list.get(i).setC(c);
				list.get(i).setD(dir);
			}
			map = new int[R][C];
			size = new int[R][C];
			direc = new int[R][C];
			for (int i = 0; i < list.size(); i++) {
				int r = list.get(i).r;
				int c = list.get(i).c;

				if (map[r][c] == 0) {
					map[r][c] = list.get(i).z;
					size[r][c] = list.get(i).s;
					direc[r][c] = list.get(i).d;
				} else {

					if (map[r][c] < list.get(i).z) {
						map[r][c] = list.get(i).z;
						size[r][c] = list.get(i).s;
						direc[r][c] = list.get(i).d;
					}

				}
			}
			list.clear();
			time++;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0) {
						list.add(new shark(i, j, size[i][j], direc[i][j], map[i][j]));
					}
				}
			}
			
			
		}

		System.out.println(result);

	}

}

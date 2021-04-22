package SWEA;

import java.util.Scanner;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
	static int[][] a;
	static int[][] v;
	static int n;
	
	public static void dfs(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(v[nx][ny] == 0 && a[nx][ny] > 0)
					v[nx][ny] = 1;
				else if(v[nx][ny] == 0 && a[nx][ny] == 0) {
					v[nx][ny] = 1;
					dfs(nx,ny);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			char[][] map = new char[n][n];
			a = new int[n][n];
			v = new int[n][n];
			int area = 0;
			
			for(int i = 0; i < n; i++) {
				String s = sc.next();
				for(int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == '*') {
						a[i][j] = -1;
						v[i][j] = 1;
						continue;
					}
					int cnt = 0;
					for(int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
							if(map[nx][ny] == '*') cnt++;
						}
					}
					a[i][j] = cnt;
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0;  j < n; j++) {
					if(a[i][j] == 0 && v[i][j] == 0) {
						area++;
						v[i][j] = 1;
						dfs(i, j);
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(v[i][j] == 0) area++;
				}
			}
			System.out.println("#" + t + " " + area);
		}
	}
}
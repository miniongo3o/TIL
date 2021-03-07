package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17391_무한부스터 {
	static class pos {
		int y, x, level;

		public pos(int y, int x, int level) {
			this.y = y;
			this.x = x;
			this.level = level;
		}
	}

	static int dy[] = { 1, 0 };
	static int dx[] = { 0, 1 };
	static int arr[][];
	static boolean visit[][];
	static int n, m,answer=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit=new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		bfs();
		System.out.println(answer);

	}

	private static void bfs() {
		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(0, 0, 0));
		
		while (!q.isEmpty()) {
			System.out.println("q size "+q.size());
			
			pos p = q.poll();
			int y = p.y;
			int x = p.x;
			int level=p.level;
			System.out.println(" y is "+y+" x is "+x);
			

			int booster = arr[y][x];
			

			
			// 2가지 방향 탐색 아래 오른쪽
			for (int dir = 0; dir < 2; dir++) {
				// 부스터 범위 : 1~booster
				for (int b = booster; b >= 1; b--) {
					int nx=x+dx[dir]*b;
					int ny=y+dy[dir]*b;
					if(ny==n-1&&nx==m-1) {
						//왜 Math.min하지않을까?
						answer=level+1;
						return;
					}
					
					if(nx<m&&ny<n&&!visit[ny][nx]) {
						q.add(new pos(ny,nx,level+1));
						visit[ny][nx]=true;
					}
				}
			}

		}

	}
}

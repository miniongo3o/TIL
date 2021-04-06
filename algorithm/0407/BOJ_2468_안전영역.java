package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2468_안전영역 {
	static class pos{
		int y,x;
		public pos(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		ArrayList<Integer> list=new ArrayList();
		boolean[] visit=new boolean[101];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
				if(!visit[arr[i][j]]) {
					visit[arr[i][j]]=true;
					list.add(arr[i][j]);
				}
			}
		}
		
		int max=-1;
		for(int num:list) {
			boolean[][] checked=new boolean[n][n];
			int cnt=0;
			Queue<pos> q=new LinkedList();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]>=num&&!checked[i][j]) {
						cnt++;
						q.offer(new pos(i,j));
						
						while(!q.isEmpty()) {
							pos p=q.poll();
							int y=p.y;
							int x=p.x;
							
							for(int dir=0;dir<4;dir++) {
								int ny=y+dy[dir];
								int nx=x+dx[dir];
								if(ny<0||nx<0||ny>=n||nx>=n)continue;
								
								if(!checked[ny][nx]&&arr[ny][nx]>=num) {
									checked[ny][nx]=true;
									q.offer(new pos(ny,nx));
								}
							}
						}
					}
				}
			}
			max=Math.max(max,cnt);
		}
		System.out.println(max);
	}
}

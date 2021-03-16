package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260_DFS와BFS {
	static int n,m,v;
	static boolean[][] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str= br.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		m=Integer.parseInt(str[1]);
		v=Integer.parseInt(str[2]);
		arr=new boolean[n+1][n+1];
		visit=new boolean[n+1];
		for(int i=0;i<m;i++) {
			String[] temp= br.readLine().split(" ");
			int start=Integer.parseInt(temp[0]);
			int dest=Integer.parseInt(temp[1]);
			arr[start][dest]=true;
			arr[dest][start]=true;
			
		}
		dfs(v);
		System.out.println();
		visit=new boolean[n+1];
		bfs();
		
	}
	private static void dfs(int start) {
		System.out.print(start+" " );
		visit[start]=true;
		
		for(int i=1;i<=n;i++) {
			if(!visit[i]&&arr[start][i]) {
				dfs(i);
			}
		}
		
		
		
	}
	private static void bfs() {
		Queue<Integer> que=new LinkedList<Integer>();
		que.offer(v);
		visit[v]=true;
		while(!que.isEmpty()) {
			int start=que.poll();
			
			System.out.print(start+" ");
			
			
			for(int i=1;i<=n;i++) {
				if(!visit[i]&&arr[start][i]) {
					que.offer(i);
					visit[i]=true;
				}
			}
		}
	}
}

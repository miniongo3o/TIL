package ssafy_algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260_DFS와BFS {
	//     1
	//  /  |  \
	// 2 ㅡ  4 ㅡ  3
  	//
	// 1 2 4 3
	// 1 2 3 4
	
	
	static int N;
	static int V;
	static int M;
	static int[][] arr;
	static boolean[] visit;
	
	public static void dfs(int start) {
		System.out.print(start+" ");
		visit[start]=true;
		for(int i=1;i<=N;i++) {
			if(arr[start][i]==1&&!visit[i]) {
				dfs(i);
			}
		}
		
		
		
	}
	public static void bfs(int start) {
		
		
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			visit[temp]=true;
			System.out.print(temp+" ");
			for(int i=1;i<=N;i++) {
				if(arr[temp][i]==1&&!visit[i]) {
					q.offer(i);
					visit[i]=true;
				}
			}
		}
		

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String[] str=br.readLine().split(" ");
		
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		V=Integer.parseInt(str[2]);
		arr=new int[N+1][N+1];
		visit=new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			String[] input=br.readLine().split(" ");
			int y=Integer.parseInt(input[0]);
			int x=Integer.parseInt(input[1]);
			arr[y][x]=1;
			arr[x][y]=1;
		}
		dfs(V);
		System.out.println();
		visit=new boolean[N+1];
		bfs(V);
		
	}
}

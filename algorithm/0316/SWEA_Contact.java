package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_Contact {
	static int n,max,maxTarget;
	static int v;
	static boolean visit[];
	static int[][] arr;
	static int check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			v = Integer.parseInt(str[1]);
			String[] temp = br.readLine().split(" ");
			visit = new boolean[101];
			arr=new int[101][101];
			
			check=new int[101];
			for (int i = 0; i < n; i += 2) {
				int from = Integer.parseInt(temp[i]);
				int to = Integer.parseInt(temp[i + 1]);
				arr[from][to]=1;
			}
			max= -1;
			maxTarget=0;
			bfs();

			System.out.println("#"+t+" "+maxTarget);
		}
	}

	private static void bfs() {
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(v);
		visit[v]=true;
		while(!q.isEmpty()) {
			
			int a=q.poll();
			for(int i=1;i<=100;i++) {
				if(arr[a][i]==1&&!visit[i]) {
					visit[i]=true;
					check[i]=check[a]+1;
					
					if(max==check[i]) {
						maxTarget=(maxTarget>i)?maxTarget:i;
					}
					if(max<check[i]) {
						max=check[i];
						maxTarget=i;
					}
					
					q.offer(i);
				}
			}
			
		}
	}
}

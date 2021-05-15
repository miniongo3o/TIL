package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1916_최소비용 {
	static int[][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < m; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0])-1;
			int end = Integer.parseInt(str[1])-1;
			int cost = Integer.parseInt(str[2]);
			graph[start][end]=Math.min(cost, graph[start][end]);
		}
		
		for(int mid=0;mid<n;mid++) {
			for(int start=0;start<n;start++) {
				for(int end=0;end<n;end++) {
					if(mid==end)continue;
					if(graph[start][mid]!=Integer.MAX_VALUE&&graph[mid][end]!=Integer.MAX_VALUE&&graph[start][end]>graph[start][mid]+graph[mid][end]) {
						graph[start][end]=graph[start][mid]+graph[mid][end];
					}
				}
			}
		}
		
		
		
		String[] str = br.readLine().split(" ");
		int start = Integer.parseInt(str[0])-1;
		int end = Integer.parseInt(str[1])-1;
		System.out.println(graph[start][end]);
		
	}
}

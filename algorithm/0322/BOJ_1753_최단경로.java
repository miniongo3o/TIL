package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BOJ_1753_최단경로 {
	static class node implements Comparable<node>{
		int number;
		int weight;
		public node(int number, int weight) {
			super();
			this.number = number;
			this.weight = weight;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
		
	}
	
	static LinkedList<node>[] list;
	static boolean[] visit;
	static int[] distance;
	static int start,v,e;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		v = Integer.parseInt(str[0]);
		e = Integer.parseInt(str[1]);
		start = Integer.parseInt(br.readLine());
		
		distance = new int[v + 1];
		list=new LinkedList[v+1];
		Arrays.fill(distance, -1);
		visit=new boolean[v+1];
		int[][] arr = new int[v + 1][v + 1];
		
		for(int i=1;i<=v;i++) {
			list[i]=new LinkedList<>();
		}
		
		for (int i = 0; i < e; i++) {
			String[] temp = br.readLine().split(" ");
			int src = Integer.parseInt(temp[0]);
			int dst = Integer.parseInt(temp[1]);
			int weight = Integer.parseInt(temp[2]);
			list[src].add(new node(dst,weight));
		}
		
		dijkstra(start);
		for(int i=1;i<=v;i++) {
			System.out.println(distance[i]);
		}
	}
	static void dijkstra(int st) {
		PriorityQueue<node> pq=new PriorityQueue<>();
		pq.offer(new node(st,0));
		distance[st]=0;
		while(!pq.isEmpty()) {
			node now=pq.poll();
			if(!visit[now.number]) {
				visit[now.number]=true;
				for(node next:list[now.number]) {
					if(distance[next.number]==-1||distance[next.number]>distance[now.number]+next.weight) {
						distance[next.number]=distance[now.number]+next.weight;
						pq.offer(new node(next.number,distance[next.number]));
					}
				}
			}
		}
	}
}

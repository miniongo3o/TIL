package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697_숨바꼭질 {
	static class counter{
		int num;
		int cnt;
		public counter(int num,int cnt) {
			this.num=num;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int start=Integer.parseInt(str[0]);
		int end=Integer.parseInt(str[1]);
		
		Queue<counter> q=new LinkedList();
		q.offer(new counter(start,0));
		int max=100001;
		boolean visit[]=new boolean[max];
		visit[start]=true;
		
		while(!q.isEmpty()) {
			counter c=q.poll();
			int now=c.num;
			int count=c.cnt;
			
			 if(now==end) {
				 System.out.println(count);
				 return;
			 }
			 if(now+1<max&&!visit[now+1]) {
				 visit[now+1]=true;
				 q.offer(new counter(now+1,count+1));
			 }
			 if(now-1>=0&&!visit[now-1]) {
				 visit[now-1]=true;
				 q.offer(new counter(now-1,count+1));
			 }
			 if(now*2<max&&!visit[now*2]) {
				 visit[now*2]=true;
				 q.offer(new counter(now*2,count+1));
			 }
		}
		
		
	}
}

package ssafy_algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1158_요세푸스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int N=Integer.parseInt(str[0]);
		int R=Integer.parseInt(str[1]);
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		int cnt=1;
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			
			if(cnt==R) {
				sb.append(q.poll()).append(", ");
				cnt=1;
			}else {
				q.offer(q.poll());
				cnt++;
			}
		}
		sb.deleteCharAt(sb.length()-2);
		sb.deleteCharAt(sb.length()-1);
		sb.append(">");
		System.out.println(sb);
		
	}
}

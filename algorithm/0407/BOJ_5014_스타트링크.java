package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_5014_스타트링크 {
	static int F, S, G, U, D;
	static int min = Integer.MAX_VALUE;
	static boolean visit[];

	static class pos {
		int nowP, cnt;

		public pos(int nowP,int cnt) {
			this.nowP=nowP;
			this.cnt=cnt;
					
		}
	}

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] str = br.readLine().split(" ");
			F = Integer.parseInt(str[0]);
			S = Integer.parseInt(str[1]);
			G = Integer.parseInt(str[2]);
			U = Integer.parseInt(str[3]);
			D = Integer.parseInt(str[4]);
			visit = new boolean[F + 1];
			int max=Integer.MAX_VALUE;
			if (S == G) {
				System.out.println(0);
				return;
			}
			Queue<pos> q = new LinkedList();
			q.offer(new pos(S,0));
			visit[S] = true;
			while (!q.isEmpty()) {
				pos p = q.poll();
				int now=p.nowP;
				int cnt=p.cnt;
				if (now == G) {
					max=Math.min(cnt, max);
				}

				if (now + U <= F&&!visit[now+U]) {
					q.offer(new pos(now + U,cnt+1));
					System.out.println(now);
					visit[now + U] = true;
				}
				if (now - D > 0&&!visit[now-D]) {
					System.out.println(now);
					q.offer(new pos(now - D,cnt+1));
					visit[now - D] = true;
				}
			}
			if(max==Integer.MAX_VALUE) {
				System.out.println("use the stairs");
			}else {
				System.out.println(max);
			}
		}

}

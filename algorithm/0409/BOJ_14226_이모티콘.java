package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PrimitiveIterator.OfDouble;
import java.util.Queue;

public class BOJ_14226_이모티콘 {
	static class pos {
		int now, cnt, dup;

		public pos(int dup, int now, int cnt) {
			this.now = now;
			this.cnt = cnt;
			this.dup = dup;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean visit[][] = new boolean[1001][1001];
		visit[0][1]=true;
		Queue<pos> q = new LinkedList();
		q.offer(new pos(1, 0, 0));
		while (!q.isEmpty()) {
			pos p = q.poll();
			int now = p.now;
			int cnt = p.cnt;
			int dup = p.dup;
			
			
			if (now == n) {
				System.out.println(cnt);
				return;
			}
			// 1. 클립보드에 복사 : now+now 인덱스의 dp배열의 cnt가 더 크거나, 방문하지 않은경우
			q.offer(new pos(now,now,cnt+1));
			// 2. 클립보드에 있는 것을 붙여넣기
			if(dup!=0&&now+dup<=n&&!visit[dup][dup+now]) {
				q.offer(new pos(dup,now+dup,cnt+1));
				visit[dup][dup+now]=true;
			}

			// 3. 한개 빼기
			if(now>=1&&!visit[dup][now-1]) {
				q.offer(new pos(dup,now-1,cnt+1));
				visit[dup][now-1]=true;
			}
			
		}
	}
}

// 18 : 8
//  1 2 4 8 16 
//    2 3 5 6 7

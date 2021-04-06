package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13549_숨바꼭질3 {
	static int min = Integer.MAX_VALUE;
	static int minTime = Integer.MAX_VALUE;
	static int start, dest, cnt;
	static boolean[] visit;
	static int map[];
	static class pos{
		int dis;
		int time;
		public pos(int dis,int time) {
			this.dis=dis;
			this.time=time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		visit = new boolean[100001];
		map = new int[100001];
		start = Integer.parseInt(str[0]);
		dest = Integer.parseInt(str[1]);
		if (start >= dest) {
			System.out.println((start - dest) + "\n");
			return;
		}

		bfs();

		System.out.println(minTime);

	}

	private static void bfs() {

		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(start,0));
		map[start] = 1;

		while (!q.isEmpty()) {
			pos now = q.poll();
			visit[now.dis] = true;
			
			// 최소값보다 큰경우는 더이상 생각할 필요가 없음.
			if (min < map[now.dis])
				return;

			for (int i = 0; i < 3; i++) {
				int timeplus=0;
				int next;
				if (i == 0) {
					timeplus=1;
					next = now.dis + 1;
				} else if (i == 1) {
					timeplus=1;
					next = now.dis - 1;
				} else {
					next = now.dis * 2;
				}

				if (next < 0 || next > 100000) {
					continue;
				}

				if (next == dest) {
					cnt++;
					min = map[now.dis];
					minTime=Math.min(min, now.time+timeplus);
				}
				// 중복방문을 허용하되, 아래 경우만 허용한다.
				//이전 방문 시간과 현재 방문 시간이 일치할 때는 추가
				// 이전 방문 시간이 현재 방문 시간보다 늦은 경우는 추가
				// 이전 방문 시간이 현재 방문 시간보다 빠른 경우는 제외

				if (map[next] == 0 || map[next] == map[now.dis] + 1) {
					q.offer(new pos(next,now.time+timeplus));
					map[next] = map[now.dis] + 1;
				}
			}

		}

	}

}
/*
 * 4 8 16 17
 * 
 */

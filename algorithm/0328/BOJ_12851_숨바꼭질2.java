package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12851_숨바꼭질2 {
	static int min = Integer.MAX_VALUE;
	static int start, dest, cnt;
	static boolean[] visit;
	static int map[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		visit = new boolean[100001];
		map = new int[100001];
		start = Integer.parseInt(str[0]);
		dest = Integer.parseInt(str[1]);
		if (start >= dest) {
			System.out.println((start - dest) + "\n1");
			return;
		}

		bfs();

		System.out.println(min);
		System.out.println(cnt);

	}

	private static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		map[start] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();
			visit[now] = true;

			
			// 최소값보다 큰경우는 더이상 생각할 필요가 없음.
			if (min < map[now])
				return;

			for (int i = 0; i < 3; i++) {

				int next;
				if (i == 0) {
					next = now + 1;
				} else if (i == 1) {
					next = now - 1;
				} else {
					next = now * 2;
				}

				if (next < 0 || next > 100000) {
					continue;
				}

				if (next == dest) {
					cnt++;
					min = map[now];
				}
				// 중복방문을 허용하되, 아래 경우만 허용한다.
				//이전 방문 시간과 현재 방문 시간이 일치할 때는 추가
				// 이전 방문 시간이 현재 방문 시간보다 늦은 경우는 추가
				// 이전 방문 시간이 현재 방문 시간보다 빠른 경우는 제외

				if (map[next] == 0 || map[next] == map[now] + 1) {
					q.offer(next);
					map[next] = map[now] + 1;
				}
			}

		}

	}

}
/*
 * 4 8 16 17
 * 
 */

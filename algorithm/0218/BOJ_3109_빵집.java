package ssafy_algo_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ws_식당예제 {
	// 오른쪽, 오른쪽위, 오른쪽아래
	static int[] dy = { -1, 0, 1 };
	static int[] dx = { 1, 1, 1 };
	static char[][] arr;
	static int r, c;
	static int answer = 0;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static boolean[][] visit;
	static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		arr = new char[r][c];
		visit = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String temp = br.readLine();
			arr[i] = temp.toCharArray();
		}

		for (int i = 0; i < r; i++) {
			dfs(i, 0, 0);
		}
		System.out.println(answer);
		// 모든경로다구함
		// 그중 최소를 구함
		// 최소와 같은것들의 갯수 카운트
		// 이동방향은 오른쪽, 위대각,아래대각으로만,,

	}

	public static boolean dfs(int y, int x, int cnt) {
		// 기저조건.
		if (x == c-1) {
			//System.out.println(y+" ! "+x);
			answer++;
			return true;
		}
		
		
		//visit[y][x] = true;
		
		//3가지 방향을 순회
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//x는 c일때 멈춤.
			if (ny>=0&&ny<r&&arr[ny][nx] == '.' && !visit[ny][nx]) {
				//아직 방문하지 않은곳이면서 지나갈 수 있는곳이라면 이동을 진행한다.
				// 재귀를 사용해서, 갈 수 있는 곳이라면 true반환
				visit[ny][nx]=true;
				boolean torf = dfs(ny, nx, cnt + 1);
				if (torf) {
					return true;
				}else {
					visit[ny][nx]=true;
				}
			}

		}
		//모든 방향을 다 돌았는데 진행이 불가능하다면? 해당칸은 방문하지않은것
		visit[y][x] = true;
		return false;
		

	}
}

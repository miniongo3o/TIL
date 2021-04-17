package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_19236_청소년상어 {
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static class fish {
		int id;
		int y, x, dir;
		boolean isAlive;

		public fish(int id, int y, int x, int dir, boolean isAlive) {
			super();
			this.id = id;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.isAlive = isAlive;
		}

	}

	static int sum = 0;

	static class shark {
		int y, x, dir, sum;

		public shark(int y, int x, int dir, int sum) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.sum = sum;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[4][4];
		ArrayList<fish> fishlist = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 8; j += 2) {
				int id = Integer.parseInt(str[j]);
				int dir = Integer.parseInt(str[j + 1]) - 1;
				arr[i][j / 2] = id;
				fishlist.add(new fish(id, i, j / 2, dir, true));
			}
		}

		Collections.sort(fishlist, new Comparator<fish>() {
			@Override
			public int compare(fish o1, fish o2) {
				return o1.id - o2.id;
			}

		});
		

		fish f=fishlist.get(arr[0][0]-1);
		shark shark=new shark(0,0,f.dir,f.id);
		
		f.isAlive=false;
		arr[0][0]=17;
		
		dfs(arr,shark,fishlist);
		System.out.println(sum);
	}

	public static void dfs(int[][] arr, shark shark, ArrayList<fish> fishlist) {
		if (sum < shark.sum) {
			sum = shark.sum;
		}
		fishlist.forEach(e -> move(e, arr, fishlist));

		for (int i = 1; i < 4; i++) {
			int ny = shark.y + dy[shark.dir] * i;
			int nx = shark.x + dx[shark.dir] * i;

			if (ny >= 0 && nx >= 0 && ny < 4 && nx < 4 && arr[ny][nx] > 0) {
				// 다음으로 넘어가기 위해 배열과 피쉬리스트 복사
				int[][] copy=copy(arr);
				ArrayList<fish> fishcopy=copyfish(fishlist);
				
				// 상어가 있던 곳 0으로 바꿈
				copy[shark.y][shark.x]=0;
				
				// 잡아먹힐 물고기 id를 구함
				int id=copy[ny][nx];
				fish killed=fishcopy.get(id-1);
				
				// 해당 물고기 죽음으로 표시하고, 새로운 상어 생성하여 다음 dfs로 넘어간다.
				killed.isAlive=false;
				shark newShark=new shark(killed.y,killed.x,killed.dir,shark.sum+killed.id);
				copy[ny][nx]=17;
				
				dfs(copy,newShark,fishcopy);
				
				
				
				
			}

		}

	}

	public static void move(fish f, int[][] arr, ArrayList<fish> fishlist) {

		if (f.isAlive) {
			for (int dir = 0; dir < 8; dir++) {
				int nextDir = (f.dir + dir) % 8;
				int ny = f.y + dy[nextDir];
				int nx = f.x + dx[nextDir];

				// 벽이거나 상어인 경우는 방향을 회전함. 이동한 경우는 바로 return으로 함수 종료
				if (ny >= 0 && nx >= 0 && ny < 4 && nx < 4 && arr[ny][nx] != 17) {
					arr[f.y][f.x] = 0;
					// 다음칸이 비었을 때
					if (arr[ny][nx] == 0) {
						f.y = ny;
						f.x = nx;
					} else {
						// 다음칸이 비어있지 않을 때
						// 기존칸에 다음 물고기를 위치 시킴
						fish nextfish = fishlist.get(arr[ny][nx] - 1);
						// 다음칸의 물고기 좌표를 기존 칸 좌표로 바꿈
						nextfish.y = f.y;
						nextfish.x = f.x;
						arr[f.y][f.x] = nextfish.id;
						f.y = ny;
						f.x = nx;
					}
					// 기존 물고기의 정보를 업데이트
					// 다음칸에 기존 물고기 위치시킴

					arr[ny][nx] = f.id;
					f.dir = nextDir;


					return;
				}

			}

		}

	}

	public static void printer(int[][] arr) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] copy(int src[][]) {
		int[][] dest = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				dest[i][j] = src[i][j];
			}
		}
		return dest;
	}

	public static ArrayList<fish> copyfish(ArrayList<fish> src) {
		ArrayList<fish> dest = new ArrayList<>();
		src.forEach(e -> dest.add(new fish(e.id, e.y, e.x, e.dir, e.isAlive)));
		return dest;
	}
}

// 1. 입력
// 2. 상어가 0,0에 위치, 해당 물고기 방향을 가짐
// 3. 물고기 이동 : 작은 번호부터. 해당 방향의 물고기와 위치를 바꾼다.
// 4. 만약 해당 방향이 벽이거나, 상어인 경우 반시계방향으로 45도 방향을 바꾼다.
// 5. 물고기 이동이 끝나면 상어가 이동한다. 현재 가지고 있는 방향에서 자유롭게 움직인다.
// 6. 해당 물고기를 먹으면 또 해당방향으로 자유롭게 이동가능하다. 이 떄, 벽울 만나거나 물고기가 없는 칸(0)을 만나면 멈춘다.
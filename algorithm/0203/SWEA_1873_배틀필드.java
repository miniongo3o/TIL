package ssafy_algo_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T07_1873_D3 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= n; tc++) {
			String[] temp = br.readLine().split(" ");
			int H = Integer.parseInt(temp[0]);
			int W = Integer.parseInt(temp[1]);
			int y = 0, x = 0;
			String[][] arr = new String[H][W];
			for (int i = 0; i < H; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < W; j++) {
					arr[i][j] = str[j];
					if (arr[i][j].equals("<") || arr[i][j].equals(">") || arr[i][j].equals("^")
							|| arr[i][j].equals("v")) {
						y = i;
						x = j;
					}
				}
			}
			int dir = 0;
			switch (arr[y][x]) {
			case "<":
				dir = 2;
				break;
			case ">":
				dir = 0;
				break;
			case "^":
				dir = 3;
				break;
			case "v":
				dir = 1;
				break;
			}

			int order = Integer.parseInt(br.readLine());
			String orderList = br.readLine();

			for (int t = 0; t < order; t++) {
				char o = orderList.charAt(t);
				
				if (o == 'U') {
					dir = 3;
					int tempY=y+dy[dir];
					if (tempY >= 0 && arr[tempY][x].equals(".")) {
						arr[y][x] = ".";
						y = tempY;
					}
					arr[y][x] = "^";
					
				} else if (o == 'R') {
					dir = 0;
					int tempX=x+dx[dir];
					if (tempX < W && arr[y][tempX].equals(".")) {
						arr[y][x] = ".";
						x = tempX;
					}
					arr[y][x] = ">";
					
				} else if (o == 'L') {
					dir = 2;
					int tempX=x+dx[dir];
					if (tempX >= 0 && arr[y][tempX].equals(".")) {
						arr[y][x] = ".";
						x =tempX;
					}
					arr[y][x] = "<";
					

				} else if (o == 'D') {
					dir = 1;
					int tempY=y+dy[dir];
					if (tempY < H  && arr[tempY][x].equals(".")) {

						arr[y][x] = ".";
						y = tempY;
					}
					arr[y][x] = "v";
					

				} else {
					// 공격 : S입력
					int ny = y;
					int nx = x;

					while (true) {
						ny += dy[dir];
						nx += dx[dir];

						// 범위안일때
						if (ny >= 0 && nx >= 0 && ny < H && nx < W) {

							// 평지나 물일떄 때
							if (arr[ny][nx].equals(".") || arr[ny][nx].equals("-")) {

								continue;
							} else if (arr[ny][nx].equals("*")) {
								// 벽돌일 때
								arr[ny][nx] = ".";
								break;
							} else {
								// 강철벽일 때
								break;
							}

						} else {
							// 범위밖일때
							break;
						}
					}
				}


				}
			System.out.print("#" + tc + " ");
			for (int z = 0; z < arr.length; z++) {
				for (int f = 0; f < arr[0].length; f++) {
					System.out.print(arr[z][f]);
				}	
				System.out.println("");

			}
		}
	}
}

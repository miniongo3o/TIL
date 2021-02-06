package ssafy_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day2_SWEA_LADDER {
	static int ladder[][] = new int[100][100];
	static boolean find = false;
	final static int size=100;
	final static int test_case=10;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int T = 0; T < test_case; T++) {
			br.readLine();

			int[][] arr = new int[size][size];
			int y=99,x=0;
			//입력받기
			for (int r = 0; r < size; r++) {
				String[] str = br.readLine().split(" ");
				for (int c = 0; c < size; c++) {
					arr[r][c]=Integer.parseInt(str[c]);
				}
			}
					
			
			for(int i=0;i<size;i++) {
				// 2에서부터 올라간다.
				if(arr[99][i]==2) {
					x=i;
					break;
				}
			}
			
			
			while(y>0) {
				
				if(x>0&&arr[y][x-1]==1) {
					//왼쪽
					x--;
					
				}else if(x<99&&arr[y][x+1]==1) {
					//오른쪽
					x++;
					
				}else {
					//위로
					y--;
				}
				arr[y][x]=0;
				
			}
			System.out.println("#"+test_case+" "+x);
		

		}

	}
}
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
	static int n;
	static int[][] arr;
	static int down = 1;
	static int up = -1;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				int flag = 0;
				for (int j = 0; j < n; j++) {
					if (arr[j][i] == 1) {
						
						if(flag==0) {
							flag=1;
						}
						
						if(flag==1) {
							flag=1;
						}
						
					} else if (arr[j][i] == 2) {
						
						if(flag==0) {
							continue;
						}
						
						if(flag==1) {
							sum+=1;
							flag=0;
						}
						
					}
				}
				
				if(flag!=0) {
					continue;
				}else{
					
				}

			}
			System.out.println("#"+t+" "+sum);
		}
	}

}

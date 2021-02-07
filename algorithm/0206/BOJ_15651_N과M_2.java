package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_15651 {


		static int num;
		static int N;
		static int[] arr;

		public static void main(String[] args) throws IOException {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String[] str=br.readLine().split(" ");
			num=Integer.parseInt(str[0]);
			N=Integer.parseInt(str[1]);
			
			arr = new int[num];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i + 1;
			}
			permu(0, new int[N]);
		}

		public static void permu(int toSelect, int[] selected) {

			if (toSelect == N) {
	            StringBuilder sb=new StringBuilder();
				for (int i = 0; i < selected.length; i++) {
	                //System.out.print(selected[i]+" ");
					sb.append(selected[i]).append(" ");
				}
				System.out.println(sb);
				return;
			}

			for (int i = 0; i < arr.length; i++) {
	            selected[toSelect]=arr[i];
	            permu(toSelect+1,selected);
				
			}
		}
	}
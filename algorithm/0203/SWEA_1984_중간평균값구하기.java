package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//중간 평균값 구하가ㅣ
public class SWEA_1984 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++) {
			int sum=0;
			int[] arr=new int[10];
			String[] str=br.readLine().split(" ");
			System.out.println(Arrays.toString(str));
			for(int j=0;j<10;j++) {
				arr[j]=Integer.parseInt(str[j]);
			}
			Arrays.sort(arr);
			for(int j=1;j<9;j++) {
				sum+=arr[j];
			}
			
			long answer=Math.round((double)sum/8);
			System.out.println("#"+i+" "+answer);
		}
	}
}

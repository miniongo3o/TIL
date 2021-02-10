package ssafy_algo_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10448_유레카이론 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] tri = new int[51];
		int[] sum = new int[5000];

		for (int i = 1; i <= 50; i++) {
			tri[i] = i * (i + 1) / 2;
		}
		for(int i=1;i<=50;i++) {
			for(int j=1;j<=50;j++) {
				for(int k=1;k<=50;k++) {
					sum[tri[i]+tri[j]+tri[k]]=1;
				}
			}
		}
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			int N=Integer.parseInt(br.readLine());
			System.out.println(sum[N]==1 ? 1:0);
		}

	}

}
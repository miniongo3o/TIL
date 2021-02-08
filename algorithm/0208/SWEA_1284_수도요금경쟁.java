package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1284_수도요금경쟁 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=N;t++) {
			String[] str=br.readLine().split(" ");
			int P,Q,R,S,W;
			P=Integer.parseInt(str[0]);
			Q=Integer.parseInt(str[1]);
			R=Integer.parseInt(str[2]);
			S=Integer.parseInt(str[3]);
			W=Integer.parseInt(str[4]);
			
			int x1=P*W;
			int x2;
			if(W>R) {
				x2=Q+(W-R)*S;
			}else {
				x2=Q;
			}
			int result=x1>x2?x2:x1;
			System.out.println("#"+t+" "+result );
					
		}
	}
}

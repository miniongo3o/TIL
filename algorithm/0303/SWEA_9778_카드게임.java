package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SWEA_9778_카드게임 {
	static int t,n;
	static int list[];
	static int card[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		t=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			n=Integer.parseInt(br.readLine());
			
			//카드 초기화. 1~9까지 4장, 10은 16장
			list=new int[12];
			for(int i=2;i<=11;i++) {
				list[i]=4;
			}
			
			list[10]=16;
			int sum=0;
			for(int i=0;i<n;i++) {
				int temp=Integer.parseInt(br.readLine());
				// 입력카드가 1이면 11을 처리해준다.
				
				sum+=temp;
				list[temp]-=1;
			}
			
			int target=21-sum;
			int gazua=0;
			int stop=0;
			for(int i=2;i<=11;i++) {
				// 21에서 합을 뺸것보다 큰 수 -> 21을 초과하게 만드는수
				//스탑하게 만드는 수들
				if(i>target) {
					stop+=list[i];
				}else {
				// 21과 같거나 더 작게 만들어주는 수. 가즈아를 만드는 카드들
					gazua+=list[i];
				}
			}
			if(stop>=gazua) {
				sb.append("#"+tc+" STOP\n");
			}else {
				sb.append("#"+tc+" GAZUA\n");
			}
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}

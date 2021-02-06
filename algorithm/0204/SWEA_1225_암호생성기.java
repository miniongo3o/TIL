package ssafy_algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T11_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1;i<=10;i++) {
			Queue<Integer> que=new LinkedList<Integer>();
			br.readLine();
			String[] str=br.readLine().split(" ");
			int[] arr=new int[str.length];
			for(int j=0;j<str.length;j++) {
				que.add(Integer.parseInt(str[j]));
			}

			
			int c=1;
			while(true) {
				if(c==6)c=1;
				int temp=que.poll()-c;
				c++;
				if(temp<=0) {
					que.add(0);
					break;
				}
				que.add(temp);
			}

			
			System.out.print("#"+i+" ");
			for(int k=0;k<que.size();) {
				System.out.print(que.poll()+" ");
			}
			System.out.println();
			
		}
	}
}

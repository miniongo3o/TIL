package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1931_회의실배정 {
	static class time implements Comparable<time>{
		int start,end;
		public time(int start,int end) {
			this.start=start;
			this.end=end;
		}
		
		@Override
		public int compareTo(time o) {
			if(this.end==o.end) {
				return this.start-o.start;
			}
			return this.end-o.end;
		}
		
		public String toString() {
			return this.start+" "+this.end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		time arr[]=new time[n];
		for(int i=0;i<n;i++) {
			String[]str =br.readLine().split(" ");
			arr[i]=new time(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
		}
		
		Arrays.sort(arr);
		int cnt=0;
		int end=-1;
		for(int i=0;i<n;i++) {
			if(arr[i].start>=end) {
				end=arr[i].end;
				cnt++;
				System.out.println(arr[i].start+" "+arr[i].end);
			}
		}
		System.out.println(cnt);
		
	}
}

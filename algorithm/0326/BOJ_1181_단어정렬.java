package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		str[] arr=new str[n];
		for(int i=0;i<n;i++) {
			arr[i]=new str(br.readLine());
		}
		Arrays.sort(arr);
		Set<String> ss = new HashSet<>();
		for(str str1:arr) {
			if(!ss.contains(str1.word)) {
				sb.append(str1.word+"\n");
			}
			ss.add(str1.word);
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	static class str implements Comparable<str>{
		String word;

		public str(String word) {
			this.word=word;
		}
		public String toString() {
			return this.word;
		}
		@Override
		public int compareTo(str o) {
			if(this.word.length()==o.word.length()){
				
				for(int i=0;i<this.word.length();i++) {
					if(this.word.charAt(i)==o.word.charAt(i)) {
						continue;
					}
					return this.word.charAt(i)-o.word.charAt(i);
				}
				return 0;

			}
			return this.word.length()-o.word.length();
		}
		
		
		
	}

}

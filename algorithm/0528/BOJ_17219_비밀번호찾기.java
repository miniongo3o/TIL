package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_17219_비밀번호찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int n =Integer.parseInt(str[0]);
		int m =Integer.parseInt(str[1]);
		HashMap<String,String> map=new HashMap();
		for(int i=0;i<n;i++) {
			String[] temp=br.readLine().split(" ");
			map.put(temp[0], temp[1]);
		}
		
		for(int i=0;i<m;i++) {
			System.out.println(map.get(br.readLine()));
		}
	}
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int res=0;
		// 들어온 적이 있는 문자인지 체크하기 위한 set
		
		for(int i=0;i<n;i++) {
			Set<Character> set=new HashSet();
			char[] arr=br.readLine().toCharArray();
			//바로 직전문자를 기록하기위한 before
			char before='.';
			boolean flag=true;
			for(int j=0;j<arr.length;j++) {
				
				// 만약 set에 등록되어있을 때,
				if(set.contains(arr[j])){
					//직전문자와 다르다면, 그룹문자가 아니다.
					if(before!=arr[j]) {
						flag=false;
						break;
					}
				}else {
					//set에 등록되어있지 않다.(=처음들어왔다)
					before=arr[j];
					set.add(arr[j]);
				}

				
			}
			if(flag) {
				res+=1;
			}
		}
		System.out.println(res);
	}
}

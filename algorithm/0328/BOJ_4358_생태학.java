package BOJ;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BOJ_4358_생태학 {
	public static void main(String[] args) throws IOException {
		double sum=0;
		HashMap<String, Integer> hash=new HashMap<>();
		Scanner sc=new Scanner(new FileInputStream("inp.txt"));
		StringBuilder sb=new StringBuilder();
		while(sc.hasNext()) {
			String str=sc.nextLine();
			if(hash.get(str)==null) {
				hash.put(str, 1);
			}else {
				hash.put(str, hash.get(str)+1);
			}
			sum+=1;
		}
		Set<String> keys = hash.keySet();
		List list=new ArrayList(keys);
		Collections.sort(list);
		for(Object key:list) {
			sb.append(key+" "+String.format("%.4f",hash.get(key)/sum*100)+"\n");
		}
		System.out.println(sb);
		
	}
}

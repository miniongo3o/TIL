package Programmers;
import java.util.HashMap;
import java.util.Set;

class Kakao2018_뉴스클러스터링 {
    public int solution(String str1, String str2) {
       int answer = 0;

       // 교집합, 합집합을 구하기위한 2개의 해쉬맵
		HashMap<String, Integer> hash1 = new HashMap();
		HashMap<String, Integer> hash2 = new HashMap();

		// 모두 소문자로 통일
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		makeHash(hash1, str1);
		makeHash(hash2, str2);

	
		// 교집합의 수 cnt1
		int cnt1 = 0;
		
		// hash1이 가지고 있는 key를 기준으로 확인 
		//= hash1에 없고 hash2에 있는 경우는 교집합아니니까 한번만 돌면 된다.
		// 교집합은, 두개의 문자열의 공통 부분문자열의 최소값이다. 
		if (hash2.size() != 0) {
			for (String k : hash2.keySet()) {
				if (hash1.get(k) != null) {
					cnt1 += Math.min(hash1.get(k), hash2.get(k));
				}
			}
		}
		
		// 합집합의 수 cnt2
		// 합집합의 수는 두개의 총 수에서 교집합수를 뺴주면 된다.
		int cnt2 = 0;
		for (String k : hash1.keySet()) {
			cnt2 += hash1.get(k);
		}
		for (String k : hash2.keySet()) {
			cnt2 += hash2.get(k);
		}
		cnt2 -= cnt1;

		

        if(cnt1==0){
            if(cnt2==0){
            	// 교집합과 합집합 둘다 없는 경우는 65536을 return
            	// 둘다 공집합인 J(0,0)은 1으로 규정했음.
            	//
                return 65536;
            }
            // 교집합이 없고 합집합만 있는경우는 0을 return
            // 유사도가 없음
            return 0;
        }
        
		
		double a = (double) cnt1;
		double b = (double) cnt2;
		answer = (int) (a / b * 65536);
		

		return answer;
    }
    	public static void makeHash(HashMap<String, Integer> hash, String str1) {
		String string = "";
		int len1 = str1.length();
		for (int i = 0; i < len1; i++) {
			if (str1.charAt(i) < 65 || str1.charAt(i) > 122) {
				string = "";
				continue;
			}
			if (str1.charAt(i) >= 91 && str1.charAt(i) <= 96) {
				string = "";
				continue;
			}
			if (string.equals("")) {
				string = Character.toString(str1.charAt(i));
			} else {
				string += Character.toString(str1.charAt(i));

				if (hash.get(string) != null) {
					hash.put(string, hash.get(string) + 1);
				} else {
					hash.put(string, 1);
				}
				string = Character.toString(str1.charAt(i));
			}
		}
	}
}
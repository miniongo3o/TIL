package Programmers;
import java.util.HashMap;
import java.util.Set;

class Kakao2018_뉴스클러스터링 {
    public int solution(String str1, String str2) {
       int answer = 0;

		HashMap<String, Integer> hash1 = new HashMap();
		HashMap<String, Integer> hash2 = new HashMap();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		makeHash(hash1, str1);
		makeHash(hash2, str2);

	

		Set<String> keyset = hash1.keySet();
		int cnt1 = 0;

	    

		if (hash2.size() != 0) {
			for (String k : hash2.keySet()) {

				if (hash1.get(k) != null) {
					cnt1 += Math.min(hash1.get(k), hash2.get(k));
				}

			}
		}
		
		
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
                return 65536;
            }
            return 0;
        }
        if(cnt2==0){
            
            return 65536;
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
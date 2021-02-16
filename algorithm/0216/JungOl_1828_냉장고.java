package algo_hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class JungOl_1828_냉장고{
	
	   public static class ref implements Comparable<ref> {
	        int s;
	        int e;
	 
	        public ref(int s, int e) {
	            this.s = s;
	            this.e = e;
	        }
	 
	        @Override
	        public int compareTo(ref o) {
	            return this.e - o.e;
	        }

			@Override
			public String toString() {
				return "ref [s=" + s + ", e=" + e + "]";
			}
	        
	    }
	 
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        ref[] ref = new ref[N];
	        for (int i = 0; i < N; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            ref[i] = new ref(a, b);
	        }
	        int count = 1;
	        Arrays.sort(ref);
	        
	        
	        ref p = ref[0]; 
	        int i = 1;
	        while(i < N) {
	            if (ref[i].s > p.e) {
	                p = ref[i];
	                count++;
	            }            
	            i++;
	        }
	        System.out.println(count);
	    }
	}

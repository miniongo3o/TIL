import java.util.Arrays;

public class algo_0119 {
	public static void main(String[] args) {
		Solution newsol=new Solution();
		int[] pri= {1,2,3,2,3};
		System.out.println(Arrays.toString(newsol.solution(pri)));
	}

}
class Solution {
    public int[] solution(int[] pri) {
        int[] answer = new int[pri.length];
        
        for(int i=0;i<pri.length;i++){
            for(int j=i+1;j<pri.length;j++){
                if(pri[i]>pri[j]){
                    answer[i]=j-i;
                    break;
                }
                
                if(j==pri.length-1){
                    answer[i]=j-i;
                }
            }
           
        }
        
        return answer;
    }
}
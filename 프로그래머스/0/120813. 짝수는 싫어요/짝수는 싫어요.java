class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n+1)/2];
        int x = 0;
        
        for (int i =1; i <=n; i++) {    
            if (i % 2 != 0) {
                answer[x++] = i;                
            }            
        }
        return answer;
    }
}
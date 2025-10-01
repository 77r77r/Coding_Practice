class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        int sum = 0;
        
        int as = 0;
        int to = 0;
        for (int i=1; i < numLog.length; i++) {
            as = numLog[i-1];
            to = numLog[i];        
            
            switch(to-as) {
                case 1 : answer.append("w"); break;
                case -1 : answer.append("s"); break;
                case -10 : answer.append("a"); break;
                case 10 : answer.append("d");break;                    
            }
        }
        
        
        return answer.toString();
    }
}
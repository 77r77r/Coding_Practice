class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        
        for (int i = 0; i <= num_list.length; i++) {
            if (i == num_list.length) {
                answer[i] = num_list[num_list.length -1] > num_list[num_list.length -2] ? 
                    (num_list[num_list.length -1] - num_list[num_list.length -2]) : num_list[num_list.length -1]*2;
            } else {
                answer[i] = num_list[i];
            }
            
        }        
        return answer;
    }
}
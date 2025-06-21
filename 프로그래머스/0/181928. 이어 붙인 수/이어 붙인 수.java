class Solution {
    public int solution(int[] num_list) {
        String odd = "";
        String even = "";
        
        for (int x : num_list) {
            if (x % 2 == 0) {
                even += x;
            } else {
                odd +=x;
            }
        }        
        return Integer.parseInt(odd) + Integer.parseInt(even);
    }
}
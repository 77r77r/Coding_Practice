class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (String x : s1) {
            for (String y : s2) {
                if (x.equals(y)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
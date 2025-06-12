class Solution {
    public int solution(int a, int b) {
        int x = Integer.parseInt("" + a + b);
        return x >= (2 * a * b) ? x : (2 * a * b);
    }
}
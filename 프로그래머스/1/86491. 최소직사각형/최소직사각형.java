import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        // 각 명함의 가로, 세로 값을 비교하여 큰값, 작은값으로 세팅
        for (int[] x : sizes) {
            if (x[0] < x[1]) {
                int temp = x[0];
                x[0] = x[1];
                x[1] = temp;
            }
        }
        
        int w_max = 0;
        int h_max = 0;
        
        // 가로, 세로의 각 최대 길이를 구해서 곱한다.
        for (int[] x : sizes) {
            if (w_max < x[0]) {
                w_max = x[0];
            }
            if (h_max < x[1]) {
                h_max = x[1];
            }
        }       
        
        return w_max*h_max;
    }
}
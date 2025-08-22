import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // ?? 문제가 이해가 안됨
        
        // 1. 논문 개수 : n
        // H-index 조건 
        // 1. h번 이상 논문 h개 이상
        // 2. n - h 는 h 이하 인용
        // 정렬 -> n - (index) :: h번 이상 논문 갯수
                
        int n = citations.length;   // 논문 갯수
        // int h1 = citations[i];   // 논문 인용 횟수
        
        // citationsp[] 자기 자신보다 큰 값이 몇개 있는지 찾기
        // -> (citationsp.length - index 번호)가 자기보다 인용 횟수가 많은 논문
        
        Arrays.sort(citations);
        // citations.length - (i) = citations[i] 이상 논문 갯수
        
        // 조건 1.
        // n 편중 h 번 이상 인용된 논문이 h개 이상
        // 
        
        int h = 0;
        int max = h;
        
               
        
        // h가 꼭 제공된 배열의 값이여아만 하나? -> 아닐 것 같은데
        // int h =
        
        for (int i = 0; i < n; i++) {
            
            // h 번 이상 인용된 논문 수 -> n - index
            if (n - i <= citations[i]) {
                max = ++h > max ? h : max;
            }
        }
        
        return -1;
    }
}
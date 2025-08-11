import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> a = new ArrayList();
        int last;        
    
        for (int i : arr) {
            if (a.size() == 0) {
                a.add(i);
            }
            else {
                if (i != a.get(a.size() -1)) {
                    a.add(i);
                }
            }
        }
        
        return a.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
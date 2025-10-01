import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for (int[] q : queries) {
            List<Integer> t = new ArrayList<>();
            for (int i=q[0]; i <= q[1]; i++) {
                if (arr[i] > q[2]) {
                    t.add(arr[i]);
                }
            }
            if (t.isEmpty()) {
              list.add(-1);
            } else {
                Collections.sort(t);
                list.add(t.get(0));    
            }            
        }
        
        return list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
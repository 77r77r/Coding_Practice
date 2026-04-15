import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        // 각 로봇의 전체 이동 경로 (시간 순서대로 좌표)
        List<List<int[]>> allPaths = new ArrayList<>();
        
        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();
            
            // 시작 위치
            int[] start = points[route[0] - 1];
            path.add(new int[]{start[0], start[1]});
            
            for (int i = 1; i < route.length; i++) {
                int[] from = points[route[i - 1] - 1];
                int[] to = points[route[i] - 1];
                
                int r = from[0];
                int c = from[1];
                
                // r 먼저 이동
                while (r != to[0]) {
                    r += (to[0] > r) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
                
                // c 이동
                while (c != to[1]) {
                    c += (to[1] > c) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
            }
            
            allPaths.add(path);
        }
        
        // 최대 시간
        int maxTime = 0;
        for (List<int[]> path : allPaths) {
            maxTime = Math.max(maxTime, path.size());
        }
        
        // 시간별 시뮬레이션
        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> map = new HashMap<>();
            
            for (List<int[]> path : allPaths) {
                if (t < path.size()) {
                    int[] pos = path.get(t);
                    String key = pos[0] + "," + pos[1];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            
            // 충돌 카운트
            for (int cnt : map.values()) {
                if (cnt >= 2) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
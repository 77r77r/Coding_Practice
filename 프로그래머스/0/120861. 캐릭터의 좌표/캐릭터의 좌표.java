class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // up을 누른다면 캐릭터의 좌표는 [0, 1]
        // down을 누른다면 [0, -1],
        // left를 누른다면 [-1, 0], 
        //right를 누른다면 [1, 0]
        int[] dx = {0, 0, -1, 1};   // u, d, l, r
        int[] dy = {1, -1, 0, 0};
        
        int nx = 0;
        int ny = 0;
        int[] SIZE = {board[0] / 2, board[1] / 2};
        
        for (String key : keyinput) {
            switch (key) {
                case "up" : 
                    if (ny < SIZE[1]) ny += dy[0];
                    break;
                case "down" :
                    if (ny > -SIZE[1]) ny += dy[1];
                    break;
                case "left" : 
                    if (nx > -SIZE[0]) nx += dx[2];
                    break;
                case "right" :
                    if (nx < SIZE[0]) nx += dx[3];
                    break;
            }
        }
       
        return new int[]{nx, ny};
    }
}
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // "prev" : 10초 전, 미만인 경우 처음
        // "next" : 10초 후, 남은 시간 10초 미만인 경우 마지막
        // 건너뛰기 : op_start ≤ 현재 재생 위치 ≤ op_end 오프닝 종료 위치
        int videoMM = Integer.parseInt(video_len.split(":")[0]) * 60;
        int videoSS = Integer.parseInt(video_len.split(":")[1]);
        int videoTime = videoMM + videoSS;
        
        int posMM = Integer.parseInt(pos.split(":")[0])* 60;
        int posSS = Integer.parseInt(pos.split(":")[1]);
        int posTime = posMM + posSS;
        
        int startMM = Integer.parseInt(op_start.split(":")[0]) * 60;
        int startSS = Integer.parseInt(op_start.split(":")[1]);
        int startTime = startMM + startSS;
        
        int endMM = Integer.parseInt(op_end.split(":")[0]) * 60;
        int endSS = Integer.parseInt(op_end.split(":")[1]);
        int endTime = endMM + endSS;
        
        int curTime = 0;
        
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            
            if (startTime <= posTime && posTime <= endTime) {
                posTime = endTime;
            }
            
            switch(command) {
                case "prev" :
                    posTime = posTime > 10 ? posTime - 10 : 0;
                    break;
                case "next" : 
                    posTime = posTime + 10 > videoTime ? videoTime : posTime + 10;
                    break;
            }
            
            if (startTime <= posTime && posTime <= endTime) {
                posTime = endTime;
            }
        }
        
        int mm = posTime / 60;
        int ss = posTime % 60;
        
        String m = mm < 10 ? "0" + mm : String.valueOf(mm);
        String s = ss < 10 ? "0" + ss : String.valueOf(ss);
        answer = m + ":" + s;
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int k = 0;
        List<int[]> list = new ArrayList<>();
        
        for (int[] info : data) {
            int code = info[0];
            int date = info[1];
            int maximum = info[2];
            int remain = info[3];
            
            switch (ext) {
                case "code" :
                    if(code < val_ext) {
                        list.add(info);
                    }
                    break;
                case "date" :
                    if (date < val_ext) {
                        list.add(info);
                    }
                    break;
                case "maximum" :
                    if (maximum < val_ext) {
                        list.add(info);
                    }
                    break;
                default :
                    if (remain < val_ext) {
                        list.add(info);
                    }
            }
        }
    
        if (sort_by.equals("code")) {
            list.sort((a,b)-> a[0] -b[0]);
        } else if (sort_by.equals("date")) {
            list.sort((a,b)-> a[1] -b[1]);
        } else if (sort_by.equals("maximum")) {
            list.sort((a,b)-> a[2] -b[2]);
        } else {
            list.sort((a,b)-> a[3] -b[3]);
        }
            
        
        
        return list.toArray(new int[list.size()][]);
    }
}
class Solution {
    public int solution(int a, int b) {
        int x = attach(a, b);
        int y = attach(b, a);
        
        return (x >= y) ? x : y;
    }
    
    public Integer attach(int x, int y){
        //return Integer.parseInt(Integer.toString(x) + Integer.toString(y));
        // 시간이 오래걸리는 것 같아서 형변환을 줄여봤다
        return Integer.parseInt("" + x + y);
    }        
}
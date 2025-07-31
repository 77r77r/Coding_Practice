class Solution {
    public String solution(String my_string, int n) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i <my_string.length(); i++) {
            result.append(String.valueOf(my_string.charAt(i)).repeat(n));
        }
        return result.toString();
    }
}
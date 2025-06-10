import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = "";
        
        for (char c : a.toCharArray()) {
            if (Character.isUpperCase(c)) { //대문자
                str = str + Character.toLowerCase(c);
            } else {    // 소문자
                str = str + Character.toUpperCase(c);
            }
        }
        System.out.print(str);
    }
}
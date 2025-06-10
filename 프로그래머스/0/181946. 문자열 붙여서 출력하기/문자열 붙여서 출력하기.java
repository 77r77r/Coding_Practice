import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        if (a.length() < 1 || b.length() < 1) {
            System.out.println("1자리 이상 입력");
        } else if (a.length() > 10 || b.length() > 10) {
            System.out.println("10자리 이하 입력");
        } else {
            System.out.println(a+b);    
        }
    }
}
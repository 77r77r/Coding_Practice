import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        String b = sc.next();
        
        System.out.println(a * (b.charAt(b.length() - 1) -'0'));
		System.out.println(a * (b.charAt(b.length() - 2) -'0'));
		System.out.println(a * (b.charAt(b.length() - 3) -'0'));
		System.out.println(a * Integer.parseInt(b));
    }
}
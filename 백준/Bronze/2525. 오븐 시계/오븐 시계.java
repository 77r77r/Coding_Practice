import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();

		int time = h * 60 + m + t;

		System.out.println((time / 60) % 24 + " " + time % 60);
	}
}
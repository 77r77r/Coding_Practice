import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int m = sc.nextInt();

		int time = h * 60 + m - 45;

		if (time < 0) {
			time += 24 * 60;
		}

		System.out.println(time / 60);
		System.out.println(time % 60);
	}
}
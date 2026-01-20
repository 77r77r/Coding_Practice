import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int price = sc.nextInt();
		int cnt = sc.nextInt();

		for (int i = 0; i < cnt; i++){
			int p = sc.nextInt();
			int c = sc.nextInt();

			price -= p*c;
		}

		if (price == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
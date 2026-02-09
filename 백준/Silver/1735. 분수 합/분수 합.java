import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int num[][] = new int[2][2];

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			int gcd = reduce(num1, num2);

			if (gcd != 1) {
				num1 /= gcd;
				num2 /= gcd;
			}

			num[i][0] = num1;
			num[i][1] = num2;
		}

		int numerator = 0;
		int denominator = 0;

		if (num[0][1] == num[1][1]) {
			numerator = num[0][0] + num[1][0];
			denominator = num[0][1];

			int gcd = reduce(numerator, denominator);

			if (gcd != 1) {
				numerator /= gcd;
				denominator /= gcd;
			}
			
		} else {
			// 분모의 배수
			int max = Math.max(num[0][1], num[1][1]);
			int min = Math.min(num[0][1], num[1][1]);

			int lcm = max;
			int count = 1;

			while (true) {
				lcm = max * count;
				if (lcm % min == 0) {
					break;
				}
				count++;
			}

			int multiple1 = lcm / num[0][1];
			int multiple2 = lcm / num[1][1];

			numerator = num[0][0] * multiple1 + num[1][0] * multiple2;
			denominator = lcm;

			int gcd = reduce(numerator, denominator);

			if (gcd != 1) {
				numerator /= gcd;
				denominator /= gcd;
			}
		}

		bw.write(numerator + " " + denominator);

		bw.flush();
		br.close();
		bw.close();
	}

	static int reduce(int num1, int num2) {
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);

		int gcd = 1;

		for (int i = min; i > 1; i--) {
			if (max % i == 0 && min % i == 0) {
				gcd = i;
				break;
			}
		}

		return gcd;
	}
}
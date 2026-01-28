import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());

			if (num1 == 0 && num2 == 00 && num3 == 0) {
				break;
			}

			int max = Math.max(num1, Math.max(num2, num3));
			int sum = num1 + num2 + num3;

			if (max >= sum - max) {
				bw.write("Invalid\n");
			} else if (num1 == num2 && num2 == num3) {
				bw.write("Equilateral\n");
			} else if (num1 == num2 || num2 == num3 || num1 == num3) {
				bw.write("Isosceles\n");
			} else {
				bw.write("Scalene\n");
			}

		}

		br.close();
		bw.close();
	}
}
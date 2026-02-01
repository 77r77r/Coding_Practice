import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int target = Integer.parseInt(br.readLine());
		boolean check = false;

		for (int i = 1; i < target; i++) {
			// i의 각 자리수 나눠서 더해주기
			int sum = i;
			int temp = i;

			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}

			if (sum == target) {
				check = true;
				bw.write(String.valueOf(i));
				break;
			}
		}

		if (!check) {
			bw.write("0");
		}

		br.close();
		bw.close();
	}
}
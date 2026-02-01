import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int target = Integer.parseInt(br.readLine());
		int kg5 = 0, kg3 = 0;
		int sum = 0;

		while (true) {
			if (sum > target) {
				break;
			}
			sum += 5;
			kg5++;
		}

		while (true) {
			if (sum > target) {
				if (kg5 > 0) {
					sum -= 5;
					kg5--;
				} else {
					bw.write("-1");
					break;
				}
			}

			if (sum == target) {
				bw.write(kg5 + kg3 + "");
				break;
			}

			sum += 3;
			kg3++;
		}

		br.close();
		bw.close();
	}
}
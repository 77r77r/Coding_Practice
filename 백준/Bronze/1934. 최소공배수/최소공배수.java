import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int inputSize = Integer.parseInt(br.readLine());

		while (inputSize-- > 0) {
			st = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			if (num1 == num2) {
				bw.write(String.valueOf(num1) + "\n");
				continue;
			}

			int max = num1 > num2 ? num1 : num2;
			int min = num1 > num2 ? num2 : num1;
			int lcm = max;

			while (true) {
				if (lcm % min == 0) {
					bw.write(String.valueOf(lcm) + "\n");
					break;
				}
				lcm += max;
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
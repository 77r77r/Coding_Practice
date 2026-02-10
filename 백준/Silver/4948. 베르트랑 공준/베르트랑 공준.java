import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());

		do {
			int count = 0;

			for (int i = input + 1; i <= input * 2; i++) {
				boolean isPrime = true;

				if (i == 1) {
					continue;
				}

				if (i == 2 || i == 3) {
					count++;
					continue;
				}

				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime) {
					count++;
				}
			}

			bw.write(count + "\n");
			input = Integer.parseInt(br.readLine());
		} while (input != 0);

		bw.flush();
		br.close();
		bw.close();
	}
}
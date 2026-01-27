import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int count = 0;

		for (int i = 0; i < size; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isPrime = true;

			if (num == 1) {
				continue;
			}

			if (num == 2 || num == 3) {
				count++;
				continue;
			}

			for (int j = 2; j * j <= num; j++) {
				if (num % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				count++;
			}
		}

		bw.write(String.valueOf(count));

		br.close();
		bw.close();
	}
}
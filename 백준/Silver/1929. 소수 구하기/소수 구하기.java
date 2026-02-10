import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// m 이상 n 이하
		for (int i = m; i <= n; i++) {
			boolean isPrime = true;

			if (i == 1) {
				continue;
			}

			if (i == 2) {
				bw.write(i + "\n");
				continue;
			}

			// 소수인지 확인
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
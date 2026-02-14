import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int valueN = 1;
		int valueK = 1;

		if (k == 0 || n == k) {
			bw.write("1");
		} else {

			// N!
			for (int i = 1; i <= n; i++) {
				valueN *= i;
			}

			// K!
			for (int i = 1; i <= k; i++) {
				valueK *= i;
			}

            // (N-K)!
			for (int i = 1; i <= n - k; i++) {
				valueK *= i;
			}

			bw.write(String.valueOf(valueN / valueK));
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
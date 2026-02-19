import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		long n = Long.parseLong(br.readLine());

		bw.write(String.valueOf(fibonacci(n)));

		bw.flush();
		br.close();
		bw.close();
	}

	private static long fibonacci(long n) {
		if (n == 2 || n == 1) {
			return 1;
		}

		if (n == 0) {
			return 0;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
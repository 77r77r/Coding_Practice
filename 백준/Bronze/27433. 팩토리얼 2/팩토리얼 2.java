import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		long n = Long.parseLong(br.readLine());
		long value = 1;

		if (n != 0) {
			for (long i = 1; i <= n; i++) {
				value *= i;
			}
		}

		bw.write(String.valueOf(value));

		bw.flush();
		br.close();
		bw.close();
	}
}
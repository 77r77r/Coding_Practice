import java.io.*;
import java.util.*;

class Main {
	static long value = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());

		func(a, b, c);

		bw.write(String.valueOf(value));

		bw.flush();
		br.close();
		bw.close();
	}

	static void func(long a, long pow, long c) {
		if (pow == 1) {
			value = value * (a % c) % c;
			return;
		}
		if (pow % 2 == 0) {
			func((a % c) * (a % c), pow / 2, c);
		} else {
			value = value * (a % c) % c;
			func((a % c) * (a % c), (pow - 1) / 2, c);
		}
	}
}
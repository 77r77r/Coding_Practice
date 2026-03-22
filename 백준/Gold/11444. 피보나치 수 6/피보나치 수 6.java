import java.io.*;
import java.util.*;

class Main {
	static final int mod = 1000000007;
	static Map<Long, Long> dp = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());

		// 행렬 이용하기
		// F(n + 1) F(n)
		// F(n)  F(n-1)

		// F(2k) = F(k) * (2 * F(k + 1) - F(k))
		// F(2k + 1) = F(k + 1)^2 + F(k)^2;

		bw.write(fibonacci(n) + "");

		bw.flush();
		br.close();
		bw.close();
	}

	static long fibonacci(long k) {
		if (k == 3) {
			return 2;
		}

		if (k == 1 || k == 2) {
			return 1;
		}

		if (k == 0) {
			return 0;
		}

		if (dp.containsKey(k)) {
			return dp.get(k);
		}

		long temp;

		if (k % 2 == 0) {
			long x = (k / 2);
			long a = fibonacci(x) % mod;
			long b = fibonacci(x + 1) % mod;
			temp = (a * ((2 * b - a + mod) % mod)) % mod;
		} else {
			long x = ((k - 1) / 2);
			long a = fibonacci(x + 1) % mod;
			long b = fibonacci(x) % mod;
			temp = ((a * a) % mod + (b * b) % mod) % mod;
		}

		dp.put(k, temp);
		return temp;
	}
}
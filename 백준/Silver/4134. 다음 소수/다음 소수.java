import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long size = Long.parseLong(br.readLine());

		while (size-- > 0) {
			long num = Long.parseLong(br.readLine());
			long prime = num;

			while (true) {
				if (isPrime(prime)) {
					bw.write(prime + "\n");
					break;
				}
				prime++;
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static boolean isPrime(long num) {
		if (num == 0 || num == 1) {
			return false;
		}
		if (num == 2) {
			return true;
		}

		for (long i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
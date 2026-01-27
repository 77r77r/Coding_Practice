import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());

		int count = 0;
		int sum = 0;
		int min = start;

		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				if (count == 0) {
					min = i;
				}

				sum += i;
				count++;
			}
		}

		if (count > 0) {
			bw.write(String.valueOf(sum) + "\n" + String.valueOf(min));
		} else {
			bw.write(String.valueOf(-1));
		}

		br.close();
		bw.close();
	}

	static boolean isPrime(int num) {
		boolean prime = true;
		
		if (num == 1) {
			return false;
		}

		if (num == 2 || num == 3) {
			return true;
		}

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				prime = false;
				break;
			}
		}

		return prime;
	}
}
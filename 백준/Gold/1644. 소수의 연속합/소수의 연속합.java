import java.io.*;
import java.util.*;

class Main {
	static boolean[] isPrime;
	static List<Integer> primeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());

		// num 이하의 소수 확인
		findPrime(num);

		int left = 0;
		int right = 0;
		int sum = 0;
		int count = 0;

		while (true) {
			if (sum >= num) {
				if (sum == num) {
					count++;
				}

				if (left == primeList.size()) {
					break;
				}

				sum -= primeList.get(left++);
			} else {
				if (right == primeList.size()) {
					break;
				}
				sum += primeList.get(right++);
			}
		}

		bw.write(count + "");

		bw.flush();
		br.close();
		bw.close();
	}

	static void findPrime(int num) {
		isPrime = new boolean[num + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= num; i++) {
			if (isPrime[i]) {
				// i의 배수 전부
				for (int j = i * i; j <= num; j = j + i) {
					isPrime[j] = false;
				}
			}
		}
		
		for (int i = 2; i <= num; i++) {
			if (isPrime[i]) {
				primeList.add(i);
			}
		}
	}
}
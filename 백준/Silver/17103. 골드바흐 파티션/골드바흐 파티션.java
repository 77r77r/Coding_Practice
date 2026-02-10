import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int[] input = new int[size];
		int max = 0;

		for (int i = 0; i < size; i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, input[i]);
		}

		// 소수 값 배열
		boolean[] prime = new boolean[max + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int i = 2; i * i <= max; i++) {
			if (prime[i]) {
				// 배수 처리
				for (int j = i * i; j <= max; j += i) {
					prime[j] = false;
				}
			}
		}

		// 입력값 확인
		for (int i = 0; i < size; i++) {
			int num = input[i];
			int count = 0;

			for (int j = 2; j <= num / 2; j++) {
				if (prime[num - j] && prime[j]) {
					count++;
				}
			}
			bw.write(count + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
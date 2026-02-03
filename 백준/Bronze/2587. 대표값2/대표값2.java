import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] numbers = new int[5];

		for (int i = 0; i < 5; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 4 - j; k++) {
				if (numbers[k] > numbers[k + 1]) {
					int temp = numbers[k];
					numbers[k] = numbers[k + 1];
					numbers[k + 1] = temp;
				}
			}
		}
		int sum = 0;
		for (int n : numbers) {
			sum += n;
		}

		bw.write(String.valueOf(sum /5 + "\n" + numbers[2]));

		br.close();
		bw.close();
	}
}
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int[] numbers = new int[size];
		int location = 0;

		for (int i = 0; i < size; i++) {
			int input = Integer.parseInt(br.readLine());
			location = i;

			if (i == 0) {
				numbers[0] = input;
			} else {
				for (int j = 0; j < i; j++) {
					if (input < numbers[j]) {
						location = j;
						break;
					}
				}

				if (i == location) {
					numbers[location] = input;
				} else {
					for (int k = i; k > location; k--) {
						numbers[k] = numbers[k - 1];
						numbers[k - 1] = input;
					}
				}
			}
		}

		for (int n : numbers) {
			bw.write(n + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int[] cards = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int maxSum = 0;

		for (int i = n - 1; i >= 2; i--) {
			for (int j = i - 1; j >= 1; j--) {
				for (int k = j - 1; k >= 0; k--) {
					int sum = cards[i] + cards[j] + cards[k];
					if (sum <= target) {
						maxSum = maxSum < sum ? sum : maxSum;
					}
				}
			}
		}

		bw.write(String.valueOf(maxSum));

		br.close();
		bw.close();
	}
}
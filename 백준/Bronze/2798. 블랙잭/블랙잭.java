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

		Arrays.sort(cards);
		int maxSum = 0;

		//i 5
		for (int i = n - 1; i >= 2; i--) {
			// 모든 경우의 수 해보기
			// 9 8 7 6 5
			for (int j = i - 1; j >= 1; j--) {
				// i = 5, j = 4
				// 8 7 6 5
				for (int k = j - 1; k >= 0; k--) {
					// i = 5, j = 4, k =3
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
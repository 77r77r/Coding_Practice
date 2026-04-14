import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0;
		int right = n - 1;

		int hap = Integer.MAX_VALUE;
		int answerL = 0;
		int answerR = 0;

		while (left < right) {
			int sum = arr[left] + arr[right];

			if (sum == 0) {
				answerL = arr[left];
				answerR = arr[right];
				break;
			}

			// 절대값 비교
			if (hap > Math.abs(sum)) {
				answerL = arr[left];
				answerR = arr[right];
				hap = Math.abs(sum);
			}

			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		bw.write(answerL + " " + answerR);

		bw.flush();
		br.close();
		bw.close();
	}
}
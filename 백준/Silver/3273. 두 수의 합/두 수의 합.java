import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int answer = 0;

		int left = 0;
		int right = n - 1;

		// 1 2 3 5 7 9 10 11 12
		// 0 1 2 3 4 5 6 7 8 9
		while (true) {
			if (left >= right) {
				break;
			}

			if (arr[left] + arr[right] == x) {
				left++;
				right--;
				answer++;
			} else if (arr[left] + arr[right] > x) {
				right--;
			} else if (arr[left] + arr[right] < x) {
				left++;
			}
		}

		bw.write(answer + "");

		bw.flush();
		br.close();
		bw.close();
	}
}
import java.io.*;
import java.util.*;

class Main {
	static long n, length = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		n = Long.parseLong(st.nextToken());

		arr = new int[k];

		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		bw.write(slice(1, arr[k - 1]) + "");

		bw.flush();
		br.close();
		bw.close();
	}

	static long slice(long left, long right) {
		if (left > right) {
			return length;
		}
		long target = 0;
		long mid = (left + right) / 2;

		for (int i = 0; i < arr.length; i++) {
			target += arr[i] / mid;
		}

		if (target >= n) {
			length = mid;
			return slice(mid + 1, right);
		} else {
			return slice(left, mid - 1);
		}
	}
}
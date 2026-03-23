import java.io.*;
import java.util.*;

class Main {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (find(num, 0, n - 1)) {
				bw.write("1\n");
			} else {
				bw.write("0\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	// start = 0, end = 5
	static boolean find(int k, int start, int end) {
		int len = end - start;
		int mid = (start + end) / 2;    // 2

		if (start > end) {
			return false;
		}

		if (k == arr[mid]) {
			return true;
		}

		if (k < arr[mid]) {
			if (find(k, start, mid - 1)) {
				// 0 ~ 2 : 0 1
				return true;
			}
		} else {
			if (find(k, mid + 1, end)) {
				//2 ~ 5 : 2 3 4
				return true;
			}
		}
		return false;
	}
}
import java.io.*;
import java.net.Inet4Address;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] tree = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(tree);

		long height = 0;
		long min = 1;
		long max = tree[n - 1];

		while (min <= max) {
			long mid = (min + max) / 2;
			long sum = 0;

			for (int i = 0; i < n; i++) {
				if (tree[i] > mid) {
					sum += tree[i] - mid;
				}
			}

			if (sum >= m) {
				height = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		bw.write(height + "");

		bw.flush();
		br.close();
		bw.close();
	}
}
import java.io.*;
import java.util.*;

class Main {
	static int[] arr;
	static int n, weight;

	// 왼쪽 / 오른쪽 부분집합 합을 저장할 리스트
	static List<Long> leftList = new ArrayList<>();
	static List<Long> rightList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		weight = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 경우의 수 구하기
		dfs(0, n / 2, 0, leftList);
		dfs(n / 2, n, 0, rightList);

		Collections.sort(rightList);

		long count = 0;

		for (long lSum : leftList) {

			if (lSum > weight) {
				continue;
			}

			long remain = weight - lSum;

			int left = 0;
			int rigth = rightList.size();

			while (left < rigth) {
				int mid = (left + rigth) / 2;

				if (rightList.get(mid) <= remain) {
					left = mid + 1;
				} else {
					rigth = mid;
				}
			}
			count += left;
		}

		bw.write(count + "");

		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int start, int end, long sum, List<Long> list) {
		if (sum > weight) {
			return;
		}

		if (start == end) {
			list.add(sum);
			return;
		}

		dfs(start + 1, end, sum, list);
		dfs(start + 1, end, sum + arr[start], list);
	}
}
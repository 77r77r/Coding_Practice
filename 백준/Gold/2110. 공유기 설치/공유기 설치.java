import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] house = new int[n];

		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);

		// left ~ right : 설치 가능한 거리
		int left = 1;
		int right = house[n - 1] - house[0];
		int distance = 0;

		while (left <= right) {
			int mid = (left + right) / 2;    // 설치 간격

			int last = house[0];    // 마지막 설치 위치
			int count = 1;

			for (int i = 1; i < n; i++) {
				if (house[i] - last >= mid) {
					count++;
					last = house[i];
				}
			}

			if (count >= c) {
				distance = mid;     // 이 간격으로 설치 가능
				left = mid + 1;     // 간격 늘이기
			} else {
				right = mid - 1;    // 간격 줄이기
			}
		}

		bw.write(String.valueOf(distance));

		bw.flush();
		br.close();
		bw.close();
	}
}
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[] road = new long[n - 1];
		long[] price = new long[n];
		long money = 0;    // 비용

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		// 최소 다음 구역까지 넣을 수 밖에 없음
		money += price[0] * road[0];

		long min = price[0];

		// 내 이후에 나보다 싼 가격이 있는지 확인?

		for (int i = 1; i < n - 1; i++) {
			min = Math.min(min, price[i]);
			money += road[i] * min;
		}

		bw.write(String.valueOf(money));

		bw.flush();
		br.close();
		bw.close();
	}
}
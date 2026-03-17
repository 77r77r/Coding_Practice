import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] schedule = new int[n][2];
		int count = 1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}

		// 종료 시간 오름차순 정렬
		Arrays.sort(schedule, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		int end = schedule[0][1];

		for (int i = 1; i < n; i++) {
			if (end <= schedule[i][0]) {
				count++;
				end = schedule[i][1];
			}
		}

		bw.write(String.valueOf(count));

		bw.flush();
		br.close();
		bw.close();
	}
}
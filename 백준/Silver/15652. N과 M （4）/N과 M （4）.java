import java.io.*;
import java.util.*;

class Main {
	static int range, size;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		range = Integer.parseInt(st.nextToken());
		size = Integer.parseInt(st.nextToken());

		result = new int[size];
		result[0] = 0;

		pick(0, 1);

		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	static void pick(int depth, int n) {
		// 종료 조건
		if (depth == size) {
			for (int i = 0; i < size; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 비내림차순, n = 이전 값
		for (int i = n; i <= range; i++) {
			result[depth] = i;
			pick(depth + 1, i);
		}
	}
}
import java.io.*;
import java.util.*;

import javax.swing.*;

class Main {
	static int range, size;
	static boolean[] used;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		range = Integer.parseInt(st.nextToken());
		size = Integer.parseInt(st.nextToken());

		used = new boolean[range + 1];
		result = new int[size];

		pick(0, 1);

		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	static void pick(int depth, int n) {
		// 종료조건
		if (depth == size) {
			for (int i = 0; i < size; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 현재 값 이후로만 확인
		for (int i = n; i <= range; i++) {
			if (used[i]) {
				continue;
			}

			used[i] = true;
			result[depth] = i;
			pick(depth + 1, i + 1);
			used[i] = false;
		}
	}
}
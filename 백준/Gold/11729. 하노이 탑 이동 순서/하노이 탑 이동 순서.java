import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 1 << n 연산 : 2^n
		bw.write(String.valueOf((1 << size) - 1) + "\n");
		move(size, 1, 3, 2, sb);

		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	private static void move(int n, int from, int to, int by, StringBuilder sb) {
		// from : 시작, to : 목표, by: 보조

		if (n == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}

		/**
		 * A(from) -> B(by)로 n-1개의 원판을 옮긴다.
		 * n-1개가 다 옮겨졌다면 A(from) -> C(to)로 1개의 원판을 옮겨놓는다.
		 * 후에 B(by) -> C(to)로 다시 n - 1개의 원판을 옮긴다.
		 */
		move(n - 1, from, by, to, sb);
		sb.append(from + " " + to + "\n");
		move(n - 1, by, to, from, sb);
	}
}
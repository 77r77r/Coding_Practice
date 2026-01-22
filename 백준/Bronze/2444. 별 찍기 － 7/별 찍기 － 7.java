import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 2n -1
		// for (int col = 0; col < 2 * N - 1; col++) {
		for (int col = 0; col < N; col++) {
			StringBuilder sb = new StringBuilder();
			String blank = " ";
			// 공백 = N - col
			sb.append(blank.repeat(N - 1 - col));

			// 별찍기
			String star = "*";
			// 0 -> 1 개 2n + 1
			// 1 -> 3 개 2n + 1
			sb.append(star.repeat(2 * col + 1));
			bw.write(sb.toString() + "\n");
		}

		for (int col = N - 1; col > 0; col--) {
			StringBuilder sb = new StringBuilder();
			String blank = " ";
			// 공백 = N - col
			sb.append(blank.repeat(N - col));

			// 별찍기
			String star = "*";
			// 4 -> 7 개 2n -1
			// 3 -> 5 개 2n -1
			// 2 -> 3 개
			// 1 -> 1 개
			sb.append(star.repeat(2 * col - 1));
			bw.write(sb.toString() + "\n");
		}

		bw.close();
	}
}
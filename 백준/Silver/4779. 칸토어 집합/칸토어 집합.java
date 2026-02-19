import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line;

		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			int len = 1;

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				len *= 3;
			}
			sb.append("-".repeat(len));

			getDivideIntoThree(sb, 0, sb.length() - 1);

			bw.write(sb.toString() + "\n");
			bw.flush();
		}

		br.close();
		bw.close();
	}

	private static void getDivideIntoThree(StringBuilder sb, int start, int end) {
		int len = end - start + 1;

		if (len < 3) {
			return;
		}

		int third = len / 3;

		// 중간 공백 변경
		sb.replace(start + third, start + third * 2, " ".repeat(third));

		getDivideIntoThree(sb, start, start + third - 1);
		getDivideIntoThree(sb, start + third * 2, end);
	}
}

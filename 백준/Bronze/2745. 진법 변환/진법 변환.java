import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] line = br.readLine().split(" ");

		String text = line[0];
		int num = Integer.parseInt(line[1]);
		int cn;
		long result = 0;
		int cnt = 0;

		int len = text.length();
		for (int i = len - 1; i >= 0; i--) {
			char c = text.charAt(i);

			if ('0' <= c && c <= '9') {
				cn = c - '0';
			} else {
				cn = (int)c - 55;
			}

			result += cn * f1(num, cnt++);
		}

		bw.write(String.valueOf(result));

		br.close();
		bw.close();
	}

	public static long f1(int n, int s) {
		long num = 1;

		for (int i = 0; i < s; i++) {
			num *= n;
		}

		return num;
	}
}
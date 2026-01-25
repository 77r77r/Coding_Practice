import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] line = br.readLine().split(" ");

		int num = Integer.parseInt(line[0]);
		int base = Integer.parseInt(line[1]);
		int quot = num;

		while (quot / base > 0) {
			int remainder = quot % base;

			quot /= base;

			char c = (char)(remainder + '0');

			if (remainder >= 10) {
				// 10 -> A;
				c = (char)(remainder + 55);
			}

			sb.append(String.valueOf(c));

		}

		if (quot >= 10) {
			sb.append((char)(quot + 55));
		} else {
			sb.append(quot);
		}

		bw.write(sb.reverse().toString());

		br.close();
		bw.close();
	}
}
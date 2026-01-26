import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int len = 0;
		int cnt = 0;

		// 1 -> 7 (+6) -> (+12) -> (+18)
		if (N != 1) {
			len = 1;
			for (int i = 1; i < N; i++) {
				if (cnt / (len * 6) == 1) {
					cnt = 0;
					len++;

				}
				cnt++;
			}
		}

		bw.write(String.valueOf(++len));

		br.close();
		bw.close();
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String[][] arrs = new String[5][15];
		// for, while 의 내부적인 차이?

		for (int n = 0; n < 5; n++) {
			String[] letters = br.readLine().split("");	// ABCDE
			int len = 0;

			for (String letter : letters) {
				arrs[n][len++] = letter;
			}
		}

		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				String temp = arrs[i][j];

				if (temp == null) {
					continue;
				}
				
				bw.write(temp);
			}
		}

		br.close();
		bw.close();
	}
}
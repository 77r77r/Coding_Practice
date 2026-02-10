import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int repeat = Integer.parseInt(br.readLine());

		while (repeat-- > 0) {
			String line = br.readLine();
			int count = 0;

			for (char c : line.toCharArray()) {
				if (count < 0) {
					break;
				}

				if (c == '(') {
					count++;
				} else {
					count--;
				}
			}

			if (count == 0) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
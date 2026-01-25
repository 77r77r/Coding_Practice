import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int money = Integer.parseInt(br.readLine());
			int temp = money;

			int q = 0, d = 0, n = 0, p = 0;

			q = temp / 25;
			temp -= q * 25;

			d = temp / 10;
			temp -= d * 10;

			n = temp / 5;
			temp -= n * 5;

			p = temp;

			bw.write(q + " " + d + " " + n + " " + p + "\n");
		}

		br.close();
		bw.close();
	}
}
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;

		for (int k = coin.length - 1; k >= 0; k--) {
			count += target / coin[k];
			target %= coin[k];

			if (target == 0) {
				break;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		br.close();
		bw.close();
	}
}
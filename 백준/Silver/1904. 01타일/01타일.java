import java.io.*;
import java.util.*;

class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];

		bw.write(make(n) + "");

		bw.flush();
		br.close();
		bw.close();
	}

	static int make(int n) {
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}

		arr[1] = 1;
		arr[2] = 2;

		for (int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
		}

		return arr[n];
	}
}
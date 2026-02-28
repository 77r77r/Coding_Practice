import java.io.*;

class Main {
	static long[] f = new long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());

		while (cnt-- > 0) {
			int n = Integer.parseInt(br.readLine());

			bw.write(func(n) + "\n");
			bw.flush();
		}

		br.close();
		bw.close();
	}

	static long func(int n) {
		f[1] = 1;
		f[2] = 1;
		f[3] = 1;

		for (int i = 4; i <= n; i++) {
			f[i] = f[i - 2] + f[i - 3];
		}

		return f[n];
	}
}
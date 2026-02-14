import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int value = 1;

		for (int i = 1; i <= N; i++) {
			value *= i;
		}

		bw.write(String.valueOf(value));

		bw.flush();
		br.close();
		bw.close();
	}
}
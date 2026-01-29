import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Integer.parseInt(br.readLine());

		bw.write(n * n + "\n2");

		br.close();
		bw.close();
	}
}
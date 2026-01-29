import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());
		long sum = 0;

		for (int i = 0; i < n - 2; i++) {
			sum += (i + 1) * ((n - 2) - i);

		}

		bw.write(sum + "\n3");
        
        br.close();
		bw.close();
	}
}
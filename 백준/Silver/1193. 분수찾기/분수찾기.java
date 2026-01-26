import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());

		int head = 0;
		int body = 0;

		int cnt = 0;
		int line = 1;
		
		for (int x = 0; x < X; x++) {

			if (cnt == line) {
				line++;
				cnt = 0;
			}

			if (l % 2 != 0) {
				head = line - cnt;
				body = 1 + cnt;
			} else {
				head = 1 + cnt;
				body = line - cnt;
			}

			cnt++;
		}

		bw.write(head + "/" + body);
		br.close();
		bw.close();
	}

}

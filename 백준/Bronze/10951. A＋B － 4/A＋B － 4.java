import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String line;

		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write((a + b) + "\n");
		}
		bw.close();
	}
}
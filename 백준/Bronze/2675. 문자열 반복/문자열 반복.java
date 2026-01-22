import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int cnt =  Integer.parseInt(br.readLine());
		int recnt = 0;

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			recnt = Integer.parseInt(st.nextToken());
			String[] words = st.nextToken().split("");

			for (String word : words) {
				bw.write(word.repeat(recnt));
			}
			bw.write("\n");
		}

		bw.close();
	}
}